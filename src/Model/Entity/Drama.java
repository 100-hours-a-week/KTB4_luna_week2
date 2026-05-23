package Model.Entity;

import Model.Enum.Resolution;

import java.util.concurrent.atomic.AtomicInteger;

public class Drama extends Video{
    private final int episodes;
    private final int episodeMinutes;
    private AtomicInteger atomicCounter;
    public Drama(String title, String creator, int releaseYear, Resolution resolution, String[] platforms, String[] subtitles, double rating, int episodes, int episodeMinutes) {
        super(title, creator, releaseYear, resolution, platforms, subtitles, rating);
        validate(episodes, episodeMinutes);
        this.episodes = episodes;
        this.episodeMinutes = episodeMinutes;
        atomicCounter = new AtomicInteger(0);
    }
    public int getEpisodes() {
        return episodes;
    }
    public int getEpisodeMinutes() {
        return episodeMinutes;
    }
    @Override
    public void play(){
        atomicCounter.incrementAndGet();
    }
    @Override
    public int getPlayCnt(){
        return atomicCounter.get();
    }
    private static void validate(int episodes, int episodeMinutes){
        if(episodes < 0) throw new IllegalArgumentException("1편 이상의 에피소드가 필요합니다.");
        if(episodeMinutes < 0) throw new IllegalArgumentException("편당 시간은 0보다 커야합니다.");
    }
}
