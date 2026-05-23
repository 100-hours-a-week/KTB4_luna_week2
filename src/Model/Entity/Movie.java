package Model.Entity;

import Model.Enum.ContentRating;
import Model.Enum.Resolution;

public class Movie extends Video{
    private final int runtimeMinutes;
    private ContentRating contentRating;
    private final Object lock =  new Object();
    public Movie(String title, String director, int releaseYear,
                 int runtimeMinutes, Resolution resolution, String[] platforms,
                 String[] subtitles, ContentRating contentRating, double rating) {
        super(title, director, releaseYear, resolution, platforms, subtitles, rating);
        validate(runtimeMinutes, contentRating);
        this.runtimeMinutes = runtimeMinutes;
        this.contentRating = contentRating;
    }
    public ContentRating getContentRating() {
        return contentRating;
    }
    public String formattedRuntime() {
        return String.format("%d시간 %02d분", runtimeMinutes / 60, runtimeMinutes % 60);
    }
    public int getRuntimeMinutes() {
        return runtimeMinutes;
    }
    @Override
    public void play() {
        synchronized (lock) {
            incrementPlayCnt();
        }
    }
    private static void validate(int runtimeMinutes,  ContentRating contentRating) {
        if(runtimeMinutes < 0) throw new IllegalArgumentException("재생 시간은 0보다 커야합니다.");
        if(contentRating == null) throw new IllegalArgumentException("상영 등급이 올바르지 않습니다.");
    }
}
