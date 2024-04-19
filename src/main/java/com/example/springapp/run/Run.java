package com.example.springapp.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(int id,
                  @NotEmpty
                  String title,
                  LocalDateTime startDate,
                  LocalDateTime endDate,
                  @Positive
                  double distance,
                  Location location) {


    public Run {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Wrong dates!");
        }
    }
}
