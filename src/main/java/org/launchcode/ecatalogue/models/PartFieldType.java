package org.launchcode.ecatalogue.models;

public enum PartFieldType {
    ALL ("All"),
    PART_NAME("Part Name"),
    VENDOR ("Vendor"),
    DISCIPLINE ("Discipline");


    private final String name;

    PartFieldType(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }
}
