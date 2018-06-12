package in.ankitpati.jfiler.tests;

import java.util.*;
import org.testng.annotations.*;
import in.ankitpati.jfiler.commands.*;

public class TestHelp {
    @Test(expectedExceptions = NullPointerException.class)
    public void testNullArgument() {
        new Help(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmptyArgument() {
        new Help(new ArrayList<String>());
    }
};
