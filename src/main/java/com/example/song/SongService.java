/*

 * You can use the following import statements
  
 * import org.springframework.http.HttpStatus;
 * import org.springframework.web.server.ResponseStatusException;

 */

package com.example.song;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.example.song.Song;
import com.example.song.SongRepository;

// Don't modify the below code
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();
    int uniqueSongId = 6;

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    // Don't modify the above code

    // Write your code here
    @Override
    public ArrayList getSongsList(){
        Collection<Song> allCollections = playlist.values();
        ArrayList<Song> allSongs = new ArrayList<>(allCollections);
        return allSongs;
    }

    @Override
    public Song createSongDetails(Song song){
        song.setSongId(uniqueSongId);
        playlist.put(uniqueSongId, song);
        uniqueSongId += 1;
        return song;

    }

    @Override 
    public Song getSongDetails(int songId){
        Song existingSong = playlist.get(songId);
        if(existingSong == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return existingSong;

    }

    @Override 
    public Song updateSongDetails(int songId, Song song){
        Song songDetails = playlist.get(songId);
        if(songDetails == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if(song.getSongName() != null){
            songDetails.setSongName(song.getSongName());
        }

        if(song.getLyricist() != null){
            songDetails.setLyricist(song.getLyricist());
        }

        if(song.getSinger() != null){
            songDetails.setSinger(song.getSinger());
        }

        if(song.getMusicDirector() != null){
            songDetails.setMusicDirector(song.getMusicDirector());
        }
        return songDetails;
    }

    @Override
    public void deleteSong(int songId){
        Song songDetails = playlist.get(songId);
        if(songDetails == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            playlist.remove(songId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}