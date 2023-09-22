package org.example.converters;

import java.io.IOException;

public abstract class PDFConverter {
    protected String source;
    protected String destination;

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public abstract void run() throws IOException;

}
