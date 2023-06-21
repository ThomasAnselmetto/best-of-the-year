package org.lessons.bestoftheyear;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller // dice a Spring che questa classe e' un controller
@RequestMapping("/")//a quale rotta rispondono i metodi di questo Controller

public class IndexController {

    @GetMapping()
        public String template(Model model){
        model.addAttribute("title","Thomas Anselmetto");
        return "index"; //al file template arrivera' il mio addattribute tutto questo si trova in resources/templates
    }
//    ho creato le due GetMapping che si indirizzano ai due template

    //ho bisogno di iterare la lista e passare sotto forma di stringa il risultato che esce dal ciclo quindi definisco attributomovie e attributosong ed inserisco ogni movie e ogni song che esce dal ciclo
    @GetMapping("/movies")
    public String movies(Model model) {
        List<Movie> movieList = getBestMovie();
        String attributeMovie = "";
        for (Movie movie:movieList) {
            attributeMovie += "id del film " + movie.getId() + ", " + "nome del film: " + movie.getTitle() + "||||| ";
        }

        model.addAttribute("movies",attributeMovie);
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        List<Song> songsList = getBestSongs();
        String attributeSongs = "";
        for (Song songs:songsList) {
            attributeSongs += "id del film " + songs.getId() + ", " + "nome del film: " + songs.getTitle() + "||||| ";
        }

        model.addAttribute("songs",attributeSongs);
        return "songs";
    }

//    creo i metodi privati per la restituizione dei film e le canzoni

    private List<Movie> getBestMovie(){
        List<Movie> bestMovies = new ArrayList<>();
//        per ogni bestMovie addo in lista con id e titolo
        bestMovies.add(new Movie(1,"Rocky 1"));
        bestMovies.add(new Movie(2,"Rocky 2"));
        bestMovies.add(new Movie(3,"Rocky 3"));
        bestMovies.add(new Movie(4,"Rocky 4"));
        bestMovies.add(new Movie(5,"Rambo 1"));
        return bestMovies;
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

