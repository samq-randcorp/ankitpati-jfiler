package in.ankitpati.jfiler.commands;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class Ll {
    ArrayList<String> files;

    public Ll(ArrayList<String> files) {
        this.files = files;

        if (this.files.size() == 0) this.files.add(".");
    }

    public void run() throws IOException {
        for (String file : files) {
            File f = new File(file);
            Path p = Paths.get(file);

            if (!Files.exists(p)) {
                System.err.println(file + " (No such file or directory)\n");
                continue;
            }

            String listing[] = f.list();

            if (listing == null) {
                System.out.println(PosixFilePermissions.toString(Files
                            .getPosixFilePermissions(p)) + "  " + file + '\n');
            }
            else {
                Arrays.sort(listing);
                System.out.println(file + ':');
                for (String entry : listing) {
                    System.out.println(PosixFilePermissions.toString(Files
                        .getPosixFilePermissions(p.resolve(entry))) + "  "
                        + entry);
                }
                System.out.println();
            }
        }
    }
}
