package com.capitalize.iraselection;

/**
 * TODO: Should the matching calculation find a way to exclude a field if it's not important?
 */
public class IRAPrefs {
    int easeOfUseMax = 5;
    int easeOfUseMin = 1;

    float feesMax = 1.0f;
    float feesMin = 0.0f;

    float minBalanceMax = 99999999.0f;
    float minBalanceMin = 0.0f;

    boolean automated = false;
    boolean advisor = false;

    public int calculateMatch(IRA ira) {
        int result = 0;

        // Minimum Balance
        if(ira.getMinimumBalance() >= minBalanceMin && ira.getMinimumBalance() <= minBalanceMax) {
            result += 20;
        }

        // Fees
        if(ira.getFees() >= feesMin && ira.getFees() <= feesMax ) {
            result += 20;
            System.out.println("Fees Match");
        }

        // Ease of Use
        if(ira.getEaseOfUse() >= easeOfUseMin && ira.getEaseOfUse() <= easeOfUseMax ) {
            result += 20;
        }

        // Advisor Available
        if(advisor == ira.isAdvisorAvailable()) {
            result += 20;
        }

        // Automated
        if(automated == ira.isAutomated()) {
            result += 20;
        }

        return result;
    }
}
