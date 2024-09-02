package com.telusko.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookErrorDetails {

    private String message;
    private String description;
    private LocalDateTime when;
}
