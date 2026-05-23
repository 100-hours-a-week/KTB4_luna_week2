package Model.Enum;

public enum ContentRating {
    ALL("전체관람가"),
    TWELVE("12세 이상"),
    FIFTEEN("15세 이상"),
    ADULT("청소년관람불가");

    private final String label;
    ContentRating(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
}