package com.mariusniemet.dgsgraphql.services;

import com.mariusniemet.dgsgraphql.dto.CreateShowInput;
import com.mariusniemet.dgsgraphql.entities.Show;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowsService {
    private ArrayList<Show> shows = new ArrayList<Show>();
    public List<Show> findAll(){
        return this.shows;
    }

    public Show create(CreateShowInput input){
        Show newShow = new Show(input.getTitle(), input.getReleaseYear());

        System.out.println(newShow.getTitle());
        this.shows.add(newShow);
        return newShow;
    }
}
