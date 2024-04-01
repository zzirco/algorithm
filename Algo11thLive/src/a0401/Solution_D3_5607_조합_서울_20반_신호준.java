package a0401;

import java.io.*;
import java.util.*;
 
public class Solution_D3_5607_조합_서울_20반_신호준 {
	static long nCr(int n, int r, int p) {
		if(r==0) return 1L;
		long[] fac = new long[n+1];
		fac[0] = 1;
		for(int i=1; i<=n; i++) fac[i] = fac[i-1]*i%p;
		return fac[n]*power(fac[r]*fac[n-r],p-2,p)%p;
	}
	static long power(long x, long y, long p) {
		long res = 1L;
		while(y>0) {
			if(y%2==1) res=(res*x)%p;
			y=y>>1;
			x=(x*x)%p;
		}
		return res;
	}
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_d3_5607.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	int N = Integer.parseInt(st.nextToken());
        	int R = Integer.parseInt(st.nextToken());
        	int P = 1234567891;
        	long ans = nCr(N,R,P);
        	sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.print(sb);
    }
}