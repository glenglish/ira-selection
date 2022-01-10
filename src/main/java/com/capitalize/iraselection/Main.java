package com.capitalize.iraselection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Main {
    public static void main(String [] args) {
        List<IRA> iras = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < 10; i++) {

            IRA ira = new IRA();
            ira.setBankName(String.valueOf(i));

            if(random.nextInt() % 2 == 0) {
                ira.setAdvisorAvailable(true);
            }

            if(random.nextInt() % 4 == 0) {
                ira.setAutomated(true);
            }
            ira.setFees(random.nextFloat());
            ira.setMinimumBalance(random.nextFloat());

            iras.add(ira);
        }

        iras.sort(new Comparator<IRA>() {
            @Override
            public int compare(IRA o1, IRA o2) {
                return Float.valueOf(o1.getFees()).compareTo(Float.valueOf(o2.getFees()));
            }
        });

        iras.forEach(new Consumer<IRA>() {
            @Override
            public void accept(IRA ira) {
                System.out.println(ira.getBankName() + " " + ira.getFees());
            }
        });

        iras.subList(iras.size() - 3, iras.size()).forEach(new Consumer<IRA>() {
            @Override
            public void accept(IRA ira) {
                System.out.println(ira.getBankName() + " " + ira.getFees());
            }
        });
    }
}
