package dev.attilatorok;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utils {

    public static BufferedReader getBufferedReader(final String fileName) {
        InputStream ioStream = Utils.class
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }

        InputStreamReader isr = new InputStreamReader(ioStream);
        return new BufferedReader(isr);
    }

}
