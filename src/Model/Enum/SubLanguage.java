package Model.Enum;

public enum SubLanguage {
    KOREAN("한국어"), ENGLISH("영어"), JAPANESE("일본어"), SPANISH("스페인어"), FRENCH("프랑스어");
    private final String label;
    SubLanguage(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
}
