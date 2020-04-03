package in.ankitpati.jfiler.commands;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class Rm {
    ArrayList<String> files;

    public Rm(ArrayList<String> files) throws IllegalArgumentException {
        if (files.size() == 0)
            throw new IllegalArgumentException("Usage:\n\trm <target>...");

        this.files = files;
    }

    public void run() throws IOException {
        for (String file : files) {
            Path target = Paths.get(file);

            if (!Files.exists(target, LinkOption.NOFOLLOW_LINKS)) {
                System.err.println(file + " (No such file or directory)");
            }

            else if (Files.isDirectory(target, LinkOption.NOFOLLOW_LINKS)) {
                Files.walkFileTree(target, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file,
                                BasicFileAttributes attr) throws IOException {
                        Files.delete(file);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir,
                                            IOException e) throws IOException {
                        if (e != null) throw e;
                        Files.delete(dir);
                        return FileVisitResult.CONTINUE;
                    }
                });
            }

            else Files.delete(target);
        }
    }
}
