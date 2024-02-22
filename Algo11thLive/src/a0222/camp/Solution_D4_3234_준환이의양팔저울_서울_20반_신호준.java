package a0222.camp;

import java.io.*;
import java.util.*;

public class Solution_D4_3234_준환이의양팔저울_서울_20반_신호준 {
	static int N;
	static int[] a, b;
	static boolean[] v;
	static int ans;
	static void subset(int cnt, int left, int right) {
		if(left<right) return;
		if(cnt==N) {
			ans++;
			return;
		}
		subset(cnt+1,left,right+b[cnt]);
		subset(cnt+1,left+b[cnt],right);
	}
	static void perm(int cnt) {
		if(cnt==N) {
			subset(0,0,0);
			return;
		}
		for(int i=0; i<N; i++) {
			if(v[i]) continue;
			v[i] = true;
			b[cnt] = a[i];
			perm(cnt+1);
			v[i] = false;
		}
	}
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d4_3234.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	N = Integer.parseInt(br.readLine());
        	a = new int[N];
        	b = new int[N];
        	v = new boolean[N];
        	ans = 0;
        	st = new StringTokenizer(br.readLine()," ");
        	for(int i=0; i<N; i++) {
        		a[i] = Integer.parseInt(st.nextToken());
        	}
        	perm(0);
        	sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.println(sb);
    }
}
