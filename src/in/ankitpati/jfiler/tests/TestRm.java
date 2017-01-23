package in.ankitpati.jfiler.tests;

import java.io.*;
import java.util.*;
import org.testng.*;
import org.testng.annotations.*;
import in.ankitpati.jfiler.commands.*;

public class TestRm {
    ArrayList<String> files = new ArrayList<String>();

    @BeforeClass
    public void setup() throws IOException {
        files.add("test/rm0.txt");
        files.add("test/rm1.txt");
        files.add("test/rm2.txt");
        files.add("test/rm/rm3.txt");
        new Touch(files).run();
        files.clear();
    }

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
        files.add("test/rm0.txt");
        new Rm(files).run();
        Assert.assertEquals(new File(files.get(0)).exists(), false);
    }

    @Test
    public void testMultipleValidArguments() throws IOException {
        files.clear();
        files.add("test/rm1.txt");
        files.add("test/rm2.txt");
        new Rm(files).run();
        for (String file : files)
            Assert.assertEquals(new File(file).exists(), false);
    }

    @Test
    public void testDirectoryArgument() throws IOException {
        files.clear();
        files.add("test/rm/");
        new Rm(files).run();
        Assert.assertEquals(new File(files.get(0)).exists(), false);
    }

    @AfterClass
    public void teardown() throws IOException {
        files.clear();
        files.add("test/");
        new Rm(files).run();
    }
};
