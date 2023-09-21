package org.example.converters.impl;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.example.converters.PDFConverter;

import java.io.*;

public class ConverterFromHTML extends PDFConverter {

    @Override
    public void run() throws IOException {
        final String source = this.source;
        final String destination = this.destination;

        System.out.println("Hello from HTML");
    }
}
