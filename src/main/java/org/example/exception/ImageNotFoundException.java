package org.example.exception;

import static org.example.constant.ExceptionMessageConst.IMAGE_NOT_FOUND;

public class ImageNotFoundException extends Exception {
    public ImageNotFoundException() {
        super(IMAGE_NOT_FOUND);
    }
}
