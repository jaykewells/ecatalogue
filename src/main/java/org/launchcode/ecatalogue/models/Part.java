package org.launchcode.ecatalogue.models;


import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * This object represents a single part for the website, and consists of
 * several objects to help avoid repetition of data.
 */
public class Part {

    private int id;
    private static int nextId = 1;

    private PartName name;           //Name of the Part
    private String partNum;             //Part's Number
    private Discipline discipline;      //General Discipline of the part.
    private String description;         //Description of the part.
    private Vendor vendor;              //Vendor of the part.
    private Float margin;               //FSI's Margin % for the part.
    private Float cost;                 //FSI's Cost for the part.
    private String price;                //Calculates a price based on the Margin and Cost provided.


    public Part() {

        id = nextId;
        nextId++;

    }

    public Part(PartName aName, String aPartNum, Discipline aDiscipline,
                String aDescription, Vendor aVendor, String aMargin,
                String aCost){

            name = aName; //Name of the part
            partNum = aPartNum; //Part Number
            discipline = aDiscipline; //General discipline of the part
            description = aDescription; //Description of the part
            vendor = aVendor; //Vendor of each part
            margin = Float.valueOf(aMargin); //Margin % for the part. Comes off of the CSV as a string
            cost = Float.valueOf(aCost); //FSI Cost for the part. Comes off the CSV as a string.
            DecimalFormat df = new DecimalFormat("#.##");
            df.setMinimumFractionDigits(2);
            df.setRoundingMode(RoundingMode.CEILING);
            price = df.format(((1+margin) * cost));

    }
    //GET/SET Pairs for all fields. Will eliminate as needed.
    public int getId(){ return id;}

    public PartName getName() { return name;}
    public void setName(PartName aName){ this.name = aName;}

    public String getPartNum() {return partNum;}
    public void setPartNum(String aPartNum){ this.partNum = aPartNum;}

    public Discipline getDiscipline() {return discipline;}
    public void setDiscipline(Discipline discipline) {this.discipline = discipline;}

    public String getDescription() { return description;}
    public void setDescription(String aDesc){ this.description = aDesc;}

    public Vendor getVendor(){ return vendor;}
    public void setVendor(Vendor aVendor){ this.vendor = aVendor;}


    //The input type for GET/SET here may have to be looked at as app develops.
    public Float getMargin(){ return margin;}
    private void setMargin(Float aMargin){ this.margin = aMargin;}

    public Float getCost() { return cost;}
    private  void setCost(Float aCost) { this.cost = aCost;}

    public String getPrice() {return price;}


    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Part part = (Part) o;

        return id == part.id;
    }

    @Override
    public int hashCode(){ return id; }
}
