import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Prog91.main() の動作テストコード
 *  @version (20220604)
 *  @version (2026Nov24)
 */
public class Prog91Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testMain() {
        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        Prog91.main(null);

        String[] prints = outContent.toString().split("\r\n|\n", -1);

        // 1. 行数チェック（最低 4 行の出力が必要）
        if (prints.length < 4) {
            fail("Prog91.main() の print 出力が 4 行ではありません！（実際の出力行数: " + (prints.length - 1) + "行）");
        }

        // 2. InvisibleHero の studentID から期待される1行目のレベルを動的算出
        int expectedLevel;
        try {
            InvisibleHero dummyHero = new InvisibleHero();
            String studentID = dummyHero.studentID;
            int lastTwo = Integer.parseInt(studentID.substring(studentID.length() - 2));
            expectedLevel = (lastTwo % 5) + 1;
        } catch (Exception e) {
            fail("InvisibleHero.studentID の形式が不正です（例: 4724301 のように7桁の半角数字で設定してください）。");
            return;
        }

        String expectedLine1 = "勇者工太は姿を消した！（ステルスレベル:" + expectedLevel + "）";

        // 3. 各行のアサーション
        assertEquals(expectedLine1, prints[0], 
            "\n======================================================\n" +
            "❌ 1行目の出力が期待される形式と一致しません。\n" +
            "【期待する出力】 " + expectedLine1 + "\n" +
            "【実際の出力】 " + (prints.length > 0 ? prints[0] : "") + "\n" +
            "------------------------------------------------------\n" +
            "💡【チェックポイント】\n" +
            " 1. 末尾の閉じカッコは『全角の ）』ですか？\n" +
            " 2. ステルスレベル直前のコロンは『半角の : 』ですか？\n" +
            " 3. 感嘆符は『全角の ！』ですか？\n" +
            "======================================================\n");

        assertEquals("勇者工太は姿を現した！", prints[1], "2行目の出力（姿を現す）が実行例と異なります。");
        assertEquals("工太は、逃げ出した！", prints[2], "3行目の出力（逃げる）が実行例と異なります。");
        assertEquals("最終HPは100でした", prints[3], "4行目の出力（最終HP）が実行例と異なります。");

        // 4. 改行数の厳密評価（末尾改行含め 5 要素）
        assertEquals(5, prints.length, "改行数が正しくありません（余分な print があるか、末尾改行が不足しています）。");
    }
}
