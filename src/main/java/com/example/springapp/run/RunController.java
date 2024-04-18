package com.example.springapp.run;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }


    @GetMapping("/getAllRuns")
    List<Run> findAll() {
        return runRepository.findAll();
    }

    @GetMapping("/getRun/{id}")
    Run findById(@PathVariable int id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isPresent()) {
            return run.get();
        } else {
            throw new RunNotFoundException("Run not Found!");
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addRun")
    void create(@Valid @RequestBody Run run) {
        runRepository.create(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteRun/{id}")
    void delete(@PathVariable int id) {
        runRepository.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    void update(@Valid @RequestBody Run run, @PathVariable int id) {
        runRepository.update(run, id);
    }
}
