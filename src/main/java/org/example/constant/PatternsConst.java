package org.example.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PatternsConst {

    public static int INIT_MODEL_COUNT = 10;
    public static int PORT = 5000;
    public static String SPACE = " ";
    public static int COUNT_MODEL = 3;
    public static String PRINTER_DIRECTORY = "print/";
    public static String PRINT_ROW_PATTERN = "%s: $%d | ";
    public static String PRINT_TRANSPORT = "%s: size = %s";

    public static String CAR_CLASS_NAME = "org.example.lr1.factory.service.impl.Motorcycle";
    public static String MOTORCYCLE = "Motorcycle";

}