package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_bj_11051_이항계수2 {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int p = 10007;
        long[] fac = new long[4000001];
        fac[0] = 1;
        for(int i=1; i<4000001; i++) fac[i] = fac[i-1]*i%p;
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	int n = Integer.parseInt(st.nextToken());
    	int r = Integer.parseInt(st.nextToken());
		long ans = (fac[n]*power(fac[r],p-2,p)%p*power(fac[n-r],p-2,p)%p)%p;
    	sb.append(ans+"\n");
        System.out.print(sb);
    }
}