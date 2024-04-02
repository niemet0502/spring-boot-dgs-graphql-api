package com.mariusniemet.dgsgraphql.entities;

public class Show {
    private int id;
    private final String title;
    private final Integer releaseYear;

    public Show(String title, Integer releaseYear, int id) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
