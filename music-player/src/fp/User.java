package fp;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList <User> followerList;
    private ArrayList <User> followingList;
    private UserBehavior behavior = new RegularBehavior();
    private ArrayList <Playlist> playlists;
    private ArrayList <User> allUsers = new ArrayList<>();

    public User(String username, String password) throws InvalidOperationException{
        if (username == null || username.isEmpty()) {
            throw new InvalidOperationException("Username can not be empty. Enter a name.");
        }

        for (User user : allUsers ) {
            if(user.username.equals(username)) {
                throw new InvalidOperationException("This name already exist. Enter a different name.");
            }
        }

        if (password == null) {
            throw new InvalidOperationException("Password can not be empty.");
        }

        if(password.length() < 8) {
            throw new InvalidOperationException("Password must be 8 characters or more.");
        }

        this.username = username;
        this.password = password;
        followerList = new ArrayList<>();
        followingList = new ArrayList<>();
        playlists = new ArrayList<>();
        allUsers.add(this);
    }

    //getter/setter
    public void setUsername (String newUsername) {
        this.username = newUsername;
    }

    public String getUsername () {
        return username;
    }

    public void setPassword (String newPassword) {
        this.password = newPassword;
    }

    public String getPassword () {
        return password;
    }

    public void setBehavior (UserBehavior newBehavior) {this.behavior = newBehavior;}

    public UserBehavior getBehavior () {return behavior;}

    public ArrayList<Playlist> getPlaylists () {return playlists;}


    public void follow (User user) throws InvalidOperationException{

        this.followingList.add(user);
        user.followerList.add(this);
    }

    public void createPlaylist(String title, User owner) {
        this.behavior.createPlaylist(title,owner);
    }

    public void playMusic (Music music) {
        this.behavior.playMusic(music);
    }

    public void buyPremium (User owner, int month) {
        this.behavior.buyPremium(owner,month);
    }


}
