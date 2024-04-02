package com.mariusniemet.dgsgraphql.dto;

public class UpdateShowInput extends CreateShowInput{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
