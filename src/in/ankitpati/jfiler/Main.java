package in.ankitpati.jfiler;

import java.io.*;
import java.util.*;
import in.ankitpati.jfiler.commands.*;

class Main {
    public static void main(String args[]) {
        ArrayList<String> commandArgs =
                                    new ArrayList<String>(Arrays.asList(args));
        commandArgs.remove(0);
    }
};
