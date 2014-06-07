package testDouble;

import java.util.Date;

public class DelegateObjectExample {
	Date date = new Date();
	DateFactory dateFactory = new DateFactory();

	public void doSomething(){
		this.date= dateFactory.newDate();
		int j=0;
		System.out.println("無駄な処理始まり");
		for(int i=0;i<100000;i++){
			//時間かけるための無駄な処理
			j=j+1;
			System.out.println("あああ");
		}
		System.out.println("無駄な処理終わり");
	}
}
