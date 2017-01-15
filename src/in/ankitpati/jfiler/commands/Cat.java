package in.ankitpati.jfiler.commands;

import java.io.*;
import java.util.*;

public class Cat {
    ArrayList<String> files;

    public Cat(ArrayList<String> files) throws IllegalArgumentException {
        if (files.size() == 0)
            throw new IllegalArgumentException("Usage:\n\tcat <source>...");

        this.files = files;
    }

    public void run() throws FileNotFoundException, IOException {
        for (String file : files) {
            BufferedReader br = new BufferedReader(
                            new InputStreamReader(new FileInputStream(file)));
            for (String str = br.readLine(); str != null; str = br.readLine())
                System.out.println(str);
        }
    }
};
