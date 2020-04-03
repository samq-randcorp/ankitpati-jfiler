package in.ankitpati.jfiler.tests;

import java.io.*;
import java.util.*;
import org.testng.*;
import org.testng.annotations.*;
import in.ankitpati.jfiler.commands.*;

public class TestCp {
    ArrayList<String> files;

    @BeforeClass
    public void setup() throws IOException {
        files = new ArrayList<>();
        files.add("test");
        new Mkdir(files).run();
    }

    @BeforeMethod
    public void initialiseFiles() {
        files = new ArrayList<>();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testNullArgument() {
        new Cp(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmptyArgument() {
        new Cp(files);
    }

    @Test
    public void testValidArguments() throws IOException {
        files.add("out/in/ankitpati/jfiler/Main.class");
        files.add("test/cp.dat");
        new Cp(files).run();
        Assert.assertEquals(new File(files.get(1)).exists(), true);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testMultipleArguments() throws IOException {
        files.add("test/cp0.txt");
        files.add("test/cp1.txt");
        files.add("test/cp2.txt");
        files.add("test/cp3.txt");
        new Cp(files);
    }

    @Test
    public void testDirectoryArguments() throws IOException {
        files.add("out/");
        files.add("test/");
        new Cp(files).run();
        Assert.assertEquals(new File("test/out/in").isDirectory(), true);
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
