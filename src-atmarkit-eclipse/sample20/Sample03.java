package sample20;

public class Sample03 {
	public static void main(String[] args){
		String[] setExpression ={"第１回","第２回","第３回","第４回","第５回"};
		System.out.println("＊基本for文の場合＊");
		for(int i = 0; i < setExpression.length; i++){
			String element = setExpression[i];
			System.out.println(element);
		}
		
		System.out.println("＊拡張for文の場合＊");
		for(String element : setExpression){
			System.out.println(element);
		}
	}
}
