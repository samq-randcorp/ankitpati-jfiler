package in.ankitpati.jfiler.tests;

import java.io.*;
import java.util.*;
import org.testng.*;
import org.testng.annotations.*;
import in.ankitpati.jfiler.commands.*;

public class TestMkdir {
    ArrayList<String> files;

    @BeforeClass
    public void setup() throws IOException {
        files = new ArrayList<String>();
        files.add("test");
        new Mkdir(files).run();
    }

    @BeforeMethod
    public void initialiseFiles() {
        files = new ArrayList<String>();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testNullArgument() {
        new Mkdir(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmptyArgument() {
        new Mkdir(files);
    }

    @Test
    public void testValidArgument() throws IOException {
        files.add("test/mkdir0");
        new Mkdir(files).run();
        Assert.assertEquals(new File(files.get(0)).isDirectory(), true);
    }

    @Test
    public void testMultipleValidArguments() throws IOException {
        files.add("test/mkdir1");
        files.add("test/mkdir2");
        new Mkdir(files).run();
        for (String file : files)
            Assert.assertEquals(new File(file).isDirectory(), true);
    }

    @Test
    public void testNonExistentDirectoryArgument() throws IOException {
        files.add("test/mkdir/a");
        new Mkdir(files).run();
        Assert.assertEquals(new File(files.get(0)).isDirectory(), true);
    }

    @AfterMethod
    public void destroyFiles() {
        files = null;
    }

    @AfterClass
    public void teardown() throws IOException {
        files = new ArrayList<String>();
        files.add("test/");
        new Rm(files).run();
    }
};
