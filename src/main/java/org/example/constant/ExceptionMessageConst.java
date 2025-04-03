package org.example.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessageConst {

    public static final String NEGATIVE_COUNT_MODEL = "The number of models cannot be negative";
    public static final String ALREADY_MODEL_NAME = "The model named {0} already exists";
    public static final String INCORRECT_PRICE = "Price = {0} is incorrect";
    public static final String EMPTY_NAME = "The model name cannot be empty";
    public static final String MODEL_NAME_NOT_FOUND = "The model named {0} does not exist";
    public static final String IMAGE_NOT_FOUND = "The image does not exist";
}
