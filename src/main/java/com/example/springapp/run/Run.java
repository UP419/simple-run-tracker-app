package com.example.springapp.run;

import java.time.LocalDateTime;

public record Run(int id,
                  String title,
                  LocalDateTime startDate,
                  LocalDateTime endDate,
                  double distance,
                  Location location) {
}
