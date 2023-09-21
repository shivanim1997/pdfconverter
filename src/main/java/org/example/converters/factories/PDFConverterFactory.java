package org.example.converters.factories;

import org.example.converters.PDFConverter;
import org.example.converters.exceptions.PDFConversionGeneralException;
import org.example.converters.exceptions.PDFConverterCouldNotInstantiateException;
import org.example.converters.exceptions.PDFConverterNotAccessibleException;
import org.example.converters.exceptions.PDFConverterNotFoundException;
import org.example.converters.impl.ConverterFromDocx;
import org.example.converters.impl.ConverterFromHTML;
import org.example.converters.impl.ConverterFromText;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.nio.file.Path;
import java.nio.file.Paths;
public class PDFConverterFactory {

    private static final Map<String, Class<? extends PDFConverter>> converters = Map.ofEntries(
            Map.entry("TXT", ConverterFromText.class),
            Map.entry("DOCX", ConverterFromDocx.class),
            Map.entry("DOCS", ConverterFromDocx.class),
            Map.entry("HTML", ConverterFromHTML.class)
    );

    public static String convert(String source, String destinationFolder) throws PDFConversionGeneralException {
        PDFConverter converter;
        final String incomingFileType = source.substring(source.lastIndexOf(".") + 1).toUpperCase();

        try {
            converter = converters.get(incomingFileType).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new PDFConverterCouldNotInstantiateException(e);
        } catch (IllegalAccessException e) {
            throw new PDFConverterNotAccessibleException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new PDFConverterNotFoundException(e);
        } catch (Exception e) {
            throw new PDFConversionGeneralException(e);
        }

        Path path = Paths.get(source);

        // Get the file name without extension
        String fileName = path.getFileName().toString();
        int lastIndex = fileName.lastIndexOf('.');

        final String fileNameWithoutExtension = fileName.substring(0, lastIndex);
        final String destination = destinationFolder + fileNameWithoutExtension + ".pdf";


        try {
            converter.setSource(source);
            converter.setDestination(destination);
            converter.run();
        } catch (IOException e) {
            throw new PDFConversionGeneralException(e);
        }

        return destination;
    }
}
