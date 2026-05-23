package Model.Entity;

import Model.Enum.AudioCodec;

public abstract class Audio extends Media{
    private final int durationSeconds;
    private final int bitrates;
    private final AudioCodec audioCodec;
    public Audio(String title, String creator, int releaseYear, int durationSeconds, int bitrates, AudioCodec audioCodec) {
        super(title, creator, releaseYear);
        validate(durationSeconds, bitrates, audioCodec);
        this.durationSeconds = durationSeconds;
        this.bitrates = bitrates;
        this.audioCodec = audioCodec;
    }
    public String getFormattedDuration(){
        return String.format("%d:%02d", durationSeconds / 60, durationSeconds % 60);
    }
    public String getBitrates(){
        return String.format("%dkbps", bitrates);
    }
    public AudioCodec getAudioCodec(){
        return audioCodec;
    }
    public int getDurationSeconds(){
        return durationSeconds;
    }
    @Override
    public void play() {
    }
    private static void validate(int durationSeconds, int bitrates, AudioCodec audioCodec){
        if (durationSeconds <= 0) throw new IllegalArgumentException("재생 시간은 0보다 커야 합니다.");
        if (bitrates <= 0) throw new IllegalArgumentException("비트레이트는 0보다 커야 합니다.");
        if (audioCodec == null) throw new IllegalArgumentException("오디오 코덱이 올바르지 않습니다.");
    }
}