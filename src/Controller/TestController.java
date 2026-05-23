package Controller;

import Model.Entity.Media;
import data.SampleData;

import java.util.List;

public class TestController {
    static final int COUNT = 100;
    // 1주차 과제 때와는 다르게, SampleData를 각 객체(Music - 0, Movie - 1, Drama - 2) 별로 한 개씩만 남겨 놓은 상태.
    // 각 미디어에 대해서 2개씩 그 매체를 3000번 실행하는 MediaRunnable을 만들고, Synchronized, AtomicInteger를 부여.
    private static final SampleData sampleData = new SampleData();

    public static void main(String[] args) throws InterruptedException {
        List<Media> allMedia = sampleData.getAllList();
        Media music = allMedia.get(0);

        // music은 동시성 제어 없이 진행. race condition이 발생하는 지 확인. -> 웬만해서는 6000이 최종 재생 횟수로 안나옴.
        MediaRunnable music_run_1 = new MediaRunnable(music, COUNT);
        MediaRunnable music_run_2 = new MediaRunnable(music, COUNT);

        Thread t1 = new Thread(music_run_1);
        Thread t2 = new Thread(music_run_2);
        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println(music.getTitle() + " 최종 재생 횟수: " + allMedia.get(0).getPlayCnt());

         Media movie = allMedia.get(2);
        // movie는 Synchronized를 부여.
        MediaRunnable movie_run_1 = new MediaRunnable(movie, COUNT);
        MediaRunnable movie_run_2 = new MediaRunnable(movie, COUNT);
        Thread t3 = new Thread(movie_run_1);
        Thread t4 = new Thread(movie_run_2);
        t3.start(); t4.start();
        t3.join(); t4.join();
        System.out.println(movie.getTitle() + " 최종 재생 횟수: " + movie.getPlayCnt());

        Media drama = allMedia.get(5);
        // Drama는 AtomicInteger를 사용.
        MediaRunnable drama_run_1 = new MediaRunnable(drama, COUNT);
        MediaRunnable drama_run_2 = new MediaRunnable(drama, COUNT);
        Thread t5 = new Thread(drama_run_1);
        Thread t6 = new Thread(drama_run_2);
        t5.start(); t6.start();
        t5.join(); t6.join();
        System.out.println(drama.getTitle() + " 최종 재생 횟수: " + drama.getPlayCnt());

    }

}
