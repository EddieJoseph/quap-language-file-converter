package ch.eddie_joseph.qlfc.model;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.ArrayList;

public class Aspect {

    private int questionIdCounter=0;

    private final  ArrayList<Question>questions=new ArrayList<>();

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

    private final int id;
    private final String nameDe;
    private final String nameFr;
    private final String nameIt;

    public Aspect(int id, String nameDe, String nameFr, String nameIt) {
        this.id = id;
        this.nameDe=nameDe;
        this.nameFr=nameFr;
        this.nameIt=nameIt;
    }

    public void addQuestion(String [] questionConfig, String [] dataDe, String [] dataFr, String [] dataIt){
        questions.add( new Question(questionIdCounter++,questionConfig,dataDe,dataFr,dataIt));
    }

}
