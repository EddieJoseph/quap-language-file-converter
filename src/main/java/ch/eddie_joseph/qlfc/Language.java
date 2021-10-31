package ch.eddie_joseph.qlfc;

public enum Language {
    DE("de"),
    FR("fr"),
    IT("it");

    private final String code;

    Language(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
