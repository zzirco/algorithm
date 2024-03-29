package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1786_찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] s = br.readLine().toCharArray();
		char[] ptn = br.readLine().toCharArray();
		int plen = ptn.length;
		int[] pi = new int[plen];
		int ans = 0;
		for(int i=1, j=0; i<plen; i++) {
			while(j>0&&ptn[i]!=ptn[j]) j = pi[j-1];
			if(ptn[i]==ptn[j]) pi[i] = ++j;
		}
		A:for(int i=0, j=0; i<plen; i++) {
			while(j>0&&s[i]!=ptn[j]) j = pi[j-1];
			if(ptn[i]==ptn[j]) {
				if(j==plen-1) {
					j = pi[j];
					ans = 1;
					break A;
				} else {
					j++;
				}
			}
		}
		System.out.println(Arrays.toString(pi));
		System.out.println(ans);
	}
}
