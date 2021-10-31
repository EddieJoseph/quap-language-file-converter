package ch.eddie_joseph.qlfc;

import ch.eddie_joseph.qlfc.model.Questionary;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class QuestionaryBuilder {

    private final CSVReader configReader;
    private final CSVReader questionsDe;
    private final CSVReader questionsFr;
    private final CSVReader questionsIt;
    private final CSVReader aspectsDe;
    private final CSVReader aspectsFr;
    private final CSVReader aspectsIt;
    private final String type;

    private final Logger logger = LogManager.getLogger(QuestionaryBuilder.class);

    public QuestionaryBuilder(String type, CSVReader config, CSVReader aspectsDe, CSVReader aspectsFr, CSVReader aspectsIt, CSVReader questionsDe, CSVReader questionsFr, CSVReader questionsIt) {
        this.configReader = config;
        this.questionsDe = questionsDe;
        this.questionsFr = questionsFr;
        this.questionsIt = questionsIt;
        this.aspectsDe = aspectsDe;
        this.aspectsFr = aspectsFr;
        this.aspectsIt = aspectsIt;
        this.type = type;
    }

    public Questionary build() throws Exception {
        Questionary q = new Questionary(type);
        generateAspects(q);
        generateQuestions(q);
        return q;
    }

    private void generateQuestions(Questionary q) throws CsvValidationException {
        logger.info("generating questions");
        String[] config = null;
        String[] germanQ = null;
        String[] frenchQ = null;
        String[] italianQ = null;
        try {
            config = configReader.readNext();
            germanQ = questionsDe.readNext();
            frenchQ = questionsFr.readNext();
            italianQ = questionsIt.readNext();
        } catch (IOException e) {
            logger.error("Encountered error when reading questions", e);
            System.exit(-1);
        }
        while (config != null) {
            try {
                q.addQuestion(config, germanQ, frenchQ, italianQ);
            } catch (RuntimeException e) {
                logger.error("could not add question", e);
                e.printStackTrace();
            }

            try {
                config = configReader.readNext();
                germanQ = questionsDe.readNext();
                frenchQ = questionsFr.readNext();
                italianQ = questionsIt.readNext();
            } catch (IOException e) {
                logger.error("Encountered error when reading questions", e);
                System.exit(-1);
            }
        }
        if (germanQ != null || frenchQ != null || italianQ != null) {
            logger.warn("missmatching question files");
        } else if (config != null) {
            logger.warn("question config file is not matching question");
        }
    }

    private void generateAspects(Questionary q) throws CsvValidationException {
        logger.info("generating aspects");
        String[] german = null;
        String[] french = null;
        String[] italian = null;
        try {
            german = aspectsDe.readNext();
            french = aspectsFr.readNext();
            italian = aspectsIt.readNext();
        } catch (IOException e) {
            logger.error("Encountered error when readingaspects", e);
            System.exit(-1);
        }
        while (german != null) {
            logger.trace("adding aspect", german, french, italian);
            try {
                q.addAspect(german, french, italian);
            } catch (RuntimeException e) {
                logger.error("could not add aspect", e);
                e.printStackTrace();
            }
            try {
                german = aspectsDe.readNext();
                french = aspectsFr.readNext();
                italian = aspectsIt.readNext();
            } catch (IOException e) {
                logger.error("Encountered error when reading aspects", e);
                System.exit(-1);
            }
        }

        if (german != null || french != null || italian != null) {
            logger.warn("missmatching aspect files");
        }
    }
}
