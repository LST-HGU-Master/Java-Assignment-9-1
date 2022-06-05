import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import java.io.*;
/**
 * @version (20220604)
 * 注意）InvisibleHero.isVisible、
 *      InvisibleHero.getInvisible()、
 *      InvisibleHero.getVisible()の３つが定義
 *      及びInvisibleHeroがHeroを継承するまではエラーとなる。
 *      
 *      print命令の末尾にある感嘆符は全角文字とする
 *      改行数を厳密に評価している
 **/
public class InvisibleHeroTest {

    @Test
    public void testExtendHero()
    {
        // action
        InvisibleHero h = new InvisibleHero();

        // assertion
        assertTrue(h instanceof Hero,"InvisibleHeroはHeroを継承していません!");
    }

    @Test
    public void testGetInvisible()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        InvisibleHero h = new InvisibleHero();
        try {
            // assertion
            assertTrue(h.isVisible,"InvisibleHeroインスタンスのisVisibleの初期値ががfalseです!");
        } catch (AssertionError err) {
            System.setOut(originalOut);
            throw err;
        }
        // action
        h.getInvisible();
        // undo the binding in System
        System.setOut(originalOut);
            
        String[] prints = bos.toString().split("\r\n|\n", -1); // 値が空の部分も切り出す
        // assertion
        assertFalse(h.isVisible,"getInvisible()を呼び出してもisVisibleがfalseになりません!");
        assertEquals("勇者工太は姿を消した！", prints[0].toString(),"getInvisible()を呼び出した場合のprint出力が実行例と異なります!");
        assertEquals(2,prints.length,"改行が２つ以上あります!");
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
        // undo the binding in System
        System.setOut(originalOut);
        
        String[] prints = bos.toString().split("\r\n|\n", -1); // 値が空の部分も切り出す

        // assertion
        assertTrue(h.isVisible,"getVisible()を呼び出してもisVisibleがtrueになりません!");
        assertEquals("勇者工太は姿を現した！", prints[0].toString(),"getVisible()を呼び出した場合のprint出力が実行例と異なります!");
        assertEquals(2,prints.length,"改行が２つ以上あります!");
    }
}
