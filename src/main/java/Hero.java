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