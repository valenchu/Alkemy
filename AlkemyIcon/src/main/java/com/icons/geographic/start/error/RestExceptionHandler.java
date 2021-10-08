package com.icons.geographic.start.error;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.icons.geographic.start.error.response.ApiResponse;
import com.icons.geographic.start.error.response.Response;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler
{
    List<ApiResponse> api = new ArrayList<ApiResponse>();

    // Method return Response
    private ResponseEntity<Object> buildResponseEntity(Response response)
    {
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException exep)
    {
        Response response = new Response(HttpStatus.NOT_FOUND);
        response.setMessage(exep.getMessage());

        return buildResponseEntity(response);

    }

    @ExceptionHandler(value = {MesaggeError.class})
    public ResponseEntity<Object> handleBadRequest(MesaggeError exep, WebRequest re)
    {
        
        Response response = new Response(HttpStatus.NOT_FOUND, re.toString(), exep.getMessage(), exep);
        response.setSubErrors(api);
        return buildResponseEntity(response);

    }
    
    

}
