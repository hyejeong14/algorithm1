import java.util.*;

public class Main {
	
	static long histo(int[] v,int a,int b) {
		if(a==b) return v[a];
		int mid = (a+b)/2 , r=2;
		long min =(v[mid]<v[mid+1])?v[mid]:v[mid+1];
		long max = min*r;
		int i = mid-1, j=mid+2;
		while(i>=a && j<=b) {
			if(v[i]>v[j]) {if (v[i]<min) min=v[i]; i--;}
			else {if(v[j]<min) min=v[j];j++;}
			if(max<min*(++r)) max = min*r;
		}
		while(i>=a) {
			if(v[i]<min) min=v[i]; i--; if(max<min*(++r)) max=min*r;
		}
		while(j<=b) {
			if(v[j]<min) min=v[j]; j++; if(max<min*(++r)) max=min*r;
		}
		
		long left_max = histo(v,a,mid);
		long right_max = histo(v,mid+1,b);
		if(max<left_max) max=left_max;
		if(max<right_max) max=right_max;
		return max;
		
	}
	static long histo(int[]v,int n) {
		return histo(v,0,n-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] v = new int[n];
		for(int i=0;i<n;i++) {
			v[i] = sc.nextInt();
		}
		long r = histo(v,n);
		System.out.println(r);

	}

}
