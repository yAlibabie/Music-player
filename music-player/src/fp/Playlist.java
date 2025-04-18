package fp;

import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {
    private ArrayList <Music> playlist;
    private String title;
    private User owner;

    public Playlist(String title, User owner) {
        this.title = title;
        this.owner = owner;
        playlist = new ArrayList<>();
    }

    public void editTitle (String newTitle, String password) throws InvalidOperationException{
        if(!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Password is incorrect");
        }

        this.title = newTitle;
    }

    public void addMusic (Music music, String password) throws InvalidOperationException{
        if(!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Password is incorrect");
        }

        if(!Music.allMusics.contains(music)) {
            throw new InvalidOperationException("Music not found");
        }

        playlist.add(music);
    }

    public void removeMusic (Music music, String password) throws InvalidOperationException{
        if(!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Password is incorrect");
        }

        if(!playlist.contains(music)) {
            throw new InvalidOperationException("Music not found in this playlist");
        }

        playlist.remove(music);
    }

    public Music searchInPlaylist (Music music) throws InvalidOperationException{
        Music foundMusic = null;
        for (Music thismusic : playlist) {
            if(thismusic.equals(music)) {
                foundMusic = thismusic;
                break;
            }
        }

        if(foundMusic == null) {
            throw new InvalidOperationException("Music not found in this playlist");
        }

        return foundMusic;
    }

    public void playPlaylist () {
        Scanner scanner = new Scanner(System.in);
        int currentIndex = 0;

        while (currentIndex < playlist.size()) {
            Music currentMusic = playlist.get(currentIndex);
            currentMusic.play();

            String input = scanner.nextLine();
            if (input.equals("next")) {
                currentIndex++;
            }
            else if (input.equals("exit")) {
                break;
            }
            else {
                System.out.println("Invalid input!");
            }
        }
    }

}
