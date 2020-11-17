import java.util.Scanner;

class Queue<E> { //큐생성
	int front; 
	int rear; 
	E[] data;
	int data_size;
	Queue(int get_size) {
		front = rear =0;
		data_size = get_size;
		data = (E[]) new Object[data_size+1];
	}
	public void add(E v) {
		data[rear] = v;
		rear = (rear+1)%data_size;
		
	}
	public void remove() {
		data[front] = null;
		front = (front+1)%data_size;
	}
	public E peek() {
		return data[front];
	}
	public boolean empty() {
		return front == rear;
	}
	public int size() {
		return (rear-front+data_size)%data_size;

	}
	public E back() {
		return data[rear-1];
	}

}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("명령의 수 n을 입력하세요(1 <= n <= 10,000) : ");
		int num_order = sc.nextInt();
		
		Queue<String> queue = new Queue(num_order);
		
		for(int i=0;i<num_order;i++) {
			String order = sc.next();
			if(order.equals("push")) {
				String push_num = sc.next();
				queue.add(push_num);
			}
			else if(order.equals("pop")) {
				if(queue.size()==0) System.out.println(-1);
				else {
					System.out.println(queue.peek());
					queue.remove();
				}
			}
			else if(order.equals("size")) System.out.println(queue.size());
			else if(order.equals("empty")) {
				if(queue.empty()==true) System.out.println(1);
				else System.out.println(0);
			}
			else if(order.equals("front")) {
				if(queue.size()==0) {
					System.out.println(-1);
				}
				else System.out.println(queue.peek());
			}
			else if(order.equals("back")) {
				if(queue.size()==0) {
					System.out.println(-1);
				}
				else System.out.println(queue.back());
			}
				
			}
		}
}