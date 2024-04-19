package com.example.springapp.run;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class H2RunRepository {

    private final JdbcClient jdbcClient;

    public H2RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("select * from Run")
                .query(Run.class)
                .list();
    }

    public Optional<Run> findById(int id) {
        return jdbcClient.sql("select * from Run where id = :id")
                .param("id", id)
                .query(Run.class)
                .optional();
    }


    public void create(Run run) {
        var updated = jdbcClient.sql("insert into Run (id, title, startDate, endDate, distance, location)" +
                        "values (?, ?, ?, ?, ?, ?)")
                .params(List.of(run.id(), run.title(), run.startDate(), run.endDate(), run.distance(), run.location().toString()))
                .update();
        Assert.state(updated == 1, "Failed to create run -" + run.title());
    }

    public void update(Run run, int id) {
        var updated = jdbcClient.sql("update Run set id=?, title=?, startDate=?, endDate=?, distance=?, location=? where id=?")
                .params(List.of(run.id(), run.title(), run.startDate(), run.endDate(), run.distance(), run.location().toString(), id))
                .update();
        Assert.state(updated == 1, "Failed to update run -" + run.title());

    }

    public void delete(int id) {
        var updated = jdbcClient.sql("delete from Run where id = :id")
                .param("id", id)
                .update();
        Assert.state(updated == 1, "Failed to delete run -" + id);

    }

    public int count() {
        return jdbcClient.sql("select * from Run").query().listOfRows().size();
    }

    public void saveAll(List<Run> runs) {
        runs.stream().forEach(this::create);
    }

    public List<Run> findByLocation(Location location) {
        return jdbcClient.sql("select * from Run where location =:location")
                .param("location", location)
                .query(Run.class)
                .list();
    }

}
