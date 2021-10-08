package com.movie.start.error.response;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class Response
{

    private HttpStatus status;

    private Timestamp timestamp;

    private String message;

    private String mesaggeError;

    private Throwable debugMessage;

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
        this.debugMessage = ex.getCause();
    }

    public Response(HttpStatus status, String message, Throwable ex)
    {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getCause();
    }

    public Response(HttpStatus status, String message, String mesaggeError, Throwable ex)
    {
        this();
        this.status = status;
        this.message = message;
        this.mesaggeError = mesaggeError;
        this.debugMessage = ex.getCause();
    }

}
