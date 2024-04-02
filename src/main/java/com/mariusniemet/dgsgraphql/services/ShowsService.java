package com.mariusniemet.dgsgraphql.services;

import com.mariusniemet.dgsgraphql.dto.CreateShowInput;
import com.mariusniemet.dgsgraphql.dto.UpdateShowInput;
import com.mariusniemet.dgsgraphql.entities.Show;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowsService {
    private final ArrayList<Show> shows = new ArrayList<>();
    public List<Show> findAll(){
        return this.shows;
    }

    public Show create(CreateShowInput input){
        int len = this.shows.size();
        Show newShow = new Show(input.getTitle(), input.getReleaseYear(), ++len);


        this.shows.add(newShow);
        return newShow;
    }

    public Show remove(int id) throws BadRequestException {
        Optional<Show> result = this.shows.stream().filter(s -> s.getId() == id).findFirst();

        if (result.isEmpty()){
            throw new BadRequestException("Show not found");
        }

        this.shows.removeIf(s -> s.getId() == id);

        return result.get();
    }

    public Show update(UpdateShowInput updateShowInput) throws BadRequestException{
        Optional<Show> result = this.shows.stream().filter(s -> s.getId() == updateShowInput.getId()).findFirst();

        if (result.isEmpty()){
            throw new BadRequestException("Show not found");
        }

        Show updated = new Show(updateShowInput.getTitle(), updateShowInput.getReleaseYear(), updateShowInput.getId());

        this.shows.replaceAll(s -> s.getId() == updateShowInput.getId() ? updated : s);

        return  updated;
    }
}
