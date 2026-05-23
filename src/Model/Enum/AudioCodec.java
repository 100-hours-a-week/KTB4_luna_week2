package Model.Enum;

public enum AudioCodec {
    MP3("MP3"), AAC("AAC"), FLAC("FLAC"), WAV("WAV");

    private final String label;
    AudioCodec(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
}