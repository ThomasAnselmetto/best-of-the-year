package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.model.Movie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @GetMapping()
    public String movies(Model model) {
        List<Movie> movieList = getBestMovie();

        model.addAttribute("movies",movieList);
        return "movies";
    }
    @GetMapping("/{id}")
    public String movieDetail(Model model,@PathVariable int id){
//        ora che ho i movie e l'id nel path della url ciclo per ottenere il film di riferimento a quell'id'
        Movie movie = null;
        for (Movie singleMovie : getBestMovie()) {
            if(singleMovie.getId() == id) {
                movie = singleMovie;
            }
        }

        if(movie != null) {
            model.addAttribute("movie", movie);
            return "movieDetail";
        } else {
            return "redirect:/";
        }
    }
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
}
