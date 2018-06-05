package org.launchcode.ecatalogue.models.data;

import org.launchcode.ecatalogue.models.*;

import java.util.ArrayList;

public class PartData {

    private ArrayList<Part> parts = new ArrayList<>();
    private static PartData instance;

    private PartFieldData<Vendor> vendors = new PartFieldData<Vendor>();
    private PartFieldData<Discipline> disciplines = new PartFieldData<Discipline>();


    private PartData() {PartDataImporter.loadData(this);}


    public static PartData getInstance() {

        if (instance == null) {
            instance = new PartData();
            System.out.println("!!!!Successfully got Data Instance!!!!");
        }
        return instance;
    }

    public Part findById(int id) {
        for (Part part : parts){
            if (part.getId() == id)
                return part;
        }
        return null;
    }

    public ArrayList<Part> findAll() {return parts;}

    public ArrayList<Part> findByColumnAndValue(PartFieldType column, String value){

        ArrayList<Part> matchingParts = new ArrayList<>();

        for(Part part : parts)
            if (getFieldByType(part, column).contains(value))
                matchingParts.add(part);

        return matchingParts;
    }

    public ArrayList<Part> findByValue(String value) {

        ArrayList<Part> matchingParts = new ArrayList<>();

        for(Part part : parts){

            if (part.getName().contains(value)) {
                matchingParts.add(part);
                continue;
            }

            for (PartFieldType column : PartFieldType.values()){
                if (column != PartFieldType.ALL && getFieldByType(part, column).contains(value)){
                    matchingParts.add(part);
                    break;
                }
            }
        }

        return matchingParts;
    }

    public void add(Part part) {parts.add(part);}

    private static PartField getFieldByType(Part part, PartFieldType type){

        switch(type){
            case VENDOR:
                return part.getVendor();
            case DISCIPLINE:
                return part.getDiscipline();
            case PART_NAME:
                return part.getName();

        }

        throw new IllegalArgumentException("Cannot get field of type "+ type);
    }


    public PartFieldData<Vendor> getVendors() {return vendors;}

    public PartFieldData<Discipline> getDisciplines() {return disciplines;}


}
