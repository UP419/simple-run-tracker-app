package com.example.springapp.run;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JdbcRunRepository extends ListCrudRepository<Run, Integer> {

    List<Run> findAllByLocation(Location location);

}
