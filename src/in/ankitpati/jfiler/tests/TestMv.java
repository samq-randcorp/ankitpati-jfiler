package in.ankitpati.jfiler.tests;

import java.io.*;
import java.util.*;
import org.testng.*;
import org.testng.annotations.*;
import in.ankitpati.jfiler.commands.*;

public class TestMv {
    ArrayList<String> files;

    @BeforeClass
    public void setup() throws IOException {
        files = new ArrayList<>();
        files.add("test/mv0.txt");
        files.add("test/mv1.txt");
        new Touch(files).run();

        files = new ArrayList<>();
        files.add("out/");
        files.add("test/");
        new Cp(files).run();
    }

    @BeforeMethod
    public void initialiseFiles() {
        files = new ArrayList<>();
    }

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
        files.add("test/mv0.txt");
        files.add("test/mv1.txt");
        new Mv(files).run();
        Assert.assertEquals(new File(files.get(1)).exists(), true);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testMultipleArguments() throws IOException {
        files.add("test/mv0.txt");
        files.add("test/mv1.txt");
        files.add("test/mv2.txt");
        files.add("test/mv3.txt");
        new Mv(files);
    }

    @Test
    public void testDirectoryArguments() throws IOException {
        files.add("test/out/in/");
        files.add("test/");
        new Mv(files).run();
        Assert.assertEquals(new File("test/in").isDirectory(), true);
    }

    @AfterMethod
    public void destroyFiles() {
        files = null;
    }

    @AfterClass
    public void teardown() throws IOException {
        files = new ArrayList<>();
        files.add("test/");
        new Rm(files).run();
    }
}
