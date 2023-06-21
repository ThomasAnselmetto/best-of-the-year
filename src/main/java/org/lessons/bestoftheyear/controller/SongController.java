package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/songs")
public class SongController {
    @GetMapping()
    public String songs(Model model) {
        List<Song> songsList = getBestSongs();

        model.addAttribute("songs",songsList);
        return "songs";
    }
    @GetMapping("/{id}")
    public String songDetail(Model model,@PathVariable int id){
//        ora che ho i movie e l'id nel path della url ciclo per ottenere '
        Song songs = null;
        for (Song song : getBestSongs()) {
            if(song.getId() == id) {
                songs = song;
            }
        }

        if(songs != null) {
            model.addAttribute("songs", songs);
            return "song-detail";
        } else {
            return "redirect:/";
        }
    }


    private List<Song> getBestSongs(){
        List<Song> bestSong = new ArrayList<>();
        //        per ogni bestSong addo in lista con id e titolo
        bestSong.add(new Song(1,"Otherside"));
        bestSong.add(new Song(2,"Viva la vida"));
        bestSong.add(new Song(3,"Wonderwall"));
        bestSong.add(new Song(4,"Miss You"));
        bestSong.add(new Song(5,"American Idiot"));
        bestSong.add(new Song(6,"Toxicity"));
        return bestSong;
    }
}
