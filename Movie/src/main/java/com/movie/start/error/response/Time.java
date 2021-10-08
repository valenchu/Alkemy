package com.movie.start.error.response;

import java.sql.Timestamp;

public class Time
{

    public static Timestamp getTime()
    {
        return new Timestamp(System.currentTimeMillis());
    }
    

}
