package com.example.pointofinterest.model;

import java.util.List;

public class Results {
    private String next;
    private List<Items> items;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
