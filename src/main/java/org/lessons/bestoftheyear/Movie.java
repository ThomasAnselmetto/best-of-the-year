package org.lessons.bestoftheyear;

public class Movie {
    //Attributi
    private int id;
    private String title;
    //Costruttore

    public Movie(int id, String title) {
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
