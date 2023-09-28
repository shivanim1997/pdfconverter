package org.example.converters.impl;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.example.converters.factories.PDFConverterFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.example.converters.PDFConverter;

public class ConverterFromXML extends PDFConverter {

//  Converts the source text file to a PDF document.
//  @throws IOException if an I/O error occurs during the conversion process.

    @Override
    public void run() {
        final String source = this.source;
        final String destination = this.destination;
        try {
            // Step 1: Load the XML file
            File xmlFile = new File(source); // Replace with your XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Step 2: Normalize the document (optional but recommended)
            doc.getDocumentElement().normalize();

            // Step 3: Create a text file
            File textFile = new File("HELLLOOOOOO.txt"); // Specify the output text file path
            BufferedWriter writer = new BufferedWriter(new FileWriter(textFile));

            // Step 4: Traverse the XML structure and extract text content
            extractTextFromNode(doc.getDocumentElement(), writer);

            // Step 5: Close the writer
            writer.close();

            PDFConverter converter = new ConverterFromText();
            converter.setSource("HELLLOOOOOO.txt");
            converter.setDestination(destination);
            converter.run();

            textFile.delete();

            System.out.println("XML file has been converted to PDF.");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException | ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    private static void extractTextFromNode(Node node, BufferedWriter writer) throws IOException {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node childNode = childNodes.item(i);
                extractTextFromNode(childNode, writer);
            }
        } else if (node.getNodeType() == Node.TEXT_NODE) {
            // Write text content to the text file
            writer.write(node.getTextContent());
        }
    }
}
