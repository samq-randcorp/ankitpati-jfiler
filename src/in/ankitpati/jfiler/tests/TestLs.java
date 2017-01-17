package in.ankitpati.jfiler.tests;

import java.io.*;
import java.util.*;
import org.testng.*;
import org.testng.annotations.*;
import in.ankitpati.jfiler.commands.*;

public class TestLs {
    ArrayList<String> files = new ArrayList<String>();

    @Test(expectedExceptions = NullPointerException.class)
    public void testNullArgument() {
        new Ls(null);
    }
};
