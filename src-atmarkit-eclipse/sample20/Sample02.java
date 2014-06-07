package sample20;

import java.util.ArrayList;

public class Sample02 {
	public static void main(String[] args){
		ArrayList<String> setExpression = new ArrayList<String>();
		
		setExpression.add("第１回");
		setExpression.add("第２回");
		setExpression.add("第３回");
		setExpression.add("第４回");
		setExpression.add("第５回");

		for(String e : setExpression){
			System.out.println(e);
		}
	}
}
