package ch.eddie_joseph.qlfc;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.io.input.BOMInputStream;

public class InputProvider {

    public static final String INPUT_PATH = "input/";

    public static final String ASPECT_FILE_NAME = "aspects";
    public static final String QUESTION_FILE_NAME = "questions";
    public static final String QUESTION_CONFIG_NAME = "question_config";
    public static final String ASPEC_CONFIG_PATH = "aspect_config.csv";
    //public static final String CHARSET = "Cp1252";
    public static final String CHARSET = "UTF-8";
    private static Logger logger = LogManager.getLogger(InputProvider.class);

    private CSVParser getCsvParser() {
        return new CSVParserBuilder().withSeparator(';').build();
    }

    private void handleCriticalError(String message, Exception e) {
        logger.error(message, e);
        e.printStackTrace();
        System.exit(-1);
    }

    public CSVReader getQuestionConfig() {
        CSVReader reader = null;
        try {
            logger.debug("loading question config file");
            reader = new CSVReaderBuilder(new InputStreamReader(new BOMInputStream(new FileInputStream(INPUT_PATH + QUESTION_CONFIG_NAME + ".csv")), CHARSET)).withCSVParser(getCsvParser()).withSkipLines(1).build();
        } catch (FileNotFoundException e) {
            handleCriticalError("Could not find the question config file.  The file should be lacated at ./" + INPUT_PATH + QUESTION_CONFIG_NAME + ".csv", e);
        } catch (IOException e) {
            handleCriticalError("Could not open the question config file.", e);
        }
        return reader;
    }

    public CSVReader getAspects(Language lang) {
        CSVReader reader = null;
        try {
            logger.debug("loading aspect file " + lang.getCode());
            reader = new CSVReaderBuilder(new InputStreamReader(new BOMInputStream(new FileInputStream(INPUT_PATH + ASPECT_FILE_NAME + "_" + lang.getCode() + ".csv")), CHARSET)).withCSVParser(getCsvParser()).withSkipLines(1).build();
        } catch (FileNotFoundException e) {
            handleCriticalError("Could not find the aspect file ./" + INPUT_PATH + ASPECT_FILE_NAME + "_" + lang.getCode() + ".csv", e);
        } catch (IOException e) {
            handleCriticalError("Could not open the aspect file ./" + "INPUT_PATH+ASPECT_FILE_NAME+\"_\"+lang.getCode()+\".csv\"", e);
        }
        return reader;
    }

    public CSVReader getQuestions(Language lang) {
        CSVReader reader = null;
        try {
            logger.debug("loading question file " + lang.getCode());
            reader = new CSVReaderBuilder(new InputStreamReader(new BOMInputStream(new FileInputStream(INPUT_PATH + QUESTION_FILE_NAME + "_" + lang.getCode() + ".csv")), CHARSET)).withCSVParser(getCsvParser()).withSkipLines(1).build();
        } catch (FileNotFoundException e) {
            handleCriticalError("Could not find the question file ./" + INPUT_PATH + ASPECT_FILE_NAME + "_" + lang.getCode() + ".csv", e);
        } catch (IOException e) {
            handleCriticalError("Could not open the question file ./" + "INPUT_PATH+ASPECT_FILE_NAME+\"_\"+lang.getCode()+\".csv\"", e);
        }
        return reader;
    }


    public CSVReader getAspectConfig() {
        CSVReader reader = null;
        try {
            reader = new CSVReaderBuilder(new InputStreamReader(new BOMInputStream(new FileInputStream(ASPEC_CONFIG_PATH)), CHARSET)).withCSVParser(getCsvParser()).withSkipLines(1).build();
        } catch (IOException e) {
            System.out.println("Error Reading Aspect File");
            e.printStackTrace();
            System.exit(-1);
        }
        return reader;
    }

}
