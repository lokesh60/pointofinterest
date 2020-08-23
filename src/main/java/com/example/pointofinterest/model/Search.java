package com.example.pointofinterest.model;

public class Search {
    private  boolean supportsPanning;
    private String ranking;
    private Context context;

    public boolean isSupportsPanning() {
        return supportsPanning;
    }

    public void setSupportsPanning(boolean supportsPanning) {
        this.supportsPanning = supportsPanning;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
