package ch.eddie_joseph.qlfc;

import ch.eddie_joseph.qlfc.model.Questionary;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class QuapLanguageFileConverter {

    public static void main(String [] args) throws Exception{
        System.out.println("Starting JSON conversion");
        InputProvider input = new InputProvider();

//        String [] line = input.getAspectConfig().readNext();
//        for(String s : line) {
//            System.out.println(s);
//        }

        QuestionaryBuilder builder = new QuestionaryBuilder("Questionnaire::Group::Default",input.getAspectConfig(),input.getGerman(),input.getFrench(),input.getItalian());
        ObjectMapper objectMapper = new ObjectMapper();
        //System.out.println(objectMapper.writeValueAsString(builder.build()));
        FileOutputStream fileOutputStream = new FileOutputStream("config.json");
        OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(writer,builder.build());
        writer.close();

        System.out.println("Converted Successfully");

    }

}
