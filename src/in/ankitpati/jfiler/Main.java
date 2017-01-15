package in.ankitpati.jfiler;

import java.io.*;
import java.util.*;
import in.ankitpati.jfiler.commands.*;

class Main {
    public static void main(String args[]) {
        ArrayList<String> commandArgs =
                                    new ArrayList<String>(Arrays.asList(args));
        commandArgs.remove(0);

        try {
            switch (args[0].toLowerCase()) {
            default:
                System.err.println("jFiler: Unrecognised operation!");
                break;
            }
        }

        catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        }
    }
};
