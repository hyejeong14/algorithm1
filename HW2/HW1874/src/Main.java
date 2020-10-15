import java.util.*;
public class Main{
/* 1.수열의 크기 정하기
 * 2.정한 크기만큼 수열 만들기
 * 3.수열의 0번째 인덱스의 숫자와 같을때까지 스택에 1부터 push
 * 4.만약 0번째 인덱스와 숫자가 같아지면 멈추고 해당 숫자를 pop , poppushlist에 +를 푸쉬
 * 5.스택의 맨 위의 숫자가 수열의 1번째 인덱스와 같으면 해당 숫자를 pop, poppushlist에 -를 푸쉬
 * 6.만약 스택의 맨 위의 숫자가 수열의 1번째 인덱스와 다르면 1번째 인덱스와 같은 숫자가 나올때까지 스택에 push
 * 7.만약 스택의 맨 위의 숫자가 수열의 다음 인덱스보다 크면 NO
 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int num = sc.nextInt(); // 수열의 크기 정하기
        int[] arr= new int[num+1]; // 만들고 싶은 수열
 
        int stack[] = new int[1024];
        int top = -1;//스택 만들기
        
        char PopPush[] = new char [1024]; // +,-로 나타낼 리스트
        
        for(int i=0; i<num;i++) {
            arr[i] = sc.nextInt();
        } //수열 입력받기
        int order=0; //수열의 인덱스를 나타낼 수
        int pporder=0;//PopPush 인덱스
        for (int i=1;i<=num;i++) {
        	stack[++top]=i;  //top 증가시킨후 stack[top]에 1부터 오름차순으로 push
        	PopPush[pporder]='+'; //push할때마다 poppush에 + push
        	pporder++; 
        	//System.out.println(PopPush);
        	while(!(top==-1)&&stack[top]==arr[order]) { 
        		PopPush[pporder]='-';
        		pporder++;
        		order++;
        		top--;
        	}
        }
        if(top==-1) {
        	System.out.println(PopPush);
        	
        		} else {
        			System.out.println("NO");
        		}

     
}
}