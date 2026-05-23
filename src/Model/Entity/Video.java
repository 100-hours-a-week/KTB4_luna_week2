package Model.Entity;

import Model.Enum.Resolution;

public abstract class Video extends Media{
    // 해상도
    private final Resolution resolution;
    // 제공 플랫폼
    private String[] platforms;
    // 제공되는 자막
    private String[] subtitles;
    // 나중에 평점 추가 하면서 rating을 다시 계산하는 과정 추가?
    private double rating;

    public Video(String title, String creator, int releaseYear, Resolution resolution, String[] platforms, String[] subtitles, double rating) {
        super(title, creator, releaseYear);
        validate(resolution, rating);
        this.platforms = platforms;
        this.resolution = resolution;
        this.subtitles = subtitles;
        this.rating = rating;
    }
    // getter
    public String getSubtitles() {
        return subtitles.length == 0 ? "없음" : String.join(", ", subtitles);
    }
    public double getRating() {
        return rating;
    }
    public String getResolution() {
        return resolution.getLabel();
    }
    public String getPlatforms() {
        return platforms.length == 0 ? "없음" : String.join(", ", platforms);
    }
    @Override
    public void play(){
    }
    private static void validate(Resolution resolution, double rating) {
        if(resolution == null) throw new IllegalArgumentException("해상도는 null일 수 없습니다.");
        if(rating < 0.0 || rating > 10.0) throw new IllegalArgumentException("평점은 0.0 ~ 10.0 사이여야 합니다: " + rating);
    }
}
