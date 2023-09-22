package org.example.converters.impl;

import org.example.converters.PDFConverter;

import java.io.IOException;

public class ConverterFromHTML extends PDFConverter {

    @Override
    public void run() throws IOException {
        final String source = this.source;
        final String destination = this.destination;

        System.out.println("Hello from HTML");
    }
}
