package fp;

import static fp.Music.allMusics;

public class PremiumBehavior implements UserBehavior {
    private int month;

    public  PremiumBehavior (int month) {
        this.month = month;
    }

    @Override
    public void createPlaylist(String Title, User Owner) {
        Playlist newPlaylist = new Playlist(Title, Owner);
    }

    @Override
    public void playMusic(Music music) throws InvalidOperationException {
        if(!allMusics.contains(music)) {
            throw new InvalidOperationException("this music does not exist.");
        }

        music.play();
    }

    @Override
    public void buyPremium(User owner, int month) {
        this.month += month;
    }
}
