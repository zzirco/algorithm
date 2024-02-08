import java.io.*;
import java.util.*;

public class NextCombMain {
	static int N=4, C=0;
	static int[] a={1,1,1,0}; static char[] b={'A','B','C','D'};
	
	static void swap(int i, int j) {
		int T = a[i]; 
		a[i] = a[j]; 
		a[j] = T;
	}
	static boolean nPn() {
		int i = N-1;//i 교환위치 찾기
		while(i>0 && a[i-1]>=a[i]) i--;
		if(i==0) return false;
		
		int j = N-1;//j 교환할값 찾기
		while(a[i-1]>=a[j]) j--;
		swap(i-1, j);
		
		int k = N-1;//k 오름차순 정렬
		while(i<k) swap(i++,k--);
		return true;
	}
	public static void main(String[] args) throws Exception {
		Arrays.sort(a);
		do {
			System.out.print(Arrays.toString(a)); C++;
			System.out.println(); // 순열사용
			for(int i=0; i<N; i++) System.out.print(a[i]!=0?b[i]:"");
			System.out.println(); // 조합사용
		} while(nPn());
		System.out.println(C);
	}
}
