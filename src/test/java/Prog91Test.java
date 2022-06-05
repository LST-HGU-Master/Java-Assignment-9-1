import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import java.io.*;
/**
 * @version (20220604)
 **/
public class Prog91Test {

    @Test
    public void testHelloWorld()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        StandardInputStream in = new StandardInputStream();
        System.setIn(in);
        
        // action
        // in.inputln("2"); // 標準入力をテストする場合
        // Hello.main(new String[]{"1", "2", "3"}); // 実行時引数をテストする場合
        Prog91.main(null);
        
        System.setOut(originalOut);        

        // assertion
        String[] prints = bos.toString().split("\r\n|\n", -1);
        try {
            assertEquals("勇者工太は姿を消した！", prints[0]);
            assertEquals("勇者工太は姿を現した！", prints[1]);
            assertEquals("工太は、逃げ出した！", prints[2]);
            assertEquals("最終HPは100でした", prints[3]);
        } catch (ArrayIndexOutOfBoundsException excpt) {
            fail("Prog91.main()のprint出力が4行ではありません!");
        }
        assertEquals(5,prints.length,"改行数が５つ以上あります!"); // このif文に到達した時点で prints.lengthは５以上になっている
    }
}
