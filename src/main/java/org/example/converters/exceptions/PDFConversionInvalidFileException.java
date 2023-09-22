package org.example.converters.exceptions;

public class PDFConversionInvalidFileException extends PDFConversionGeneralException {
        public PDFConversionInvalidFileException() {
        }

        public PDFConversionInvalidFileException(String message) {
            super(message);
        }

        public PDFConversionInvalidFileException(String message, Throwable cause) {
            super(message, cause);
        }

        public PDFConversionInvalidFileException(Throwable cause) {
            super(cause);
        }

        public PDFConversionInvalidFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

