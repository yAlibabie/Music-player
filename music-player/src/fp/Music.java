package fp;

import java.util.ArrayList;

public class Music {
    private String title;
    private User singer;
    private int numberOfStream = 0 ;
    public static ArrayList<Music> allMusics = new ArrayList<>();

    public Music (String title, User singer) {
        this.title = title;
        this.singer = singer;
        allMusics.add(this);
    }

    //getter and setters
    public void setTitle (String title) {this.title = title;}

    public String getTitle () {return title;}

    public void setSinger (User singer) {this.singer = singer;}

    public User getSinger () {return singer;}


    public void play() {
        System.out.println("Playing: " + title + " by: " + singer.getUsername());
        numberOfStream++;
    }


    public static ArrayList<Music> search (String name) throws InvalidOperationException{
        ArrayList <Music> foundMusics = new ArrayList<>();
        for (Music music : allMusics) {
            if (music.title.equals(name)) {
                foundMusics.add(music);
            }
        }

        if(foundMusics == null) {
            throw new InvalidOperationException("No music found.");
        }

        return foundMusics;
    }


    public static Music search(String name, User inputSinger) throws InvalidOperationException{
        Music foundMusic = null;
        boolean found = false;
        for (Music music : allMusics) {
            if(music.title.equals(music)) {
                if(music.singer == inputSinger) {
                    foundMusic = music;
                    found = true;
                }
            }
        }
        if(!found) {
            throw new InvalidOperationException("Music not found.");
        }
        return foundMusic;
    }

}
