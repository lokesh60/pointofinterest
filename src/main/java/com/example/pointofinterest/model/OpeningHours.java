package com.example.pointofinterest.model;

import java.util.List;

public class OpeningHours {
    private String text;
    private String label;
    private boolean isOpen;
    private List<Structured> structured;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public List<Structured> getStructured() {
        return structured;
    }

    public void setStructured(List<Structured> structured) {
        this.structured = structured;
    }
}
