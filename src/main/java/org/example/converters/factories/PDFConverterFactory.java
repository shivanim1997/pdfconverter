package org.example.converters.factories;

import org.example.converters.PDFConverter;
import org.example.converters.exceptions.*;
import org.example.converters.impl.ConverterFromDocx;
import org.example.converters.impl.ConverterFromHTML;
import org.example.converters.impl.ConverterFromText;
import org.example.converters.impl.ConverterFromXML;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;



public class PDFConverterFactory {

     // A mapping of file extensions to corresponding PDFConverter implementations.

    private static final Map<String, Class<? extends PDFConverter>> CONVERTERS = Map.ofEntries(
            Map.entry("TXT", ConverterFromText.class),
            Map.entry("DOCX", ConverterFromDocx.class),
            Map.entry("DOCS", ConverterFromDocx.class),
            Map.entry("HTML", ConverterFromHTML.class),
            Map.entry("XML", ConverterFromXML.class)
    );


    public static PDFConverter getConverter(String source, String destinationFolder) throws PDFConversionGeneralException {
        PDFConverter converter;
         String incomingFileType = source.substring(source.lastIndexOf(".") + 1).toUpperCase();

        if (!CONVERTERS.containsKey(incomingFileType)) {
            throw new PDFConverterNotFoundException("Converter not found for file type: " + incomingFileType);
        }
        try {
            converter = CONVERTERS.get(incomingFileType).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new PDFConverterCouldNotInstantiateException(e);
        } catch (IllegalAccessException e) {
            throw new PDFConverterNotAccessibleException(e);
        } catch (Exception e) {
            throw new PDFConversionGeneralException(e);
        }

        Path path = Paths.get(source);

        // Get the file name without extension
        String fileName = path.getFileName().toString();
        int lastIndex = fileName.lastIndexOf('.');

         String fileNameWithoutExtension = fileName.substring(0, lastIndex);
         String destination = destinationFolder + fileNameWithoutExtension + ".pdf";


        converter.setSource(source);
        converter.setDestination(destination);

        return converter;
    }

}
