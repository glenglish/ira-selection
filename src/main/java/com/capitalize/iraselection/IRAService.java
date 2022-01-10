package com.capitalize.iraselection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@ApplicationScoped
public class IRAService {
    @Inject
    EntityManager _entityManager;

    IRA get(Long id) {
        return _entityManager.find(IRA.class, id);
    }

    List<IRA> getAll() {
        return _entityManager.createQuery("SELECT ira FROM IRA ira", IRA.class).getResultList();
    }

    /*
        TODO:
        Ideally, the matching should be done at the database level.

        Right now, I'm grabbing everything, calculating match results, sorting in reverse and returning the top 3

        Additionally, we could find a way to ignore fields that aren't being passed so they don't affect
        the calculated matching output.
     */
    List<IRA> search(IRAPrefs prefs) {
        List<IRAMatchResult> matchResults = new ArrayList<>();

        getAll().forEach(new Consumer<IRA>() {
            @Override
            public void accept(IRA ira) {
                IRAMatchResult result = ira.calculateMatch(prefs);
                matchResults.add(result);
            }
        });

        matchResults.sort(new Comparator<IRAMatchResult>() {
            @Override
            public int compare(IRAMatchResult o1, IRAMatchResult o2) {
                Integer match1 = Integer.valueOf(o1.match);
                Integer match2 = Integer.valueOf(o2.match);

                return -match1.compareTo(match2);
            }
        });

        // todo check to make sure 3+ results even exist
        List<IRA> top3 = matchResults.subList(0, 3).stream().map(new Function<IRAMatchResult, IRA>() {
            @Override
            public IRA apply(IRAMatchResult iraMatchResult) {
                return iraMatchResult.ira;
            }
        }).collect(Collectors.toList());

        return top3;
    }
}
