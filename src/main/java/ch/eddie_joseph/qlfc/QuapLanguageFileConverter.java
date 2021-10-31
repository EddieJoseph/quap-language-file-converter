package ch.eddie_joseph.qlfc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class QuapLanguageFileConverter {

    private static final Logger logger = LogManager.getLogger(QuapLanguageFileConverter.class);

    public static void main(String[] args) throws Exception {

        logger.info("startign conversion");

        InputProvider input = new InputProvider();

        QuestionaryBuilder builder = new QuestionaryBuilder("Questionnaire::Group::Default", input.getAspectConfig(), input.getAspects(Language.DE), input.getAspects(Language.FR), input.getAspects(Language.IT)
                , input.getQuestions(Language.DE), input.getQuestions(Language.FR), input.getQuestions(Language.IT)
        );
        ObjectMapper objectMapper = new ObjectMapper();
        FileOutputStream fileOutputStream = new FileOutputStream("config.json");
        OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(writer, builder.build());
        writer.close();
        logger.info("finished conversion");
    }

}
