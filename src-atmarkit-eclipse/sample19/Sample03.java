package sample19;

import java.util.ArrayList;

public class Sample03 {
	static class Queue<T>{
		final int SIZE = 5;
		private ArrayList<T> values = new ArrayList<T>();
		private int head=0;
		private int tail=0;
	
		Queue(){
			for(int i=0; i<SIZE+1; i++){
				values.add(null);
			}		
		}
		
		boolean enqueue(T data){
			if(data == null) return false;

			if((tail+1) % values.size() == head) return false;
		
			values.set(tail++,data);
			tail = tail % values.size();
			return true;
		}

		T dequeue(){
			T data = null;
			if(tail != head){			
				data = values.get(head++);
				head = head % values.size();
			}
			return data;
		}
	
		boolean isEmpty(){
			return (tail == head);
		}
	}
	/*
	 * 0,1,2,3,4,5
	 *             head=0 tail=0
	 * 1           head=0 tail=1
	 * 1 2         head=0 tail=2
	 *   2         head=1 tail=2
	 *   2 3       head=1 tail=3
	 *   2 3 4     head=1 tail=4
	 *   2 3 4 5   head=1 tail=5
	 *   2 3 4 5 6 head=1 tail=0
	 *   2 3 4 5 6 head=1 tail=1
	 *     3 4 5 6 head=3 tail=1
     * 1   3 4 5 6 head=3 tail=2
	 * */
	public static void main(String[] args){
		Queue<Long> q = new Queue<Long>();
		q.enqueue(1L);
		q.enqueue(2L);
		q.enqueue(3L);
		q.enqueue(4L);
		q.enqueue(5L);
		q.enqueue(6L);
		System.out.println(q.dequeue());
		q.enqueue(7L);
		while(!q.isEmpty()){
			Long data = q.dequeue();
			System.out.print(data + ",");
		}
		System.out.println("");
	}
}
