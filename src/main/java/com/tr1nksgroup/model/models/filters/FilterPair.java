package com.tr1nksgroup.model.models.filters;

import java.io.Serializable;
import java.util.List;

public class FilterPair implements Serializable {
    private String title;
    private int id;
    private List<FilterItem> itemsList;

    public FilterPair(String title, int id, List<FilterItem> itemsList) {
        this.title = title;
        this.itemsList = itemsList;
        this.id = id;
    }

    public FilterPair() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<FilterItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<FilterItem> itemsList) {
        this.itemsList = itemsList;
    }
}