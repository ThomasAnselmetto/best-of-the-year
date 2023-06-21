package org.lessons.bestoftheyear.model;

public class Song {
    //Attributi
    private int id;
    private String title;

//Costruttore


    public Song(int id, String title) {
        this.id = id;
        this.title = title;
    }

    //Getters

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
