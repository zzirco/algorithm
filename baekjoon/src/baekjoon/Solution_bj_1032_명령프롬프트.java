package baekjoon;

import java.io.*;

public class Solution_bj_1032_명령프롬프트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		String[] sa = new String[s.length()];
		String[] sac = new String[s.length()];
		sa = s.split("");
		for(int i=1; i<N; i++) {
			s = br.readLine();
			sac = s.split("");
			for(int j=0; j<sa.length; j++) {
				if(!sa[j].equals(sac[j])) {
					sa[j] = "?";
				}
			}
		}
		for(int i=0; i<sa.length; i++) {
			System.out.print(sa[i]);
		}
	}
}
