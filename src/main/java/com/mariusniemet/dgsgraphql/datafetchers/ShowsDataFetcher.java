package com.mariusniemet.dgsgraphql.datafetchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mariusniemet.dgsgraphql.dto.CreateShowInput;
import com.mariusniemet.dgsgraphql.entities.Show;
import com.mariusniemet.dgsgraphql.services.ShowsService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import graphql.schema.DataFetchingEnvironment;

import java.util.List;
import java.util.Map;
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

        System.out.println(createShowInput.getTitle());

        return this.service.create(createShowInput);
    }
}
