package pl.sda.springbootbank.exceptions;

public class ClientAccountNotFoundException extends  Exception{

    public ClientAccountNotFoundException(String message){
        super(message);
    }
}
