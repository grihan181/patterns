package org.example.exception;

import java.text.MessageFormat;

import static org.example.constant.ExceptionMessageConst.MODEL_NAME_NOT_FOUND;

public class NoSuchModelNameException extends Exception {

    public NoSuchModelNameException(String name) {
        super(MessageFormat.format(MODEL_NAME_NOT_FOUND, name));
    }

}
