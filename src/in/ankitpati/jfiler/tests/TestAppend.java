package in.ankitpati.jfiler.tests;

import java.io.*;
import java.util.*;
import org.testng.*;
import org.testng.annotations.*;
import in.ankitpati.jfiler.commands.*;

public class TestAppend {
    @Test(expectedExceptions = NullPointerException.class)
    public void testNullArgument() {
        new Append(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmptyArgument() {
        new Append(new ArrayList<String>());
    }
};
