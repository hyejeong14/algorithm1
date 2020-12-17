import java.util.*;

public class Main {
	static int Sum(int[] arr, int s, int e) {
		if(s == e) return arr[s];
		int sum=0;
		for(int i=s;i<=e;i++) {
			sum += arr[i];
		}
		return sum;
	}
	static int Max(int[] arr, int s, int e) {
		int max = arr[s];
		for(int i = s; i <= e; i++) {
			if(arr[i] > max) max = arr[i];
		}
		return max;
	}
	static int Min(int[] arr, int s, int e) {
		int min = arr[s];
		for(int i = s; i <= e; i++) {
			if(arr[i] < min) min = arr[i];
		}
		return min;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		System.out.print("������ �������� ����(N)�� �Է��ϼ��� : ");
		int N = sc.nextInt();
		System.out.print("���� ���� ����(K)�� �Է��ϼ��� : ");
		int K = sc.nextInt();
		
		// ������ n���� ������ ����
		int arr[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = rd.nextInt();
			//System.out.println(arr[i]+" ");
		}
		
		int start[] = new int[K];
		int end[] = new int[K];
		for(int i = 0; i < K; i++) {
			while(true) {
				start[i] = rd.nextInt(N);
				end[i] = rd.nextInt(N);
				if(start[i] < end[i]) break;
			}
		}
		
		long start_t = System.currentTimeMillis();
		
		for(int i = 0; i < K; i++) {
			Sum(arr, start[i], end[i]);
			Max(arr, start[i], end[i]);
			Min(arr, start[i], end[i]);
		}

		long Elapsed_t = System.currentTimeMillis() - start_t;
		
		System.out.println("�ɸ� �ð� : " + Elapsed_t + "ms.");
	}
}