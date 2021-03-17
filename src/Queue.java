import java.util.ArrayList;
import java.util.List;

public class Queue {
	private List<Object> elements;
	private int rear,front;
	
	public Queue() {
		elements=new ArrayList<Object>();
		rear=-1;
		front=0;
	}
	
	public boolean isEmpty() {
		return rear<front;
	}
	
	public boolean isFull() {
		return rear+1==elements.size();
	}
	
	public void enqueue(Object data) {
		if(isFull()) {
			System.out.println("Queue is full");
		}
		else {
			rear++;
			elements.add(rear, data);
		}
	}
	
	public Object dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		else {
			Object data=elements.get(front);
			elements.add(front, null);
			front++;
			return data;
		}
	}
	
	public Object peek() {
		return elements.get(front);
	}
	
	public int size() {
		return rear-front+1;
	}
}
