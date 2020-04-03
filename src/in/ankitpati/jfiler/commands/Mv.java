package in.ankitpati.jfiler.commands;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Mv extends Cp {
    public Mv(ArrayList<String> files) throws IllegalArgumentException {
        super(files);
    }

    protected void incorrectArguments() throws IllegalArgumentException {
        throw new IllegalArgumentException("Usage:\n\tmv <source> <target>");
    }

    protected void action(Path source, Path target) throws IOException {
        Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
}
