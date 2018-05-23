package org.launchcode.ecatalogue.models;

public enum PartFieldType {

    PART_NAME("Part Name"),
    VENDOR ("Vendor"),
    DISCIPLINE ("Discipline"),
    ALL ("All");

    private final String name;

    PartFieldType(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }
}
