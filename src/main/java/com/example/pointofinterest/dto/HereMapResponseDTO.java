package com.example.pointofinterest.dto;

import com.example.pointofinterest.model.Results;
import com.example.pointofinterest.model.Search;

public class HereMapResponseDTO {
    private Results results;
    private Search search;

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }
}
