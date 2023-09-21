package org.example.converters.exceptions;

public class PDFConverterNotAccessibleException extends PDFConversionGeneralException{
    public PDFConverterNotAccessibleException() {
    }

    public PDFConverterNotAccessibleException(String message) {
        super(message);
    }

    public PDFConverterNotAccessibleException(String message, Throwable cause) {
        super(message, cause);
    }

    public PDFConverterNotAccessibleException(Throwable cause) {
        super(cause);
    }

    public PDFConverterNotAccessibleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
