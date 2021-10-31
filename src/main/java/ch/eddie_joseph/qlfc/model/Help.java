package ch.eddie_joseph.qlfc.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Help {

    public static final String URL_PLACEHOLDER = "XXX";

    private final Logger logger = LogManager.getLogger(Help.class);
    private final ArrayList<Link> linksDe = new ArrayList<>();
    private final ArrayList<Link> linksFr = new ArrayList<>();
    private final ArrayList<Link> linksIt = new ArrayList<>();
    private final String helpDe;
    private final String helpFr;
    private final String helpIt;

    public Help(String[] dataDe, String[] dataFr, String[] dataIt) {
        this.helpDe = dataDe[0];
        this.helpFr = dataFr[0];
        this.helpIt = dataIt[0];

        for (int c = 0; c < dataDe.length - 2; c = c + 2) {
            if (!dataDe[2 + c].isEmpty()
                    && validURL(dataDe[1 + c], dataDe[2 + c])
            ) {

                linksDe.add(new Link(dataDe[1 + c], dataDe[2 + c]));
            }
        }

        for (int c = 0; c < dataFr.length - 2; c = c + 2) {
            if (!dataFr[2 + c].isEmpty()
                    && validURL(dataFr[1 + c], dataFr[2 + c])
            ) {
                linksFr.add(new Link(dataFr[1 + c], dataFr[2 + c]));
            }
        }

        for (int c = 0; c < dataIt.length - 2; c = c + 2) {
            if (!dataIt[2 + c].isEmpty()
                    && validURL(dataIt[1 + c], dataIt[2 + c])
            ) {
                linksIt.add(new Link(dataIt[1 + c], dataIt[2 + c]));
            }
        }

    }

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

    private boolean validURL(String entry1, String entry2) {
        //System.out.println(entry2);
        if (entry1 == null || entry1.isEmpty()) {
            return false;
        } else if (entry2 == null || entry2.isEmpty()) {
            logger.warn("Discarding help due to enpty url.");
            return false;
        } else if (entry2.toUpperCase().equals(URL_PLACEHOLDER)) {
            logger.info("Discarding help due to url placeholder");
            return false;
        }
        return true;
    }
}
