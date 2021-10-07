package com.icons.geographic.start.error.response;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Response
{

    private HttpStatus status;

    private Timestamp timestamp;

    private String message;

    private String mesaggeError;

    private String debugMessage;

    private List<ApiResponse> subErrors;

    private Response()
    {
        timestamp = Time.getTime();
    }

    public Response(HttpStatus status)
    {
        this();
        this.status = status;
    }

    public Response(HttpStatus status, Throwable ex)
    {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    public Response(HttpStatus status, String message, Throwable ex)
    {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

    public Response(HttpStatus status, String message, String mesaggeError, Throwable ex)
    {
        this();
        this.status = status;
        this.message = message;
        this.mesaggeError = mesaggeError;
        this.debugMessage = ex.getLocalizedMessage();
    }

}
