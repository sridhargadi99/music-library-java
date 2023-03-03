/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.song;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.song.SongService;

@RestController 
public class SongController{
    SongService service = new SongService();
    
    @GetMapping("/songs")
    public ArrayList getSongsList(){
        return service.getSongsList();
    }
    
    @PostMapping("/songs")
    public Song createSongDetails(@RequestBody Song song){
        return service.createSongDetails(song);
    }

    @GetMapping("/songs/{songId}")
    public Song getSongDetails(@PathVariable ("songId") int songId){
        return service.getSongDetails(songId);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSongDetails(@PathVariable ("songId") int songId, @RequestBody Song song){
        return service.updateSongDetails(songId, song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable ("songId") int songId){
        service.deleteSong(songId);
    }
    
}