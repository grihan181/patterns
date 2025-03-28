package org.example.factory.exception;

import java.text.MessageFormat;

import static org.example.constant.ExceptionMessageException.INCORRECT_PRICE;

public class ModelPriceOutOfBoundsException extends RuntimeException {

    public ModelPriceOutOfBoundsException(int price) {
        super(MessageFormat.format(INCORRECT_PRICE, price));
    }

}