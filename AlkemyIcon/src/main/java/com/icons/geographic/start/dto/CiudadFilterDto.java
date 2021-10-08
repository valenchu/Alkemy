package com.icons.geographic.start.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CiudadFilterDto
{
    String name;

    Set<Long> idCont;

    String ascDesc;

    public boolean isASC()
    {
        return this.ascDesc.compareToIgnoreCase("ASC") == 0;
    }

    public boolean isDESC()
    {
        return this.ascDesc.compareToIgnoreCase("DESC") == 0;
    }
}
