import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * テストクラス InvisibleHeroTest.
 * @version (20220604)
 * 注意）InvisibleHero.isVisible、
 *      InvisibleHero.getInvisible()、
 *      InvisibleHero.getVisible()の３つが定義
 *      及びInvisibleHeroがHeroを継承するまではエラーとなる。
 *      
 *      print命令の末尾にある感嘆符は全角文字とする
 *      改行数を厳密に評価している
 * @version (2026Nov24)
 */
public class InvisibleHeroTest
{

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("1. 初期状態・継承の確認")
    public void testInitialState() {
        InvisibleHero hero = new InvisibleHero();

        assertTrue(hero instanceof Hero, 
            "InvisibleHero は Hero クラスを継承してください。");
        assertTrue(hero.isVisible, 
            "初期状態では isVisible を true に設定してください。");
        assertNotNull(hero.studentID, 
            "studentID フィールドを作成してください。");
        assertFalse("0000000".equals(hero.studentID), 
            "studentID を自身の学籍番号（7桁の半角数字）に変更してください。");
    }

    @Test
    @DisplayName("2. getInvisible() の動作確認（姿を消す・メッセージ表示）")
    public void testGetInvisible() {
        InvisibleHero hero = new InvisibleHero();

        outContent.reset();
        hero.getInvisible();

        assertFalse(hero.isVisible, 
            "getInvisible() 実行後は isVisible を false に変更してください。");

        int expectedLevel;
        try {
            // 末尾2桁を取得して計算
            int lastTwo = Integer.parseInt(hero.studentID.substring(hero.studentID.length() - 2));
            expectedLevel = (lastTwo % 5) + 1;
        } catch (Exception e) {
            fail("studentID の形式が正しくありません（例: 4724301 のように7桁の半角数字で入力してください）。");
            return;
        }

        String expectedMessage = "勇者工太は姿を消した！（ステルスレベル:" + expectedLevel + "）";
        String actualOutput = outContent.toString().trim();

        assertEquals(expectedMessage, actualOutput,
            "\n======================================================\n" +
            "❌ 出力メッセージが期待される形式と一致しません。\n" +
            "【期待する出力】 " + expectedMessage + "\n" +
            "【実際の出力】   " + actualOutput + "\n" +
            "------------------------------------------------------\n" +
            "💡【よくある原因とチェックポイント】\n" +
            " 一見同じに見える場合は、以下の『全角・半角の差』を確認してください：\n" +
            " 1. 末尾の閉じカッコは『全角の ）』ですか？（半角の ) になっていませんか？）\n" +
            " 2. ステルスレベル直前のコロンは『半角の : 』ですか？（全角の ： になっていませんか？）\n" +
            " 3. 感嘆符は『全角の ！』ですか？（半角の ! になっていませんか？）\n" +
            "======================================================\n");
    }

    @Test
    @DisplayName("3. getVisible() の動作確認（姿を現す・メッセージ表示）")
    public void testGetVisible() {
        InvisibleHero hero = new InvisibleHero();
        hero.getInvisible(); // 一度姿を消す
        outContent.reset();

        hero.getVisible();

        assertTrue(hero.isVisible, 
            "getVisible() 実行後は isVisible を true に戻してください。");

        String expectedMessage = "勇者工太は姿を現した！";
        String actualOutput = outContent.toString().trim();

        assertEquals(expectedMessage, actualOutput,
            "\n======================================================\n" +
            "❌ 出力メッセージが期待される形式と一致しません。\n" +
            "【期待する出力】 " + expectedMessage + "\n" +
            "【実際の出力】   " + actualOutput + "\n" +
            "======================================================");
    }
}
