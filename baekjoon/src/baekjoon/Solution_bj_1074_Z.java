package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1074_Z {
	static int N,r,c,cnt=0;
	static void zfunc(int n, int row, int column)
	{
		int k = (int) Math.pow(2, n - 1);

		if (n > 1) {
			if (row < k && column < k) {
				zfunc(n - 1, row, column);
			}
			else if (row < k && column >= k) {
				cnt += Math.pow(4, n-1);
				zfunc(n - 1, row, column - k);
			}
			else if (row >= k && column < k) {
				cnt += 2 * Math.pow(4, n-1);
				zfunc(n - 1, row - k, column);
			}
			else {
				cnt += 3 * Math.pow(4, n-1);
				zfunc(n - 1, row - k, column - k);
			}
		}
		else {
			cnt += (2 * row + column);
			return;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		zfunc(N,r,c);
		System.out.println(cnt);
	}
}
