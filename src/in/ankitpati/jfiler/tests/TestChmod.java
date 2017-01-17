package in.ankitpati.jfiler.tests;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import org.testng.*;
import org.testng.annotations.*;
import in.ankitpati.jfiler.commands.*;

public class TestChmod {
    ArrayList<String> files = new ArrayList<String>();

    @Test(expectedExceptions = NullPointerException.class)
    public void testNullArgument() {
        new Chmod(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmptyArgument() {
        new Chmod(files);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidMode() {
        files.add("chmod");
        files.add("test/mv.dat");
        new Chmod(files);
    }

    @Test
    public void testValidStringMode() throws IOException {
        files.clear();
        files.add("rwxrwxrwx");
        files.add("test/mv.dat");

        try {
            new Chmod(files).run();
        }
        catch (UnsupportedOperationException uoe) {
            System.err.println(
                        "This operation cannot be tested on this platform.");
            return;
        }

        Assert.assertEquals(PosixFilePermissions.toString(
            Files.getPosixFilePermissions(Paths.get(files.get(1)),
            LinkOption.NOFOLLOW_LINKS)), "rwxrwxrwx");
    }

    @Test
    public void testValidNumericMode() throws IOException {
        files.clear();
        files.add("644");
        files.add("test/mv.dat");

        try {
            new Chmod(files).run();
        }
        catch (UnsupportedOperationException uoe) {
            System.err.println(
                        "This operation cannot be tested on this platform.");
            return;
        }

        Assert.assertEquals(PosixFilePermissions.toString(
            Files.getPosixFilePermissions(Paths.get(files.get(1)),
            LinkOption.NOFOLLOW_LINKS)), "rw-r--r--");
    }
};
