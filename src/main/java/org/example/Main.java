package org.example;

import org.example.converters.PDFConverter;
import org.example.converters.factories.PDFConverterFactory;


public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        String source = "C:\\Users\\smilindm\\IdeaProjects\\pdfconverter\\src\\main\\resources\\HELLLOOOOOO.xml";
        String destinationPath = "C:\\Users\\smilindm\\IdeaProjects\\pdfconverter\\src\\main\\resources\\";

        try {
            PDFConverter converter = PDFConverterFactory.getConverter(source, destinationPath);
            Thread t1 = new Thread(converter);   // Using the constructor Thread(Runnable r)
            t1.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Record the end time
        long endTime = System.currentTimeMillis();

        // Calculate and display the running time
        long runningTime = endTime - startTime;
        System.out.println("Main method running time: " + runningTime + " milliseconds");
    }
}