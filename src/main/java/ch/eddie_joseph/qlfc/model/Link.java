package ch.eddie_joseph.qlfc.model;

public class Link {

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    private final String name;
    private final String url;

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
