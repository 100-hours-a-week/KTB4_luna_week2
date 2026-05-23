package Model;

import Model.Entity.Media;
import Model.Entity.Music;
import Model.Entity.Movie;
import Model.Entity.Drama;
import data.SampleData;

import java.util.*;

public class MediaModel {
    private static SampleData sampleData;
    public MediaModel() {
        sampleData = new SampleData();
    }

    public List<Media> getAllList(){
        return sampleData.getAllList();
    }
    public List<Music> getMusicList(){
        return sampleData.getMusicList();
    }
    public List<Drama> getDramaList(){
        return sampleData.getDramaList();
    }
    public List<Movie> getMovieList(){
        return sampleData.getMovieList();
    }
}
