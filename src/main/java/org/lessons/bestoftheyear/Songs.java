package org.lessons.bestoftheyear;

public class Songs {
    //Attributi
    private int id;
    private String title;

//Costruttore


    public Songs(int id, String title) {
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
