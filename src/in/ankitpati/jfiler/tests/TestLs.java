package in.ankitpati.jfiler.tests;

import org.testng.annotations.*;
import in.ankitpati.jfiler.commands.*;

public class TestLs {
    @Test(expectedExceptions = NullPointerException.class)
    public void testNullArgument() {
        new Ls(null);
    }
};
