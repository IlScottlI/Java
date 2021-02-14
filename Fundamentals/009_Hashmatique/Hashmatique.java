import java.util.*;

public class Hashmatique {
    HashMap<String, String> songMap = new HashMap<String, String>();

    public void setSong(String title, String lyrics) {
        songMap.put(title, lyrics);
    }

    public String getSong(String title) {
        return songMap.get(title);
    }

    public String getSongs() {
        String songs = "Track | Lyrics\n";
        Set<String> keys = songMap.keySet();
        for (String key : keys) {
            songs += key + ": " + songMap.get(key) + "\n";
        }
        return songs;
    }

}