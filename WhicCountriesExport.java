
/**
 * Write a description of WhicCountriesExport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import org.apache.commons.csv.*;
import edu.duke.*;

public class WhicCountriesExport {
    public void listExports(CSVParser parser, String exportOfInterest){
        // for each rom the csv file
        for (CSVRecord record : parser){        
            // look at the "Exports" column
            String export = record.get("Exports");
            // check if it contains exportOfInterest
            //if(export.indexOf(exportOfInterest) != -1) 
            if(export.contains(exportOfInterest)){
                // If so, write down the country
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public String countryInfo (CSVParser parser, String country){
        String info = "";
        for (CSVRecord record : parser){
            if (record.get("Country").contains(country))
                info = country + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
        }        
        if (info != "") {
            System.out.println(info);
        }
        else System.out.println("NOT FOUND");
        return info;
    }
    
    public void whoExportsCoffee(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //listExports(parser, "coffee");
        countryInfo (parser, "Germany");
    }
}
