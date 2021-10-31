package ch.eddie_joseph.qlfc.model;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.ArrayList;

public class Aspect {

    private final ArrayList<Question> questions = new ArrayList<>();
    private final int id;
    private final String nameDe;
    private final String nameFr;
    private final String nameIt;
    private final String descriptionDe;
    private final String descriptionFr;
    private final String descriptionIt;
    private int questionIdCounter = 0;
    public Aspect(int id, String nameDe, String nameFr, String nameIt, String descriptionDe, String descriptionFr, String descriptionIt) {
        this.id = id;
        this.nameDe = nameDe;
        this.nameFr = nameFr;
        this.nameIt = nameIt;
        this.descriptionDe = descriptionDe;
        this.descriptionFr = descriptionFr;
        this.descriptionIt = descriptionIt;
    }

    public int getId() {
        return id;
    }

    @JsonGetter("name_de")
    public String getNameDe() {
        return nameDe;
    }

    @JsonGetter("name_fr")
    public String getNameFr() {
        return nameFr;
    }

    @JsonGetter("name_it")
    public String getNameIt() {
        return nameIt;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    @JsonGetter("description_de")
    public String getDescriptionDe() {
        return descriptionDe;
    }

    @JsonGetter("description_fr")
    public String getDescriptionFr() {
        return descriptionFr;
    }

    @JsonGetter("description_it")
    public String getDescriptionIt() {
        return descriptionIt;
    }

    public void addQuestion(String[] questionConfig, String[] dataDe, String[] dataFr, String[] dataIt) {
        questions.add(new Question(questionIdCounter++, questionConfig, dataDe, dataFr, dataIt));
    }

}
