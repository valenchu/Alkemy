package com.icons.geographic.start.error;

public class MesaggeError extends RuntimeException
{
    public MesaggeError(String error, Throwable e)
    {
        super(error, e);
    }

    public MesaggeError(String error)
    {
        super(error);
    }
}
