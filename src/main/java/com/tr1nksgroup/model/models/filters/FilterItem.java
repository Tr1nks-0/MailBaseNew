package com.tr1nksgroup.model.models.filters;

public class FilterItem {
    private Long id;
    private Boolean checked = false;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
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
