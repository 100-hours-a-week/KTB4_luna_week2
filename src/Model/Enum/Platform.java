package Model.Enum;

public enum Platform {
    NETFLIX("넷플릭스"), COUPANGPLAY("쿠팡플레이"), WATCHA("왓챠"), WAVVE("Wavve"), APPLETV("Apple TV"), TVING("티빙");
    private final String label;
    Platform(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
}
