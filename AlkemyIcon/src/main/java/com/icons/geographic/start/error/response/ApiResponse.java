package com.icons.geographic.start.error.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

public abstract class ApiResponse
{

}

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
class ExtApiResponse extends ApiResponse
{
    private String object;

    private String field;

    private Object rejectedValue;

    private String message;

    ExtApiResponse(String object, String message)
    {
        this.object = object;
        this.message = message;
    }
}
