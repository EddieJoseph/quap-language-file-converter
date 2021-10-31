package ch.eddie_joseph.qlfc.model;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.ArrayList;

public class Help {
    @JsonGetter("links_de")
    public ArrayList<Link> getLinksDe() {
        return linksDe;
    }

    @JsonGetter("links_fr")
    public ArrayList<Link> getLinksFr() {
        return linksFr;
    }
    @JsonGetter("links_it")
    public ArrayList<Link> getLinksIt() {
        return linksIt;
    }
    @JsonGetter("help_de")
    public String getHelpDe() {
        return helpDe;
    }
    @JsonGetter("help_fr")
    public String getHelpFr() {
        return helpFr;
    }
    @JsonGetter("help_it")
    public String getHelpIt() {
        return helpIt;
    }

    private final ArrayList<Link>linksDe=new ArrayList<>();
    private final ArrayList<Link>linksFr=new ArrayList<>();
    private final ArrayList<Link>linksIt=new ArrayList<>();
    private final String helpDe;
    private final String helpFr;
    private final String helpIt;

    public Help(String[] dataDe, String[] dataFr, String[] dataIt) {
        this.helpDe = dataDe[0];
        this.helpFr = dataFr[0];
        this.helpIt = dataIt[0];

        for(int c =0;c<dataDe.length-2;c=c+2){
            if(!dataDe[2+c].isEmpty()){
                linksDe.add(new Link(dataDe[1+c],dataDe[2+c]));
            }
        }

        for(int c =0;c<dataFr.length-2;c=c+2){
            if(!dataFr[2+c].isEmpty()){
                linksFr.add(new Link(dataFr[1+c],dataFr[2+c]));
            }
        }

        for(int c =0;c<dataIt.length-2;c=c+2){
            if(!dataIt[2+c].isEmpty()){
                linksIt.add(new Link(dataIt[1+c],dataIt[2+c]));
            }
        }

    }
}
