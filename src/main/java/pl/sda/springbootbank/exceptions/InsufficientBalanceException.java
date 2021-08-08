package pl.sda.springbootbank.exceptions;

public class InsufficientBalanceException extends Exception{

    public InsufficientBalanceException(String message) {
        super(message);
    }

}
