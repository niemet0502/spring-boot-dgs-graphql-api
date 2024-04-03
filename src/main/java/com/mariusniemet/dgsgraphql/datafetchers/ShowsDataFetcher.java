package com.mariusniemet.dgsgraphql.datafetchers;

import com.mariusniemet.dgsgraphql.dto.CreateShowInput;
import com.mariusniemet.dgsgraphql.dto.UpdateShowInput;
import com.mariusniemet.dgsgraphql.entities.Show;
import com.mariusniemet.dgsgraphql.services.ShowsService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.apache.coyote.BadRequestException;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class ShowsDataFetcher {
    private final ShowsService service;

    public ShowsDataFetcher(ShowsService service){
        this.service = service;
    }

    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter) {
        if(titleFilter == null) {
            return this.service.findAll();
        }

        return this.service.findAll().stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
    }

    @DgsMutation
        public Show createShow(@InputArgument("createShowInput") CreateShowInput createShowInput){

        return this.service.create(createShowInput);
    }

    @DgsMutation
    public Show removeShow(@InputArgument Integer id) throws BadRequestException {
        return this.service.remove((long) id);
    }

    @DgsMutation
    public Show updateShow(@InputArgument("updateShowInput")UpdateShowInput updateShowInput) throws BadRequestException {
        return this.service.update(updateShowInput);
    }


}
