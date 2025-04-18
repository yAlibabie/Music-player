package fp;

import static fp.Music.allMusics;

public class RegularBehavior implements UserBehavior{
    private int playingLimit = 5;

    @Override
    public void createPlaylist(String Title, User Owner) throws InvalidOperationException {
        throw new InvalidOperationException("regular users can not create a playlist. Buy premium for making new playlists");
    }

    @Override
    public void playMusic(Music music) throws InvalidOperationException {
        if(playingLimit <= 0) {
            throw new InvalidOperationException("Your playing limit has reached to zero. Buy premium for more music");
        }

        if(!allMusics.contains(music)) {
            throw new InvalidOperationException("this music does not exist.");
        }

        music.play();
        playingLimit --;
    }

    @Override
    public void buyPremium(User owner, int month) {
        owner.setBehavior(new PremiumBehavior(month));
    }
}
