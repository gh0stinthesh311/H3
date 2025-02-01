package io.github.soydivision.exceptions;

/*
 * RuntimeException is an Exception that is not checked at compile time.
 * The size of table should not be checked during compilation,
 * because the size is defined during the execution (that is runtime).
 * */

public class TableSizeException extends RuntimeException {
    public TableSizeException(String errorMessage) {
        super(errorMessage);
    }
}
