package Model.Entity;

import java.time.Year;

public abstract class Media {
    private final String title;
    private final String creator;
    private final int releaseYear;
    private int playCnt;

    public Media(String title, String creator, int releaseYear) {
        validate(title, creator, releaseYear);
        this.title = title;
        this.creator = creator;
        this.releaseYear = releaseYear;
        this.playCnt = 0;
    }
    public String getTitle() {
        return title;
    }
    public String getCreator() {
        return creator;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public abstract void play();
    public void incrementPlayCnt(){
        playCnt++;
    }
    public int getPlayCnt(){
        return playCnt;
    }
    private static void validate(String title, String creator, int releaseYear) {
        if(title == null || title.isBlank()) throw new IllegalArgumentException("제목이 올바르지 않습니다");
        if(creator == null || creator.isBlank()) throw new IllegalArgumentException("이름이 올바르지 않습니다");
        if(releaseYear > Year.now().getValue()) throw new IllegalArgumentException("연도가 올바르지 않습니다");
    }
}
