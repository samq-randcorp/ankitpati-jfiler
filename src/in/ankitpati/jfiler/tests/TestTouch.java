package in.ankitpati.jfiler.tests;

import java.io.*;
import java.util.*;
import org.testng.*;
import org.testng.annotations.*;
import in.ankitpati.jfiler.commands.*;

public class TestTouch {
    ArrayList<String> files = new ArrayList<String>();

    @BeforeClass
    public void setup() throws IOException {
        files.add("test");
        new Mkdir(files).run();
        files.clear();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testNullArgument() {
        new Touch(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmptyArgument() {
        new Touch(files);
    }

    @Test
    public void testValidArgument() throws IOException {
        files.add("test/touch0.txt");
        new Touch(files).run();
        Assert.assertEquals(new File(files.get(0)).exists(), true);
    }

    @Test
    public void testMultipleValidArguments() throws IOException {
        files.clear();
        files.add("test/touch1.txt");
        files.add("test/touch2.txt");
        new Touch(files).run();
        for (String file : files)
            Assert.assertEquals(new File(file).exists(), true);
    }

    @Test
    public void testNonExistentDirectoryArgument() throws IOException {
        files.clear();
        files.add("test/touch/a.txt");
        new Touch(files).run();
        Assert.assertEquals(new File(files.get(0)).exists(), true);
    }

    @AfterClass
    public void teardown() throws IOException {
        files.clear();
        files.add("test/");
        new Rm(files).run();
    }
};
