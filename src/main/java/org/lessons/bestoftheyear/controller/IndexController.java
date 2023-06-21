package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.model.Song;
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







}

