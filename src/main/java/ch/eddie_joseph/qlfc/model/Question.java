package ch.eddie_joseph.qlfc.model;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.Arrays;

public class Question {

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

    private final int id;
    private final String questionDe;
    private final String questionFr;
    private final String questionIt;
    private final String answerOption;
    private final String evaluationFunction;

    public Help getHelp() {
        return help;
    }

    private final Help help;

    public Question(int id, String [] quistionConfig, String [] german, String [] french, String [] italian) {
        this.id = id;

        this.questionDe=german[1];
        this.questionFr=french[1];
        this.questionIt=italian[1];
        this.answerOption = quistionConfig[2];
        this.evaluationFunction = quistionConfig[1].isEmpty()?null:quistionConfig[1];
        help = new Help(Arrays.copyOfRange(german,2, german.length),Arrays.copyOfRange(french,2, french.length),Arrays.copyOfRange(italian,2, italian.length));
    }
}
