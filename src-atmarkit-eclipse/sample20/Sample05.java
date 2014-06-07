package sample20;

import java.util.ArrayList;
import java.util.Iterator;

public class Sample05 {
	static class SampleIterator implements Iterator<String>{
		private Iterator<String> it;
		public SampleIterator(){
			ArrayList<String> list = new ArrayList<String>();
			list.add("第１回");
			list.add("第２回");
			list.add("第３回");
			list.add("第４回");
			list.add("第５回");
			it=list.iterator();
		}
		public boolean hasNext(){
			return it.hasNext();
		}
		public String next(){
			return it.next();
		}
		public void remove(){
			/* なにもしない */
		}
	}
	
	static class SampleIterable implements Iterable<String>{
		public Iterator<String> iterator(){
			return new SampleIterator();
		}
	}
	
	public static void main(String[] args){
		SampleIterable iterable = new SampleIterable();
		for(String e:iterable){
			System.out.println(e);
		}
	}
}
