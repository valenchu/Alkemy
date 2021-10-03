package com.icons.geographic.start.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.icons.geographic.start.entity.ContinenteEntity;
import com.icons.geographic.start.entity.IconGeograficoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CiudadPaisDto {

    @JsonProperty(access = Access.AUTO)
    private Long id;
    @NotEmpty
    private String img;
    @NotEmpty
    private String denominacion;
    @NotEmpty
    private Long cantHabitante;
    @NotEmpty
    private Float superficie;// m2
    private ContinenteDto continenteEntity;
}
