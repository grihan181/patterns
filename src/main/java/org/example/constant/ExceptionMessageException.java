package org.example.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessageException {

    public static final String NEGATIVE_COUNT_MODEL = "Количество моделей не может быть отрицательным";
    public static final String ALREADY_MODEL_NAME = "Модель с именем {0} уже существует!";
    public static final String INCORRECT_PRICE = "Цена = {0} некорректна";
    public static final String EMPTY_NAME = "Название модели не может быть пустым";
    public static final String MODEL_NAME_NOT_FOUND = "Модель с именем {0} не существует";
}
