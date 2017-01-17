package in.ankitpati.jfiler.tests;

import java.io.*;
import java.util.*;
import org.testng.*;
import org.testng.annotations.*;
import in.ankitpati.jfiler.commands.*;

public class TestMv {
    ArrayList<String> files = new ArrayList<String>();

    @Test(expectedExceptions = NullPointerException.class)
    public void testNullArgument() {
        new Mv(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmptyArgument() {
        new Mv(files);
    }

    @Test
    public void testValidArguments() throws IOException {
        files.add("test/cp.dat");
        files.add("test/mv.dat");
        new Mv(files).run();
        Assert.assertEquals(new File(files.get(1)).exists(), true);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testMultipleArguments() throws IOException {
        files.add("test/mv1.txt");
        files.add("test/mv2.txt");
        new Mv(files);
    }

    @Test
    public void testDirectoryArguments() throws IOException {
        files.clear();
        files.add("test/out/in/");
        files.add("test/");
        new Mv(files).run();
        Assert.assertEquals(new File("test/in").isDirectory(), true);
    }
};
