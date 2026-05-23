package Model.Entity;

import Model.Enum.AudioCodec;
import Model.Enum.MusicGenre;

public class Music extends Audio {
    private final MusicGenre genre;
    public Music(String title, String creator, int releaseYear, int durationSeconds, int bitrates, AudioCodec audioCodec, MusicGenre genre) {
        super(title, creator, releaseYear, durationSeconds, bitrates, audioCodec);
        validate(genre);
        this.genre = genre;
    }

    public String getGenre() {
        return genre.getLabel();
    }
    @Override
    public void play() {
        incrementPlayCnt();
    }
    private static void validate(MusicGenre genre) {
        if (genre == null) throw new IllegalArgumentException("Genre값이 올바르지 않습니다.");
    }

}
