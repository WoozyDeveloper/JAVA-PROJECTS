package Exceptions;

public class InvalidItemException extends Exception{
    public InvalidItemException(Exception ex){ super("Item invalid",ex);}
}
