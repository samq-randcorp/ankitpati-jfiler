package in.ankitpati.jfiler.commands;

import java.io.*;
import java.util.*;

public class Touch {
    ArrayList<String> files;

    public Touch(ArrayList<String> files) throws IllegalArgumentException {
        if (files.size() == 0)
            throw new IllegalArgumentException("Usage:\n\ttouch <target>...");

        this.files = files;
    }

    public void run() throws IOException {
        for (String file : files) {
            if (!new File(file).createNewFile())
                System.err.println(file + ": File exists.");
        }
    }
};
