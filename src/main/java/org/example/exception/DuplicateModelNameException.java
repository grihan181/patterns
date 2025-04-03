package org.example.exception;

import java.text.MessageFormat;

import static org.example.constant.ExceptionMessageConst.ALREADY_MODEL_NAME;

public class DuplicateModelNameException extends Exception {

    public DuplicateModelNameException(String name) {
        super((MessageFormat.format(ALREADY_MODEL_NAME, name)));
    }

}