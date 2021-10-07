package com.icons.geographic.start.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CiudadPaisAndIconDto
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
    private ContinenteDto continenteEntity;

    @NotEmpty
    private List<IconDtoEdited> iconList = new ArrayList<IconDtoEdited>();

}
