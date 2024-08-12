package hu.temetkezes.demo.exception;

public class ApiException extends RuntimeException{

    public ApiException(String message){
        super(message);
    }
    public ApiException(){
        super("ApiException cached!");
    }
}
