package Model.Entity;

import Model.Enum.Platform;
import Model.Enum.Resolution;
import Model.Enum.SubLanguage;

public abstract class Video extends Media{
    // 해상도
    private final Resolution resolution;
    // 제공 플랫폼
    private Platform[] platforms;
    // 제공되는 자막
    private SubLanguage[] subtitles;
    // 나중에 평점 추가 하면서 rating을 다시 계산하는 과정 추가?
    private double rating;

    public Video(String title, String creator, int releaseYear, Resolution resolution, Platform[] platforms, SubLanguage[] subtitles, double rating) {
        super(title, creator, releaseYear);
        validate(resolution, rating);
        this.platforms = platforms;
        this.resolution = resolution;
        this.subtitles = subtitles;
        this.rating = rating;
    }
    // getter
    public double getRating() {
        return rating;
    }
    public String getResolution() {
        return resolution.getLabel();
    }
    @Override
    public void play(){
    }
    private static void validate(Resolution resolution, double rating) {
        if(resolution == null) throw new IllegalArgumentException("해상도는 null일 수 없습니다.");
        if(rating < 0.0 || rating > 10.0) throw new IllegalArgumentException("평점은 0.0 ~ 10.0 사이여야 합니다: " + rating);
    }
}
