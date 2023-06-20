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

    //ho visogno di iterare la lista e passare sotto forma di stringa il risultato che esce dal ciclo quindi definisco attributomovie e attributosong ed inserisco ogni movie e ogni song che esce dal ciclo
    @GetMapping("/movies")
    public String movies(Model model) {
        List<Movie> movieList = getBestMovie();
        String attrMovieTemplate = "";
        for (Movie movie:movieList) {
            attrMovieTemplate += "id del film " + movie.getId() + ", " + "nome del film: " + movie.getTitle() + "||||| ";
        }

        model.addAttribute("movies",attrMovieTemplate);
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        List<Songs> songsList = getBestSongs();
        String attrSongsTemplate = "";
        for (Songs songs:songsList) {
            attrSongsTemplate += "id del film " + songs.getId() + ", " + "nome del film: " + songs.getTitle() + "||||| ";
        }

        model.addAttribute("songs",attrSongsTemplate);
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

    private List<Songs> getBestSongs(){
        List<Songs> bestSong = new ArrayList<>();
        //        per ogni bestSong addo in lista con id e titolo
        bestSong.add(new Songs(1,"Otherside"));
        bestSong.add(new Songs(2,"Viva la vida"));
        bestSong.add(new Songs(3,"Wonderwall"));
        bestSong.add(new Songs(4,"Miss You"));
        bestSong.add(new Songs(5,"American Idiot"));
        bestSong.add(new Songs(6,"Toxicity"));
        return bestSong;
    }




}

