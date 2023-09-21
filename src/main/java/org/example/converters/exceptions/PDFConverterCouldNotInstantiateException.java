package org.example.converters.exceptions;

public class PDFConverterCouldNotInstantiateException extends PDFConversionGeneralException{
    public PDFConverterCouldNotInstantiateException() {
    }

    public PDFConverterCouldNotInstantiateException(String message) {
        super(message);
    }

    public PDFConverterCouldNotInstantiateException(String message, Throwable cause) {
        super(message, cause);
    }

    public PDFConverterCouldNotInstantiateException(Throwable cause) {
        super(cause);
    }

    public PDFConverterCouldNotInstantiateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
