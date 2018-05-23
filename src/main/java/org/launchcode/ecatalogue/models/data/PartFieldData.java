package org.launchcode.ecatalogue.models.data;


import org.launchcode.ecatalogue.models.PartField;

import java.util.ArrayList;

public class PartFieldData<T extends PartField> {

    private ArrayList<T> allFields = new ArrayList<>();

    public ArrayList<T> findAll() {return allFields;}

    public T findByID(int id){

        for (T item : allFields){
            if (item.getId() == id)
                return item;
        }

        return null;
    }

    public void add(T item) {allFields.add(item);}

    T findByValue(String value) {
        for (T item : allFields){
            if (item.contains(value))
                return item;
        }

        return null;
    }


}
