package in.ankitpati.jfiler.commands;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Touch {
    ArrayList<String> files;

    public Touch(ArrayList<String> files) throws IllegalArgumentException {
        if (files.size() == 0)
            throw new IllegalArgumentException("Usage:\n\ttouch <target>...");

        this.files = files;
    }

    public void run() throws IOException {
        for (String file : files) {
            Path target = Paths.get(file).toAbsolutePath();

            if (target.getParent() != null && !Files.exists(target.getParent(),
                                                    LinkOption.NOFOLLOW_LINKS))
                Files.createDirectories(target.getParent());

            if (!new File(file).createNewFile())
                System.err.println(file + ": File/Directory exists.");
        }
    }
};
