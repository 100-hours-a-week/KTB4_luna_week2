package Model.Enum;

public enum MusicGenre {
    POP("Pop"), KPOP("K-Pop"), JAZZ("Jazz"),
    ROCK("Rock"), HIPHOP("Hip-Hop"), CLASSICAL("Classical"),
    RNB("R&B"), ELECTRONIC("Electronic");

    private final String label;
    MusicGenre(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
}
