package model.exceptions;

public class DataAlreadyInDB extends Exception{
    public DataAlreadyInDB (String message){
        super(message);
    }
}