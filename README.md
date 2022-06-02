# 課題 9-1: 継承

### 課題の説明
Heroクラスを継承するInvisibleHeroクラスを作成しなさい。なお、InvisibleHeroは姿を消す、姿を表す能力を持つので、これを表現するために
以下のフィールドとメンバを追加しなさい。

- InvisibleHeroクラスに追加するフィールド

| 変数名 | 型 | 初期値 |
|-----|-----|-----|
| isVisible | boolean | True |

- InvisibleHeroクラスに追加するメソッド

| 変数名          | 引数のリスト | 戻り値 | 処理内容                           |
|--------------|--------|-----|--------------------------------|
| getInvisible | なし     | なし | isVisibleをFalseにし、「姿を消した！」と表示する |
| getVisible   | なし     | なし | isVisibleをTrueにし、「姿を現した！」と表示する |

### Prog91クラス と Heroクラス (これらのコードは提出不要)
```java
public class Prog91 {

	public static void main(String[] args){
		InvisibleHero sh = new InvisibleHero(); //インスタンスの変数名は指定していないので、任意でOK
		sh.getInvisible(); //見えなくなる
		sh.getVisible(); //姿を現す
		sh.run(); //逃げる
	}

}
```
```java
public class Hero
{
    String name = "工太";
    int hp=100;

    public void run() //逃げる
    {
        System.out.println(this.name + "は、逃げ出した!");
        System.out.println("最終HPは" + this.hp + "でした");
    }
}
```


### 実行例
```
勇者工太は姿を消した!
勇者工太は姿を現した!
工太は、逃げ出した!
最終HPは100でした
```
