public class Prog91 {

	public static void main(String[] args){
		InvisibleHero sh = new InvisibleHero(); //インスタンスの変数名は指定していないので、任意でOK
		sh.getInvisible(); //見えなくなる
		sh.getVisible(); //姿を現す
		sh.run(); //逃げる
	}

}

