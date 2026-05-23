package data;

import Model.Entity.Drama;
import Model.Entity.Media;
import Model.Entity.Movie;
import Model.Entity.Music;
import Model.Enum.*;

import java.util.ArrayList;
import java.util.List;

public class SampleData {

    // Music
    // new Music(title, creator, releaseYear, durationSeconds, bitrates, audioCodec, genre)
    public static final List<Music> MUSIC_LIST = List.of(
            new Music("Dynamite",          "BTS",           2020, 199, 320, AudioCodec.AAC, MusicGenre.KPOP),
            new Music("Shake It Off",      "테일러 스위프트",  2014, 219, 256, AudioCodec.MP3,  MusicGenre.POP)
    );

    // Movie
    // new Movie(title, director, releaseYear, runtimeMinutes, resolution,
    //           platforms[], subtitles[], contentRating, rating)
    public static final List<Movie> MOVIE_LIST = List.of(
            new Movie(
                    "인터스텔라", "크리스토퍼 놀란", 2014,
                    169, Resolution.FHD,
                    new Platform[]{Platform.APPLETV, Platform.COUPANGPLAY, Platform.WAVVE},
                    new SubLanguage[]{SubLanguage.KOREAN, SubLanguage.ENGLISH},
                    ContentRating.TWELVE, 8.7
            ),
            new Movie(
                    "라라랜드", "데이미언 셔젤", 2016,
                    128, Resolution.FHD,
                    new Platform[]{ Platform.COUPANGPLAY, Platform.WATCHA, Platform.WAVVE},
                    new SubLanguage[]{SubLanguage.KOREAN, SubLanguage.ENGLISH},
                    ContentRating.TWELVE, 8.0
            ),
            new Movie(
                    "F1 더 무비", "조셉 코신스키", 2025,
                    155, Resolution.UHD_4K,
                    new Platform[]{Platform.APPLETV, Platform.COUPANGPLAY, Platform.TVING, Platform.WAVVE},
                    new SubLanguage[]{SubLanguage.KOREAN, SubLanguage.ENGLISH, SubLanguage.FRENCH},

                    ContentRating.TWELVE, 7.9
            )
    );

    // Drama
    // new Drama(title, creator, releaseYear, resolution,
    //           platforms[], subtitles[], rating, episodes, episodeMinutes)
    public static final List<Drama> DRAMA_LIST = List.of(
            new Drama(
                    "오징어 게임", "싸이런픽쳐스", 2021,
                    Resolution.UHD_4K,
                    new Platform[]{Platform.NETFLIX},
                    new SubLanguage[]{SubLanguage.KOREAN, SubLanguage.ENGLISH, SubLanguage.JAPANESE, SubLanguage.SPANISH},
                    8.0, 9, 60
            ),
            new Drama(
                    "체르노빌", "HBO", 2019,
                    Resolution.HD,
                    new Platform[]{Platform.COUPANGPLAY},
                    new SubLanguage[]{SubLanguage.KOREAN, SubLanguage.ENGLISH},
                    9.3, 5, 70
            )
    );
    public List<Music> getMusicList() {
        return MUSIC_LIST;
    }

    public List<Movie> getMovieList() {
        return MOVIE_LIST;
    }

    public List<Drama> getDramaList() {
        return DRAMA_LIST;
    }

    public List<Media> getAllList() {
        List<Media> all = new ArrayList<>();
        all.addAll(MUSIC_LIST);
        all.addAll(MOVIE_LIST);
        all.addAll(DRAMA_LIST);
        return all;
    }
}