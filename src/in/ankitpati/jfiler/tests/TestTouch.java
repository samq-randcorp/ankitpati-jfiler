package in.ankitpati.jfiler.tests;

import java.io.*;
import java.util.*;
import org.testng.*;
import org.testng.annotations.*;
import in.ankitpati.jfiler.commands.*;

public class TestTouch {
    ArrayList<String> files;

    @Test(expectedExceptions = NullPointerException.class)
    public void testNullArgument() {
        new Touch(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmptyArgument() {
        files = new ArrayList<String>();
        new Touch(files);
    }

    @Test
    public void testValidArgument() throws IOException {
        files.add("out/test.txt");
        new Touch(files).run();
        Assert.assertEquals(new File(files.get(0)).exists(), true);
    }
};
