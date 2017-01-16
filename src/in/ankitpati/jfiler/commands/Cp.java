package in.ankitpati.jfiler.commands;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Cp {
    ArrayList<String> files;

    public Cp(ArrayList<String> files) throws IllegalArgumentException {
        if (files.size() != 2) incorrectArguments();
        this.files = files;
    }

    protected void incorrectArguments() throws IllegalArgumentException {
        throw new IllegalArgumentException("Usage:\n\tcp <source> <target>");
    }

    protected void action(Path source, Path target) throws IOException {
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES, LinkOption.NOFOLLOW_LINKS);
    }

    public void run() throws IOException {
        Path source = Paths.get(files.get(0)).toAbsolutePath(),
             target = Paths.get(files.get(1)).toAbsolutePath();

        if (!Files.exists(source, LinkOption.NOFOLLOW_LINKS))
            throw new FileNotFoundException(files.get(0) +
                                                " (No such file or directory)");

        if (target.getParent() != null && !Files.exists(target.getParent(),
                                                    LinkOption.NOFOLLOW_LINKS))
            Files.createDirectories(target.getParent());

        if (Files.isDirectory(target, LinkOption.NOFOLLOW_LINKS))
            target = Paths.get(target.toString(),
                                            source.getFileName().toString());

        action(source, target);
    }
};
