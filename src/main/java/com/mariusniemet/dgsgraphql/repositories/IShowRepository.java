package com.mariusniemet.dgsgraphql.repositories;

import com.mariusniemet.dgsgraphql.entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShowRepository extends JpaRepository<Show, Long> {
}
