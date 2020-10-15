import java.util.*;
public class Main{
/* 1.������ ũ�� ���ϱ�
 * 2.���� ũ�⸸ŭ ���� �����
 * 3.������ 0��° �ε����� ���ڿ� ���������� ���ÿ� 1���� push
 * 4.���� 0��° �ε����� ���ڰ� �������� ���߰� �ش� ���ڸ� pop , poppushlist�� +�� Ǫ��
 * 5.������ �� ���� ���ڰ� ������ 1��° �ε����� ������ �ش� ���ڸ� pop, poppushlist�� -�� Ǫ��
 * 6.���� ������ �� ���� ���ڰ� ������ 1��° �ε����� �ٸ��� 1��° �ε����� ���� ���ڰ� ���ö����� ���ÿ� push
 * 7.���� ������ �� ���� ���ڰ� ������ ���� �ε������� ũ�� NO
 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int num = sc.nextInt(); // ������ ũ�� ���ϱ�
        int[] arr= new int[num+1]; // ����� ���� ����
 
        int stack[] = new int[1024];
        int top = -1;//���� �����
        
        char PopPush[] = new char [1024]; // +,-�� ��Ÿ�� ����Ʈ
        
        for(int i=0; i<num;i++) {
            arr[i] = sc.nextInt();
        } //���� �Է¹ޱ�
        int order=0; //������ �ε����� ��Ÿ�� ��
        int pporder=0;//PopPush �ε���
        for (int i=1;i<=num;i++) {
        	stack[++top]=i;  //top ������Ų�� stack[top]�� 1���� ������������ push
        	PopPush[pporder]='+'; //push�Ҷ����� poppush�� + push
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