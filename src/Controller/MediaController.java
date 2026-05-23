package Controller;

import Model.Entity.Media;
import Model.MediaModel;
import View.MediaView;

import java.util.*;

public class MediaController {
    private static final List<Thread> activeThreads = new ArrayList<>();
    private static int seq = 1;
    private static MediaModel model;
    private static MediaView view;
    public MediaController(MediaModel mediaModel, MediaView mediaView) {
        model = mediaModel;
        view = mediaView;
    }

    public void run() throws InterruptedException {
        boolean flag = true;
        while(flag){
            view.printMainMenu(getActiveCount());
            switch(view.getInput()){
                case "1":
                    handleAudio();
                    break;
                case "2":
                    handleVideo();
                    break;
                case "3":
                    view.printMediaList("전체 목록", model.getAllList());
                    break;
                case "4":
                    handleStatus();
                    break;
                case "0":
                    flag = false;
                    break;
                default:
                    view.printMessage("잘못된 입력입니다.");
            }
        }
        handleStatus();
        view.printMessage("종료합니다.");
    }

    private void handleAudio() {
        view.printAudioMenu();
        switch(view.getInput()){
            case "1":
                selectAndPlay(model.getMusicList(), "노래 목록");
                break;
            case "0":
                return;
            default:
                view.printMessage("잘못된 입력입니다.");
        }
    }

    private void handleVideo() {
        view.printVideoMenu();
        switch(view.getInput()){
            case "1":
                selectAndPlay(model.getMovieList(), "영화 목록");
                break;
            case "2":
                selectAndPlay(model.getDramaList(), "드라마 목록");
                break;
            case "0":
                return;
            default:
                view.printMessage("잘못된 입력입니다.");
        }
    }

    private void selectAndPlay(List<? extends Media> list, String title) {
        view.printMediaList(title, list);
        String input = view.getInput();
        if(input.equals("0")) return;
        try{
            int index = Integer.parseInt(input) - 1;
            if(index < 0 ||  index >= list.size()) {
                view.printMessage("범위를 벗어난 번호입니다.");
                return;
            }
            Media selected =  list.get(index);
            playMedia(selected);
            view.printMessage("\"" + selected.getTitle() + "\" 재생 시작! " + "(현재 실행 중: " + getActiveCount() + "개)");
        } catch(NumberFormatException e){
            view.printMessage("숫자를 입력해 주세요.");
        }
    }

    private void handleStatus() throws InterruptedException {
        view.printMessage("...모든 재생 완료 대기 중...");
        joinAll();
        view.printStatus(model.getAllList());
    }
    private void joinAll() throws InterruptedException {
        for (Thread t : activeThreads) t.join();
        activeThreads.clear();
        seq = 1;
    }

    public static void playMedia(Media media){
        MediaRunnable r = new MediaRunnable(media);
        Thread t = new Thread(r, "Thread " + seq++);
        activeThreads.add(t);
        t.start();
    }
    public static int getActiveCount(){
        return (int)activeThreads.stream().filter(Thread::isAlive).count();
    }
}
