package termproject_2;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		Random rand=new Random();
		
		System.out.println("������ �������� ����(N)�� �Է��ϼ��� : ");
		int size=sc.nextInt();
		
		System.out.println("���� ���� ����(K)�� �Է��ϼ��� : ");
		int range_num=sc.nextInt();
		
		long start = System.currentTimeMillis(); //�˰��� ȿ�� ���� ����
		
		int start_p=0;
		int end_p=0;
		int change=0;
		
		int arr[]=new int[size];
		
		//System.out.println("--------------------������ �迭--------------------");
		for(int i=0;i<size;i++) {
			arr[i]=rand.nextInt();
			//System.out.print(arr[i]+" ");
		}
		//System.out.println("\r");
		
		for(int i=0;i<range_num;i++) {
			start_p=rand.nextInt(size);
			end_p=rand.nextInt(size);
			if(start_p>end_p) {
				change=end_p;
				end_p=start_p;
				start_p=change;				
			}
			int min = arr[start_p];
			int max = arr[start_p];
			int sum=0;
			//System.out.println("����"+"("+(start_p+1)+","+(end_p+1)+")");
			for(int j=start_p;j<=end_p;j++) {
				sum += arr[j]; //�����հ�
				if(min>=arr[j]) min=arr[j];
				if(max<=arr[j]) max=arr[j];
				}
			System.out.println("�ּڰ� : "+min+"\t�ִ� : "+max+"\t�հ� : "+sum);
	
			}
		
		long end = System.currentTimeMillis();
		System.out.println("�ɸ� �ð� : "+(end-start));
	}
}

