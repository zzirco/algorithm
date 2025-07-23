package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_7579_앱 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int ans = Integer.MAX_VALUE;
		int[][] items = new int[N][2];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			items[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			items[i][0] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[10001];
		for (int i=0; i<N; i++) {
			for (int j=10000; j>=items[i][0]; j--) {
				dp[j] = Math.max(dp[j], dp[j-items[i][0]] + items[i][1]);
				if(dp[j]>=K) ans = Math.min(ans, j);
			}
		}
		System.out.println(ans);
		br.close();
	}
}

/*
5 100
20 20 20 20 20
0 0 0 0 0

답 : 0

입력

7 120
20 91 92 93 94 95 100
1 2 2 2 2 2 2

정답 : 3

24 1
1 2 4 8 16 32 64 128 256 512 1024 2048 4096 8192 16384 32768 65536 131072 262144 524288 1048576 2097152 4194304 8388608
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1

정답 1

19 20169
240 2560 434 6 31 577 500 2715 2916 952 2490 258 1983 1576 3460 933 1660 2804 2584
82 77 81 0 36 6 53 78 49 82 82 33 66 8 60 0 98 91 93

정답 484

5 60
30 10 20 35 40
0 1 0 0 0

답 : 0

7 120
20 91 92 93 94 95 100
1 2 2 2 2 2 2

정답 : 3
*/