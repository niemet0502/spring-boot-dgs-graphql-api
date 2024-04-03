package com.mariusniemet.dgsgraphql.services;

import com.mariusniemet.dgsgraphql.dto.CreateShowInput;
import com.mariusniemet.dgsgraphql.dto.UpdateShowInput;
import com.mariusniemet.dgsgraphql.entities.Show;
import com.mariusniemet.dgsgraphql.repositories.IShowRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowsService {

    private final IShowRepository repository;

    public ShowsService(IShowRepository repository){
        this.repository = repository;
    }
    private final ArrayList<Show> shows = new ArrayList<>();
    public List<Show> findAll(){
        return this.repository.findAll();
    }

    public Show create(CreateShowInput input){
        Show newShow = new Show(input.getTitle(), input.getReleaseYear());

        this.repository.save(newShow);
        return newShow;
    }

    public Show remove(Long id) throws BadRequestException {
        Optional<Show> result = this.repository.findById(id);

        if (result.isEmpty()){
            throw new BadRequestException("Show not found");
        }

        Show toDelete = result.get();

        this.repository.delete(toDelete);

        return toDelete;
    }

    public Show update(UpdateShowInput updateShowInput) throws BadRequestException{
        Optional<Show> result = this.repository.findById((long) updateShowInput.getId());

        if (result.isEmpty()){
            throw new BadRequestException("Show not found");
        }
        Show toUpdate = result.get();
        toUpdate.setTitle(updateShowInput.getTitle());
        toUpdate.setReleaseYear(updateShowInput.getReleaseYear());

        return  toUpdate;
    }
}
