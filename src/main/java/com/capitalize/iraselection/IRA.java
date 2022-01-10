package com.capitalize.iraselection;

import javax.persistence.*;

@Entity
public class IRA {
    @Id
    @SequenceGenerator(name = "ira_seq", sequenceName = "ira_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ira_seq")
    private Long id;
    private String bankName;
    private String description;
    private float minimumBalance;
    private float fees;
    private int easeOfUse;
    private boolean isAutomated;
    private boolean advisorAvailable;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(float minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public float getFees() {
        return fees;
    }

    public void setFees(float fees) {
        this.fees = fees;
    }

    public int getEaseOfUse() {
        return easeOfUse;
    }

    public void setEaseOfUse(int easeOfUse) {
        this.easeOfUse = easeOfUse;
    }

    public boolean isAutomated() {
        return isAutomated;
    }

    public void setAutomated(boolean automated) {
        isAutomated = automated;
    }

    public boolean isAdvisorAvailable() {
        return advisorAvailable;
    }

    public void setAdvisorAvailable(boolean advisorAvailable) {
        this.advisorAvailable = advisorAvailable;
    }

    @Override
    public String toString() {
        return "IRA [id=" + id + ", bankName=" + bankName + ", description=" + description + ", minimumBalance="
                +  minimumBalance + ", fees=" +  fees + ", easeOfUser=" +  easeOfUse +
                ", advisorAvailable=" +  advisorAvailable + ", isAutomated=" + isAutomated + "]";
    }

    public IRAMatchResult calculateMatch(IRAPrefs prefs) {
        return new IRAMatchResult(this, prefs.calculateMatch(this), prefs);
    }
}
