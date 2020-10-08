import java.util.*;
public class Main {
	
	/*int count = 0;
	for(int i = 0; i < str.length();i++) {
		ch = str.charAt(i);
		if(ch == '(') count++;
		else if(ch == ')') {	
			count--;
		if(count < 0) return false;
}
}
		return count==0;*/
	
	//�Է� ���ڿ��� �ùٸ� ��ȣ���� �������� true ��ȯ
	//�׷��������� false ��ȯ
	public static boolean isValid(String str) {
		//stack ����Ͽ� �ڵ� ¥��
		//���������� �ڵ带 ¥�� )(�� �ùٸ� ��ȣ������ �νĵ� �� ����
		char[] stack = new char[1024];//1024���� ������ �������ִ� �迭 ����
		int top=-1;//�����δ� �������� �ʴ� ������ top�� ����Ű�� ����
		//���̽��� ��� stack[-1]�� 1023���� ����Ű���� �ڹٴ� ����ó���� �ؾ���	
		
		//for���� ���鼭 str���ڿ��� ���ڸ� �ϳ��� �б�
		for(int i=0;i<str.length();i++) {
			//i �ε����� �ش��ϴ� ���ڸ� �б�
			char ch = str.charAt(i);
			//��ȣ ���� ���ڶ�� ���ÿ� �ش� ���ڸ� Ǫ���Ѵ�
			if(ch=='('||ch=='{'||ch=='[') {
				stack[++top]=ch;//top++; stack[top]=ch �� ����
				//stack[top++]=ch; --> stack[top] =ch; top++;��
				
			}
			//��ȣ �ݱ� ���ڶ�� ���ÿ��� ���� ���� ���ڿ� ��, �ùٸ��� �����ϳ��� ��
			else if(ch==')') {
				
				//��ȣ���� �� < ��ȣ �ݱ�� �̹Ƿ� �ùٸ��� ���� ��ȣ��
				//���ÿ� �ֻ��� ���ڰ� ���� �˻��ϴ� ���ڿ� �ٸ� �����ϸ� �ùٸ��� ����
				if(top==-1||stack[top]!='(') {
					return false;
				}
				top--;
				
			}
		
		}
		//3.������ ����ִٸ�(top==-1)true
		//�ƴϸ� false (�ݱ� ���� ������ ���)
		//if(top==-1)return true;
		//else return false;�� �Ʒ� return top==-1;�� ���� ����
		return top==-1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String abc = sc.next();
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			String abc2=sc.next();
			if(isValid(abc)) System.out.println("YES");
			else System.out.println("NO");
		}
		//���ڿ��� �ùٸ��� YES �׷��� ������ NO�� ���
		if(isValid(abc)) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		System.out.println(" ���ڿ��� ���� : "+abc.length());
        for(int i=0;i<abc.length();i++) {
        	System.out.println(""+(i+1)+"��° ���ڴ�"+abc.charAt(i));
        }
	}

}
