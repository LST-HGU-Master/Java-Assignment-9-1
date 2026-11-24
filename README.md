# 課題 9-1: 継承

### 課題の説明
`Hero` クラスを継承する`InvisibleHero` クラスを作成しなさい。`InvisibleHero` は姿を消すと姿を表す能力を持つ。

以下のフィールドとメンバを追加・実装しなさい。

- InvisibleHeroクラスに追加するフィールド

| 変数名 | 型 | 初期値 | 説明 |
|-----|-----|-----|-----|
| `isVisible` | `boolean` | `true` | 姿が見えているかの状態 |

- InvisibleHeroクラスに追加するメソッド

| メソッド名          | 引数のリスト | 戻り値 | 処理内容                           |
|--------------|--------|-----|--------------------------------|
| `getInvisible` | なし     | なし | `isVisible`を`false`に変更し、「`勇者`」+ `this.name`+「`は姿を消した！`」と表示する |
| `getVisible`   | なし     | なし | `isVisible`を`true`に変更し、「`勇者`」+ `this.name`+「`は姿を現した！`」と表示する |

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
```
勇者工太は姿を消した！
勇者工太は姿を現した！
工太は、逃げ出した！
最終HPは100でした
```
