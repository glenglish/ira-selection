package com.capitalize.iraselection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class IRAGroupService {
    @Inject
    EntityManager _entityManager;

    IRAGroup get(Long id) {
        return _entityManager.find(IRAGroup.class, id);
    }

    List<IRAGroup> getAll() {
        return _entityManager.createQuery("SELECT ig FROM IRAGroup ig", IRAGroup.class).getResultList();
    }
}
