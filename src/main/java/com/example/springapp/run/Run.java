package com.example.springapp.run;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

public record Run(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startDate,
        LocalDateTime endDate,
        @Positive
        double distance,
        Location location,
        @Version
        Integer version) {
// version is a way to track whether this is new or existing row

    public Run {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Wrong dates!");
        }
    }
}
