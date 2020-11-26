package termproject_2;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		Random rand=new Random();
		
		System.out.println("생성할 데이터의 개수(N)를 입력하세요 : ");
		int size=sc.nextInt();
		
		System.out.println("랜덤 구간 개수(K)를 입력하세요 : ");
		int range_num=sc.nextInt();
		
		long start = System.currentTimeMillis(); //알고리즘 효율 측정 시작
		
		int start_p=0;
		int end_p=0;
		int change=0;
		
		int arr[]=new int[size];
		
		//System.out.println("--------------------생성된 배열--------------------");
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
			//System.out.println("구간"+"("+(start_p+1)+","+(end_p+1)+")");
			for(int j=start_p;j<=end_p;j++) {
				sum += arr[j]; //구간합계
				if(min>=arr[j]) min=arr[j];
				if(max<=arr[j]) max=arr[j];
				}
			System.out.println("최솟값 : "+min+"\t최댓값 : "+max+"\t합계 : "+sum);
	
			}
		
		long end = System.currentTimeMillis();
		System.out.println("걸린 시간 : "+(end-start));
	}
}

