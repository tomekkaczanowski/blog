package pl.kaczanowscy.tomek;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

@Test
public class TestResults {

    public void passingTest() {
        assertTrue(true);
    }

    public void failingTest() {
        assertTrue(false);
    }

    @Test(dataProvider = "non-existing-data-provider")
    public void errorTest() {
        assertTrue(true);
    }

    @Test(dependsOnMethods = "errorTest")
    public void skippedTest() {
        assertTrue(true);
    }
}
