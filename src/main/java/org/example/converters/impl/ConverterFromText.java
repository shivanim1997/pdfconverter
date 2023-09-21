package org.example.converters.impl;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.example.converters.PDFConverter;

import java.io.*;

public class ConverterFromText extends PDFConverter {

    @Override
    public void run() throws IOException {
        final String source = this.source;
        final String destination = this.destination;

        PDDocument pdfDocument = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        pdfDocument.addPage(page);

        // Create a content stream for the PDF
        PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, page);
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

        // Read the text from the text file and add it to the PDF
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;
            float yPosition = page.getMediaBox().getHeight() - 20; // Starting position

            while ((line = reader.readLine()) != null) {
                contentStream.beginText();
                contentStream.newLineAtOffset(20, yPosition);
                contentStream.showText(line);
                contentStream.endText();
                yPosition -= 15; // Adjust for the next line
            }
        }

        // Close the content stream and save the PDF
        contentStream.close();

        try (OutputStream outputStream = new FileOutputStream(destination)) {
            pdfDocument.save(outputStream);
        }

        pdfDocument.close();

        System.out.println("Text file to PDF conversion completed.");
    }
}
