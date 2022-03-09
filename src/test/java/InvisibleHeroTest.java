import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import java.io.*;

public class InvisibleHeroTest {

    @Test
    public void testExtendHero()
    {
        // action
        InvisibleHero h = new InvisibleHero();

        // assertion
        assertTrue(h instanceof Hero);
    }

    @Test
    public void testGetInvisible()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        InvisibleHero h = new InvisibleHero();
        // assertion
        assertTrue(h.isVisible);

        // action
        h.getInvisible();
        // assertion
        assertFalse(h.isVisible);
        assertEquals("勇者工太は姿を消した!\n", bos.toString());

        // undo the binding in System
        System.setOut(originalOut);
    }

    @Test
    public void testGetVisible()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        InvisibleHero h = new InvisibleHero();
        h.isVisible = false;
        h.getVisible();

        // assertion
        assertTrue(h.isVisible);
        assertEquals("勇者工太は姿を現した!\n", bos.toString());

        // undo the binding in System
        System.setOut(originalOut);
    }
}
