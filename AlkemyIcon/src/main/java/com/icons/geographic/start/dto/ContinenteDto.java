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
public class ContinenteDto {
    @JsonProperty(access = Access.AUTO)
    private Long id;
    @NotEmpty
    private String img;
    @NotEmpty
    private String denominacion;
}
