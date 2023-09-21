package org.example;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.example.converters.factories.PDFConverterFactory;

import java.io.*;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        String source = "C:\\Users\\smilindm\\IdeaProjects\\pdfconverter\\src\\main\\resources\\HELLLOOOOOO.html";
        String destinationPath = "C:\\Users\\smilindm\\IdeaProjects\\pdfconverter\\src\\main\\resources\\";

        try {
            PDFConverterFactory.convert(source, destinationPath);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}