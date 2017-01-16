package in.ankitpati.jfiler;

import java.io.*;
import java.util.*;
import in.ankitpati.jfiler.commands.*;

class Main {
    public static void main(String args[]) {
        if (args.length == 0) {
            System.err.println(
                    "Usage:\n\tjava -jar jFiler.jar <operation> [argument]...");
            System.exit(1);
        }

        ArrayList<String> commandArgs =
                                    new ArrayList<String>(Arrays.asList(args));
        commandArgs.remove(0);

        try {
            switch (args[0].toLowerCase()) {
            case "cat":
                new Cat(commandArgs).run();
                break;
            case "touch":
                new Touch(commandArgs).run();
                break;
            case "cp":
                new Cp(commandArgs).run();
                break;
            case "mv":
                new Mv(commandArgs).run();
                break;
            case "append":
                new Append(commandArgs).run();
                break;
            case "rm":
                new Rm(commandArgs).run();
                break;
            case "mkdir":
                new Mkdir(commandArgs).run();
                break;
            case "ls":
                new Ls(commandArgs).run();
                break;
            case "chmod":
                new Chmod(commandArgs).run();
                break;
            default:
                System.err.println("jFiler: Unrecognised operation!");
                break;
            }
        }

        catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        }

        catch (FileNotFoundException fnfe) {
            System.err.println(fnfe.getMessage());
        }

        catch (UnsupportedOperationException uoe) {
            System.err.println(uoe.getMessage());
        }

        catch (IOException ioe) {
            System.err.println(ioe.getMessage() +
                                    " could not be read from, or written to!");
        }
    }
};
