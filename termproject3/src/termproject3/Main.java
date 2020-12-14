package termproject3;
import java.util.*;
public class Main{
    public static void main(String[] args) {
    	
        Tree st = new Tree();
        
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        
        long start = System.currentTimeMillis(); //알고리즘 효율 측정 시작
        
        for(int i =0;i<st.K;i++) {
        	//System.out.println(i+""+st.K);
        	int start_p;
        	int end_p;
        	while(true) {
				start_p = rd.nextInt(st.N);
				end_p = rd.nextInt(st.N);
				if(start_p<=end_p) break;
			}
        	
        	//System.out.println("시작 : "+start_p+"끝 : "+end_p);
        	st.init_min(0,st.arr.length-1, 1);
        	st.min_num(0,st.arr.length-1,1,start_p-1, end_p-1);
        	st.init_max(0,st.arr.length-1, 1);
        	st.max_num(0,st.arr.length-1,1,start_p-1, end_p-1);
        	st.init_sum(0, st.arr.length-1,1);
        	st.sum(0,st.arr.length-1,1,start_p-1, end_p-1);
        	
    
        }
        long end = System.currentTimeMillis();
		System.out.println("걸린 시간 : "+(end-start));
        
}
}
class Tree {
	int N;
	int K;
	int arr[]; // 구간합을 만들 요소들
    int tree[]; // 구간합 트리
    public Tree() {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        System.out.print("생성할 데이터의 개수(N)를 입력하세요 : ");
        N = sc.nextInt();
        arr = new int[N];
        tree = new int[arr.length*4];
        for(int i=0;i<arr.length;i++) {
            arr[i] = rd.nextInt();
        }
        System.out.println("랜덤 구간 개수(K)를 입력하세요 : ");
        K = sc.nextInt();
    }
    
    public int init_sum(int start, int end, int node) {
        if(start == end) { 
            return tree[node] = arr[start]; 
        }
        /* 반씩 나눠서  재귀적으로 자식노드들의 구간합을 구해준다 */
        int mid = (start+end)/2;
        return tree[node] = init_sum(start, mid, node*2) + init_sum(mid+1, end, node*2+1);
    }
    public int sum(int start, int end, int node, int left, int right) {
        if(left>end || right < start) {
            return 0;
        }
        if(left <=start && end <=right) {
            return tree[node];
        }
        /* 필요한 구간마다 밑에서부터 구간합을 가지고 올라온다 */
        int mid = (start+end)/2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }
    public int init_min(int start, int end,int node){
		if(start == end){
			return tree[node]=arr[start];
		}
		
		int mid = (start+end)/2;
		
		return tree[node]= Math.min(init_min(start, mid,node*2) , init_min(mid+1, end,node*2+1));
	}
	public int min_num(int start, int end,int node, int left, int right){
			if(start>right || end<left){
				return Integer.MAX_VALUE;
			}
			if(left<=start && end<=right){
				return tree[node];
			}
			int mid = (start+end)/2;
			
			return Math.min(min_num(start,mid,node*2,left,right), min_num(mid+1,end,node*2+1,left,right));
		}
	public int init_max(int start, int end,int node){
		if(start == end){
			return tree[node]=arr[start];
		}
		
		int mid = (start+end)/2;
		
		return tree[node]= Math.max(init_max(start, mid,node*2) , init_max(mid+1, end,node*2+1));
	}
	public int max_num(int start, int end,int node, int left, int right){
			if(start>right || end<left){
				return Integer.MIN_VALUE;
			}
			if(left<=start && end<=right){
				return tree[node];
			}
			int mid = (start+end)/2;
			
			return Math.max(max_num(start,mid,node*2,left,right), max_num(mid+1,end,node*2+1,left,right));
		}

    }
