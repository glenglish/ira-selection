package com.capitalize.iraselection;

public class IRAMatchResult {
    IRA ira;
    int match;
    IRAPrefs prefs;

    public IRAMatchResult(IRA ira, int match, IRAPrefs prefs) {
        this.ira = ira;
        this.match = match;
        this.prefs = prefs;
    }
}
