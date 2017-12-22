package com.tr1nksgroup.model.models.filters;

public class FilterItem {
    private long id;
    private boolean checked = false;
    private String name;
    private String abbr;

    public FilterItem(long id, String name, String abbr) {
        this.id = id;
        this.name = name;
        this.abbr = abbr;
    }

    public FilterItem(long id, String name) {
        this.id = id;
        this.name = name;
        this.abbr = name;
    }

    public FilterItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }
}
