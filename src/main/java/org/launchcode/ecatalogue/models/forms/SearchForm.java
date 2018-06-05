package org.launchcode.ecatalogue.models.forms;

import org.launchcode.ecatalogue.models.PartFieldType;

public class SearchForm {

    private PartFieldType[] fields = PartFieldType.values();

    private PartFieldType searchField = PartFieldType.ALL;

    private String keyword;

    public PartFieldType getSearchField() { return searchField;}
    public void setSearchField(PartFieldType searchField){ this.searchField = searchField;}

    public PartFieldType[] getFields() { return fields;}

    public String getKeyword() { return keyword;}
    public void setKeyword(String keyword) { this.keyword = keyword;}
}
