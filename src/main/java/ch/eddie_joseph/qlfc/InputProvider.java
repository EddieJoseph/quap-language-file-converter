package ch.eddie_joseph.qlfc;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputProvider {

    public static final String ASPEC_CONFIG_PATH="aspect_config.csv";
    public static final String GERMAN_PATH="de.csv";
    public static final String FRENCH_PATH="de.csv";
    public static final String ITALIAN_PATH="de.csv";

    private CSVParser getCsvParser(){
        return new CSVParserBuilder().withSeparator(';').build();
    }

    public CSVReader getAspectConfig(){
        CSVReader reader=null;
        try {
            //System.out.println(getClass().getResourceAsStream("C:/Users/eddie/QuapLanguageFileConverter/"+ASPEC_CONFIG_PATH));
            reader = new CSVReaderBuilder(new InputStreamReader(new FileInputStream(ASPEC_CONFIG_PATH), "Cp1252")).withCSVParser(getCsvParser()).withSkipLines(1).build();
        } catch(IOException e){
            System.out.println("Error Reading Aspect File");
            e.printStackTrace();
            System.exit(-1);
        }
        return reader;
    }

    public CSVReader getGerman(){
        CSVReader reader=null;
        try {

            reader = new CSVReaderBuilder(new InputStreamReader(new FileInputStream(GERMAN_PATH), "Cp1252")).withCSVParser(getCsvParser()).withSkipLines(1).build();
        } catch(IOException e){
            System.out.println("Error Reading Aspect File");
            e.printStackTrace();
            System.exit(-1);
        }
        return reader;
    }

    public CSVReader getFrench(){
        CSVReader reader=null;
        try {

            reader = new CSVReaderBuilder(new InputStreamReader(new FileInputStream(FRENCH_PATH), "Cp1252")).withCSVParser(getCsvParser()).withSkipLines(1).build();
        } catch(IOException e){
            System.out.println("Error Reading Aspect File");
            e.printStackTrace();
            System.exit(-1);
        }
        return reader;
    }

    public CSVReader getItalian(){
        CSVReader reader=null;
        try {

            reader = new CSVReaderBuilder(new InputStreamReader(new FileInputStream(ITALIAN_PATH), "Cp1252")).withCSVParser(getCsvParser()).withSkipLines(1).build();
        } catch(IOException e){
            System.out.println("Error Reading Aspect File");
            e.printStackTrace();
            System.exit(-1);
        }
        return reader;
    }

}
