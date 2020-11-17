import java.util.*;

class Queue<E> { //큐생성
	int front; 
	int rear; 
	E[] data;
	int size;
	Queue(int get_size) {
		front = rear =0;
		size = get_size+1;
		data = (E[]) new Object[size];
	}
	public void add(E v) {
		data[rear] = v;
		rear = (rear+1)%size;
		
	}
	public void remove() {
		data[front] = null;
		front = (front+1)%size;
	}
	public E peek() {
		return data[front];
	}
	public boolean empty() {
		return front == rear;
	}
	public int size() {
		return (rear-front+size)%size;

	}

}

class Stack<E> { //스택 생성
	E[] data;  
	int top; 
	Stack() {
		data = (E[]) new Object[1024];
		top = -1;
	}
	public void push(E v) {
		data[++top] = v;
	}
	public void pop() {
		data[top--]=null;
     }
	public E top() {
		return data[top];
	}
	public boolean empty() {
		return top == -1;
	}
	public int size() {
		return top+1;
	}
}

public class Main {
	public static int bound = 10000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("큐의 사이즈를 입력하세요 : ");
		int get_size = sc.nextInt();
		
		Queue<Integer> queue = new Queue(get_size);
		Stack<Integer> stack = new Stack();
		
		for(int i = 0; i<get_size;i++) {
			queue.add(rand.nextInt(bound));
		}
		
		while(queue.empty()==false) {
			if((stack.top != -1 && queue.peek()<=stack.top() ) || stack.top==-1 ) {
				stack.push(queue.peek());
				queue.remove();}
			else if(queue.peek() > stack.top()) {
					queue.add(stack.top());
					stack.pop();	
		}}
		
		System.out.println("-------정렬 된 스택 출력-------");
		for(int i=0;i<get_size;i++) {
			System.out.println(stack.top());
			stack.top -= 1;
	}
	}
}