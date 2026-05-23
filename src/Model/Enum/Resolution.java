package Model.Enum;

public enum Resolution {
    SD("480p"), HD("720p"), FHD("1080p"), UHD_4K("4K"), UHD_8K("8K");

    private final String label;
    Resolution(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
}