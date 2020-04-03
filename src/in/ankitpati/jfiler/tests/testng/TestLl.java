package in.ankitpati.jfiler.tests.testng;

import org.testng.annotations.*;
import in.ankitpati.jfiler.commands.*;

public class TestLl {
    @Test(expectedExceptions = NullPointerException.class)
    public void testNullArgument() {
        new Ls(null);
    }
}
