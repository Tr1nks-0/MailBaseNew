package com.tr1nksgroup.model.models.filters;

import java.util.ArrayList;
import java.util.List;

public class FilterModel {
    private List<FilterPair> filterPairsList = new ArrayList<>();

    public FilterModel(List<FilterPair> filterLists) {
        this.filterPairsList = filterLists;
    }

    public FilterModel() {
    }

    public List<FilterPair> getFilterPairsList() {
        return filterPairsList;
    }

    public void setFilterPairsList(List<FilterPair> filterPairsList) {
        this.filterPairsList = filterPairsList;
    }

    public void addFilterListPair(FilterPair filterListFilterPair) {
        this.filterPairsList.add(filterListFilterPair);
    }
}
