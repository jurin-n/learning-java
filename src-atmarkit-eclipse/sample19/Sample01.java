package sample19;

public class Sample01 {
	static class Queue{
		final int SIZE = 5;
		private int[] values = new int[SIZE+1];
		private int head=0;
		private int tail=0;
	
		boolean enqueue(int data){
			if(data < 0) return false;

			if((tail+1) % values.length == head) return false;
		
			values[tail++] = data;
			tail = tail % values.length;
			return true;
		}
	
		int dequeue(){
			int data = -1;
			if(tail != head){
				data = values[head++];
				head = head % values.length;
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
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		System.out.println(q.dequeue());
		q.enqueue(7);
		while(!q.isEmpty()){
			System.out.print(q.dequeue() + ",");
		}
		System.out.println("");
	}
}
