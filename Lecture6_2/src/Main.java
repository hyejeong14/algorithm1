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
	
	//입력 문자열이 올바른 괄호쌍을 가졌으면 true 반환
	//그렇지않으면 false 반환
	public static boolean isValid(String str) {
		//stack 사용하여 코드 짜기
		//개수만으로 코드를 짜면 )(이 올바른 괄호쌍으로 인식될 수 있음
		char[] stack = new char[1024];//1024개의 공간을 가지고있는 배열 생성
		int top=-1;//실제로는 존재하지 않는 공간을 top가 가르키고 있음
		//파이썬의 경우 stack[-1]은 1023번을 가르키지만 자바는 예외처리르 해야함	
		
		//for문을 돌면서 str문자열의 글자를 하나씩 읽기
		for(int i=0;i<str.length();i++) {
			//i 인덱스에 해당하는 문자를 읽기
			char ch = str.charAt(i);
			//괄호 열기 문자라면 스택에 해당 문자를 푸시한다
			if(ch=='('||ch=='{'||ch=='[') {
				stack[++top]=ch;//top++; stack[top]=ch 랑 같음
				//stack[top++]=ch; --> stack[top] =ch; top++;임
				
			}
			//괄호 닫기 문자라면 스택에서 가장 위의 문자와 비교, 올바르면 문자하나를 팝
			else if(ch==')') {
				
				//괄호열기 수 < 괄호 닫기수 이므로 올바르지 않은 괄호쌍
				//스택에 최상위 문자가 현재 검사하는 문자와 다른 종류하면 올바르지 않음
				if(top==-1||stack[top]!='(') {
					return false;
				}
				top--;
				
			}
		
		}
		//3.스택이 비어있다면(top==-1)true
		//아니면 false (닫기 수가 부족한 경우)
		//if(top==-1)return true;
		//else return false;와 아래 return top==-1;은 뜻이 같음
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
		//문자열이 올바르면 YES 그렇지 않으면 NO를 출력
		if(isValid(abc)) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		System.out.println(" 문자열의 길이 : "+abc.length());
        for(int i=0;i<abc.length();i++) {
        	System.out.println(""+(i+1)+"번째 글자는"+abc.charAt(i));
        }
	}

}
