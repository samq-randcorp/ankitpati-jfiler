package in.ankitpati.jfiler.tests;

import java.io.*;
import java.util.*;
import org.testng.*;
import org.testng.annotations.*;
import in.ankitpati.jfiler.commands.*;

public class TestRm {
    ArrayList<String> files = new ArrayList<String>();

    @Test(expectedExceptions = NullPointerException.class)
    public void testNullArgument() {
        new Rm(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmptyArgument() {
        new Rm(files);
    }

    @Test
    public void testValidArgument() throws IOException {
        files.add("test/touch0.txt");
        new Rm(files).run();
        Assert.assertEquals(new File(files.get(0)).exists(), false);
    }

    @Test
    public void testMultipleValidArguments() throws IOException {
        files.clear();
        files.add("test/touch1.txt");
        files.add("test/touch2.txt");
        new Rm(files).run();
        for (String file : files)
            Assert.assertEquals(new File(file).exists(), false);
    }

    @Test
    public void testDirectoryArgument() throws IOException {
        files.clear();
        files.add("test/touch/");
        new Rm(files).run();
        Assert.assertEquals(new File(files.get(0)).exists(), false);
    }
};
