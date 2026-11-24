# 課題 9-1: 継承

### 課題の説明
`Hero` クラスを継承する`InvisibleHero` クラスを作成しなさい。`InvisibleHero` は姿を消す・表す能力に加え、自身の学籍番号に応じた効果数値（ステルスレベル）を動的に計算する機能を持つ。

以下のフィールドとメンバを追加・実装しなさい。

- InvisibleHeroクラスに追加するフィールド

| 変数名 | 型 | 初期値 | 説明 |
|-----|-----|-----|-----|
| `isVisible` | `boolean` | `true` | 姿が見えているかの状態 |
| `studentID` | `String` | `"0000000"` | **各自の学籍番号（半角数字7桁）**に変更すること |

- InvisibleHeroクラスに追加するメソッドと計算ルール

| メソッド名          | 引数のリスト | 戻り値 | 処理内容                           |
|--------------|--------|-----|--------------------------------|
| `getInvisible` | なし     | なし | `isVisible`を`false`に変更し、後述の計算ルールに従ってメッセージを出力する |
| `getVisible`   | なし     | なし | `isVisible`を`true`に変更し、「`勇者`」+ `this.name`「`は姿を現した！`」と表示する |

【計算ルール（getInvisible メソッド内で実装すること）】<br>
１．`studentID` の**末尾2桁の数字**を抽出して数値に変換する。<br>
２．抽出した数値を使って、効果値を `(末尾2桁 % 5) + 1` の式で計算する。<br>
３．以下の形式でメッセージを出力する：<br>
`勇者` + `this.name` + `は姿を消した！（ステルスレベル: `+ `計算結果` +` ）`

**ヒント：文字列から数字を取り出して計算する方法**<br>
学籍番号（`studentID`）から末尾2桁の数字を取り出して計算を行うには、以下のコードを参考にしてください。
```
// 例：studentID が "4724301" の場合

// 1. substring(5) を使ってインデックス5以降（6・7文字目）を切り出す
String lastTwo = this.studentID.substring(5); // "01" という文字列になる

// 2. Integer.parseInt を使って文字列を int 型の数値に変換する
int number = Integer.parseInt(lastTwo); // 1 という数値になる

// 3. 5で割った余り（% 5）に 1 を足してレベルを計算する
int stealthLevel = (number % 5) + 1; // 1 % 5 + 1 => 2 となる
```

### Prog91クラス と Heroクラス (これらのコードは提出不要)
動作確認や親クラスの参照用として以下のコードを使用しなさい。

**Prog91.java**
```java
public class Prog91
{
    public static void main(String[] args){
        InvisibleHero sh = new InvisibleHero();
        sh.getInvisible(); //見えなくなる
        sh.getVisible(); //姿を現す
        sh.run(); //逃げる
    }

}
```
**Hero.java**
```java
public class Hero
{
    String name = "工太";
    int hp=100;

    public void run() //逃げる
    {
        System.out.println(this.name + "は、逃げ出した！");
        System.out.println("最終HPは" + this.hp + "でした");
    }
}
```


### 実行例
 パターンA：学籍番号が 4724301 の場合（末尾01 → レベル2）
```
勇者工太は姿を消した！（ステルスレベル:2）
勇者工太は姿を現した！
工太は、逃げ出した！
最終HPは100でした
```
パターンB：学籍番号が `4724323` の場合（末尾23 → レベル4）
```
勇者工太は姿を消した！（ステルスレベル:4）
勇者工太は姿を現した！
工太は、逃げ出した！
最終HPは100でした
```
###注意事項
学籍番号の入力ルール: studentId には 4724301 のように7桁の数字を半角で正しく入力してください（数字2桁だけを入力するとエラーになります）。
