package org.example.converters.impl;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.example.converters.PDFConverter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ConverterFromDocx extends PDFConverter {

    @Override
    public void run() {
        try {
            final String source = this.source;
            final String destination = this.destination;

            FileInputStream docxFileInputStream = new FileInputStream(source);
            XWPFDocument docxDocument = new XWPFDocument(docxFileInputStream);

            // Create a PDF document
            PDDocument pdfDocument = new PDDocument();
            PDPage pdfPage = new PDPage(PDRectangle.A4);
            pdfDocument.addPage(pdfPage);

            // Create a content stream for the PDF
            PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, pdfPage);
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

            // Extract text from the DOCX and add it to the PDF
            for (var paragraph : docxDocument.getParagraphs()) {
                contentStream.beginText();
                contentStream.newLineAtOffset(20, 700); // Adjust position as needed
                contentStream.showText(paragraph.getText());
                contentStream.newLine();
            }

            // Close the content stream
            contentStream.close();

            // Save the PDF to the specified file
            OutputStream pdfOutputStream = new FileOutputStream(destination);
            pdfDocument.save(pdfOutputStream);
            pdfDocument.close();

            System.out.println("DOCX to PDF conversion completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
