package ch.eddie_joseph.qlfc;

import ch.eddie_joseph.qlfc.model.Questionary;
import com.opencsv.CSVReader;

public class QuestionaryBuilder {

    private final CSVReader configReader;
    private final CSVReader germanReader;
    private final CSVReader frenchReader;
    private final CSVReader italianReader;
    private final String type;

    public QuestionaryBuilder(String type, CSVReader config, CSVReader germanReader, CSVReader frenchReader, CSVReader italianReader) {
        this.configReader = config;
        this.germanReader = germanReader;
        this.frenchReader = frenchReader;
        this.italianReader = italianReader;
        this.type=type;
    }

    public Questionary build() throws Exception{
        Questionary q = new Questionary(type);
        String []config = configReader.readNext();
        String []german = germanReader.readNext();
        String []french = frenchReader.readNext();
        String []italian = italianReader.readNext();

        while(config!=null){
            q.addQuestion(config,german,french,italian);
            config = configReader.readNext();
            german = germanReader.readNext();
            french = frenchReader.readNext();
            italian = italianReader.readNext();
        }
        return q;
    }
}
