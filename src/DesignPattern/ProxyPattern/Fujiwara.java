package DesignPattern.ProxyPattern;

public class Fujiwara implements Teacher {

	private Teacher yamada = new Yamada();
	
	@Override
	public void question1() {
		System.out.println("～～解答1～～");
	}

	@Override
	public void question2() {
		System.out.println("～～解答1～～");
	}

	@Override
	public void question3() {
		System.out.println("答えは「");
		yamada.question3();
		System.out.println("」となります。");
	}

}
