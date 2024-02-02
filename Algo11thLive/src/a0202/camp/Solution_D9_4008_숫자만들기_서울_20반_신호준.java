package a0202.camp;

import java.io.*;
import java.util.*;

public class Solution_D9_4008_숫자만들기_서울_20반_신호준 {
	static String[] sa = {"+","-","*","/"};
	static int[] count = new int[4];
	static int[] num;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_4008.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			num = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N-1; i++) {
				count[i] += Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
		}
		System.out.println(sb);
	}
}
