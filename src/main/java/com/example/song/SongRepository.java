// Write your code here
package com.example.song;
import java.util.ArrayList;

public interface SongRepository{
    ArrayList<Song> getSongsList();
    Song createSongDetails(Song song);
    Song getSongDetails(int songId);
    Song updateSongDetails(int songId, Song song);
    void deleteSong(int songId);
}