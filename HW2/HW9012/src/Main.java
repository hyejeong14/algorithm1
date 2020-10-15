import java.util.*;
public class Main {
	public static boolean VPS(String ps) {
		char[] stack = new char[1024];
		int top = -1;
		for(int i = 0; i < ps.length(); i++ ) {
			char ch = ps.charAt(i);
			if(ch == '(' ) {
				stack[++top] = ch;
			}
			else if(ch == ')') {
				if(top == -1 || stack[top] != '(') return false;
				top--;
			}
			
		}
		
		return top == -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			String PS = sc.next();
			if(VPS(PS)) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
