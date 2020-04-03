package in.ankitpati.jfiler.commands;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Mkdir {
    ArrayList<String> files;

    public Mkdir(ArrayList<String> files) throws IllegalArgumentException {
        if (files.size() == 0)
            throw new IllegalArgumentException("Usage:\n\tmkdir <target>...");

        this.files = files;
    }

    public void run() throws IOException {
        for (String file : files) {
            Path target = Paths.get(file).toAbsolutePath();

            if (!Files.exists(target, LinkOption.NOFOLLOW_LINKS))
                Files.createDirectories(target);
        }
    }
}
