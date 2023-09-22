package org.example.converters.exceptions;

public class PDFConversionGeneralException extends Exception {
    public PDFConversionGeneralException() {
    }

    public PDFConversionGeneralException(String message) {
        super(message);
    }

    public PDFConversionGeneralException(String message, Throwable cause) {
        super(message, cause);
    }

    public PDFConversionGeneralException(Throwable cause) {
        super(cause);
    }

    public PDFConversionGeneralException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
