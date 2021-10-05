package com.icons.geographic.start.dto;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IconFilterDto {

    private String deno;
    @DateTimeFormat
    private LocalDate date;
    private Set<Long> idCity;

}
