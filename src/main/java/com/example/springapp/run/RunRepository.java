//package com.example.springapp.run;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDateTime;
//import java.time.temporal.ChronoUnit;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//
//@Repository
//public class RunRepository {
//
//    private List<Run> runs = new ArrayList<>();
//
//    List<Run> findAll() {
//        return runs;
//    }
//
//    Optional<Run> findById(int id) {
//        return runs.stream().filter(run -> run.id() == id).findFirst();
//    }
//
//
//    @PostConstruct
//    public void init() {
//        runs.add(new Run(1,
//                "first run",
//                LocalDateTime.now(),
//                LocalDateTime.now().plus(1, ChronoUnit.HOURS),
//                4.5,
//                Location.OUTDOOR)
//        );
//        runs.add(new Run(2,
//                "second run",
//                LocalDateTime.now().plus(3, ChronoUnit.HOURS),
//                LocalDateTime.now().plus(6, ChronoUnit.HOURS),
//                1.2,
//                Location.GYM)
//        );
//    }
//
//    void create(Run run) {
//        runs.add(run);
//    }
//
//    void update(Run run, int id) {
//        runs.removeIf(currRun -> currRun.id() == id);
//        runs.add(run);
//    }
//
//    void delete(int id) {
//        runs.removeIf(run -> run.id() == id);
//    }
//}
