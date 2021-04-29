package com.lilso.lireddit.exceptions;

public class LiredditException extends RuntimeException{
    public LiredditException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public LiredditException(String exMessage) {
        super(exMessage);
    }
}
