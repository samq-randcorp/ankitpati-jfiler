package in.ankitpati.jfiler.tests;

import java.io.*;
import java.util.*;
import org.testng.*;
import org.testng.annotations.*;
import in.ankitpati.jfiler.commands.*;

public class TestCat {
    @Test(expectedExceptions = NullPointerException.class)
    public void testNullArgument() {
        new Cat(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmptyArgument() {
        new Cat(new ArrayList<String>());
    }
};
