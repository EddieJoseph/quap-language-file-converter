package ch.eddie_joseph.qlfc.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.util.ArrayList;

public class Questionary {

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    public ArrayList<Aspect> getAspects() {
        return aspects;
    }

    private final ArrayList<Aspect> aspects= new ArrayList<>();

    public Questionary(){}

    public Questionary(String type){
        this.type = type;
    }


    public void addQuestion(String [] questionConfig, String [] dataDe, String [] dataFr, String [] dataIt){
        findAspect(Integer.parseInt(questionConfig[0]),dataDe[0],dataFr[0],dataIt[0]).addQuestion(questionConfig,dataDe,dataFr,dataIt);
    }

    private Aspect findAspect(int id, String aspecNameDe,String aspecNameFr,String aspecNameIt){
        for(Aspect a : aspects){
            if(a.getId()==id){
                return a;
            }
        }
        Aspect a = new Aspect(id,aspecNameDe,aspecNameFr,aspecNameIt);
        aspects.add(a);
        return a;
    }

}
