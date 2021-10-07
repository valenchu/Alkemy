package com.icons.geographic.start.dto;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CiudadPaisDto
{

    @JsonProperty(access = Access.READ_ONLY)
    private Long id;

    @NotEmpty
    private String img;

    @NotEmpty
    private String denominacion;

    @NotEmpty
    private Long cantHabitante;

    @NotEmpty
    private Float superficie;// m2

    @NotEmpty
    private Long idContinente;
}
