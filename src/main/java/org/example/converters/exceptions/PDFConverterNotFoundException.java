package org.example.converters.exceptions;

public class PDFConverterNotFoundException extends PDFConversionGeneralException{
    public PDFConverterNotFoundException() {
    }

    public PDFConverterNotFoundException(String message) {
        super(message);
    }

    public PDFConverterNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PDFConverterNotFoundException(Throwable cause) {
        super(cause);
    }

    public PDFConverterNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
