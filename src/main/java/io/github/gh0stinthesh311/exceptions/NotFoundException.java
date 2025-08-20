package io.github.gh0stinthesh311.exceptions;

public class NotFoundException extends  RuntimeException{
    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
