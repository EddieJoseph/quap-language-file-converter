package ch.eddie_joseph.qlfc.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class Question {

    private final int id;
    private final String questionDe;
    private final String questionFr;
    private final String questionIt;
    private final String answerOption;
    private final String evaluationFunction;
    private final Logger logger = LogManager.getLogger(Question.class);
    private final Help help;
    public Question(int id, String[] quistionConfig, String[] german, String[] french, String[] italian) {
        checkQuestion(quistionConfig, german, french, italian);
        this.id = id;

        this.questionDe = german[0];
        this.questionFr = french[0];
        this.questionIt = italian[0];
        this.answerOption = quistionConfig[2];
        this.evaluationFunction = quistionConfig[1].isEmpty() ? null : quistionConfig[1];
        help = new Help(Arrays.copyOfRange(german, 1, german.length), Arrays.copyOfRange(french, 1, french.length), Arrays.copyOfRange(italian, 1, italian.length));
    }

    public int getId() {
        return id;
    }

    @JsonGetter("question_de")
    public String getQuestionDe() {
        return questionDe;
    }

    @JsonGetter("question_fr")
    public String getQuestionFr() {
        return questionFr;
    }

    @JsonGetter("question_it")
    public String getQuestionIt() {
        return questionIt;
    }

    @JsonGetter("answer_options")
    public String getAnswerOption() {
        return answerOption;
    }

    @JsonGetter("evaluation_function")
    public String getEvaluationFunction() {
        return evaluationFunction;
    }

    public Help getHelp() {
        return help;
    }

    private void checkQuestion(String[] questionConfig, String[] german, String[] french, String[] italian) {
        if (questionConfig.length != 3) {
            if (questionConfig.length < 3) {
                logger.error("The question config length is too small", questionConfig);
                throw new RuntimeException("The error config length is too small");
            } else {
                logger.warn("The config has more attributes than nessesary", questionConfig);
            }
        }
        checkSingle(german, "german");
        checkSingle(french, "french");
        checkSingle(italian, "italian");

    }

    private void checkSingle(String[] data, String languageName) {
        if (data.length < 2) {
            logger.error(languageName + " question does not have all attributes.");
            logger.error(languageName + " question does not have all attributes.", data);
        }
    }

}
