package br.com.fullstack.gerenciamentotutorias.exceptions;

public class NotFountException extends RuntimeException{

    public NotFountException(){
        super();
    }

    public NotFountException(String message){
        super(message);
    }
}
