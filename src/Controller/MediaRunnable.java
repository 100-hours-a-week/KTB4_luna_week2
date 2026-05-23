package Controller;

import Model.Entity.Drama;
import Model.Entity.Media;
import Model.Entity.Movie;
import Model.Entity.Music;

public class MediaRunnable implements Runnable {
    private final Media media;
    private final int playCount;
    public MediaRunnable(Media media, int playCount) {
        this.media = media;
        this.playCount = playCount;
    }
    public MediaRunnable(Media media) {
        this.media = media;
        this.playCount = 1;
    }
    @Override
    public void run() {
        System.out.printf("[%s] \"%s\" 재생 시작%n", Thread.currentThread().getName(), media.getTitle());

        try {
            for(int i = 0; i<playCount; i++) {
                Thread.sleep(getSleepTime());
                media.play();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.printf("[%s] \"%s\" 재생 완료 (누적: %d회)%n", Thread.currentThread().getName(), media.getTitle(), media.getPlayCnt());
    }
    private long getSleepTime(){
        if(media instanceof Music m){
            return m.getDurationSeconds() * 3L;
        }
        else if(media instanceof Movie m){
            return m.getRuntimeMinutes() * 10L;
        }
        else if(media instanceof Drama d) {
            return d.getEpisodeMinutes() * 10L;
        }
        return 0;
    }
}
