package org.example;

import org.example.converters.PDFConverter;
import org.example.converters.factories.PDFConverterFactory;


public class Main {
    public static void main(String[] args) {

        String source = "C:\\Users\\smilindm\\IdeaProjects\\pdfconverter\\src\\main\\resources\\HELLLOOOOOO.html";
        String destinationPath = "C:\\Users\\smilindm\\IdeaProjects\\pdfconverter\\src\\main\\resources\\";

        try {
            PDFConverter converter = PDFConverterFactory.getConverter(source, destinationPath);
            converter.run();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}