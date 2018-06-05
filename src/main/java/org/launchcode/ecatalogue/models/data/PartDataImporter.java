package org.launchcode.ecatalogue.models.data;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.launchcode.ecatalogue.models.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class PartDataImporter {

    private static final String DATA_FILE = "partdata.csv";
    private static boolean isDataLoaded = false;

    /**
     * Read in data from our mock CSV file and store it in a list.
     */
    static void loadData(PartData partData){

        if (isDataLoaded) {
            return;
        }

        try {
            //Open the CSV File and set up pull out column header info and records
            Resource resource = new ClassPathResource(DATA_FILE);
            InputStream is = resource.getInputStream();
            Reader reader = new InputStreamReader(is);
            CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            List<CSVRecord> records = parser.getRecords();
            Integer numberOfColumns = records.get(0).size();
            String[] headers = parser.getHeaderMap().keySet().toArray(new String[numberOfColumns]);


            // Force records into a friendlier format

            for (CSVRecord record : records) {

                String partNum = record.get("Item #");
                String vendor = record.get("Vendor");
                PartName partName = new PartName (record.get("Part Name"));
                String discipline = record.get("Discipline");
                String margin = record.get("Margin Factor");
                String cost = record.get("Direct Cost");
                String desc = record.get("Description");


                Vendor vend = partData.getVendors().findByValue(vendor);
                if (vend == null) {
                    vend = new Vendor(vendor);
                    partData.getVendors().add(vend);
                }

                Discipline disc = partData.getDisciplines().findByValue(discipline);
                if (disc == null) {
                    disc = new Discipline(discipline);
                    partData.getDisciplines().add(disc);
                }


                Part newPart = new Part(partName, partNum, disc, desc, vend, margin, cost);

                partData.add(newPart);
            }

            isDataLoaded = true;
        } catch (IOException e){
            System.out.println("Failed to load job data");
            e.printStackTrace();

        }
    }
}
