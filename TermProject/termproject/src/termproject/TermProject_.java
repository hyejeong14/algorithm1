package termproject;
import java.util.*;
public class TermProject_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("생성할 배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		
		int arr[] = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i]=rand.nextInt(1000);
			System.out.print(arr[i]+" ");
			
		}
		System.out.println("\r");
		
		
		int sum=0,max=0;
		System.out.println("구간 시작값과 종료값을 입력하세요 : " );
		int start = sc.nextInt();
		int end = sc.nextInt();
		int min = arr[start-1];
		for(int j=start-1;j<end;j++) {
			sum += arr[j];
			if(max<arr[j]) max=arr[j];
			if(min>arr[j]) min=arr[j];
		}
		System.out.println(min+" "+max+" "+sum);


	}

}
