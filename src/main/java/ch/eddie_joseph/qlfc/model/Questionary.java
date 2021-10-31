package ch.eddie_joseph.qlfc.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class Questionary {

    private final Logger logger = LogManager.getLogger(Questionary.class);
    private final ArrayList<Aspect> aspects= new ArrayList<>();
    private String type;

    public Questionary(){}

    public Questionary(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Aspect> getAspects() {
        return aspects;
    }

    public void addAspect(String [] german, String [] french, String [] italian) {
        checkAspekt(german,french,italian);
        aspects.add(new Aspect(Integer.parseInt(german[0]),german[1],french[1],italian[1],german[2],french[2],italian[2]));
    }

    private void checkAspekt(String [] german, String [] french, String [] italian){
        checkSingle(german,"german");
        checkSingle(french,"french");
        checkSingle(italian,"italian");
        if(!(german[0].equals(french[0])&&german[0].equals(italian[0]))){
            logger.error("Id Mismatch in aspect",german,french,italian);
            throw new RuntimeException("Id Mismatch in aspect");
        }
    }

    private void checkSingle(String [] data, String name){
        if(data.length!=3){
            if(data.length>3){
                logger.warn("length of "+name+" aspect data too long", data);
            } else {
                logger.error("length of "+name+" aspect data is too short",data);
                throw new RuntimeException("length of "+name+" aspect data is too short");
            }
        }
        if(data[0]==null||data[0].isEmpty()){
            logger.error("The id attribute must be set in "+name+" aspect file",data);
            throw new RuntimeException("The id attribute must be set in "+name+" aspect file");
        }
        if(data[1]==null||data[1].isEmpty()){
            logger.error("The name attribute must be set in "+name+" aspect file",data);
            throw new RuntimeException("The name attribute must be set in "+name+" aspect file");
        }
    }





    public void addQuestion(String [] questionConfig, String [] dataDe, String [] dataFr, String [] dataIt){
        logger.debug("addQuestion",questionConfig,dataDe);
        findAspect(Integer.parseInt(questionConfig[0])).addQuestion(questionConfig,dataDe,dataFr,dataIt);
    }

    private Aspect findAspect(int id){
        for(Aspect a : aspects){
            if(a.getId()==id){
                return a;
            }
        }
        throw new RuntimeException("Refering to inexistant aspect.");
    }

}
