package com.movie.start.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping("movie")
@CrossOrigin("*")
public class MovieController {

}
