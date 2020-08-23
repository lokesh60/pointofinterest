package com.example.pointofinterest.model;

import java.util.List;

public class Items  implements Comparable<Items>{
    private String[] position;
    private int distance;
    private String title;
    private int averageRating;
    private String icon;
    private String vicinity;
    private String type;
    private String href;
    private String[] having;
    private String id;
    private Category category;
    private List<Tag> tags;
    private OpeningHours openingHours;

    public String[] getPosition() {
        return position;
    }

    public void setPosition(String[] position) {
        this.position = position;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String[] getHaving() {
        return having;
    }

    public void setHaving(String[] having) {
        this.having = having;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(OpeningHours openingHours) {
        this.openingHours = openingHours;
    }


    public int compareTo(Items item) {
        if (this.distance == item.distance) {
            return 0;
        } else if (this.distance > item.distance) {
            return 1;
        } else {
            return -1;
        }
    }
}

