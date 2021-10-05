package com.icons.geographic.start.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IconDtoEdited {

    @JsonProperty(access = Access.READ_ONLY)
    private Long id;

    private String img;

    private String denominacion;
    @DateTimeFormat
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaCreacion;

    private Float altura;
    @JsonIgnore
    private Boolean deleted = Boolean.FALSE;

    private String historia;
}
