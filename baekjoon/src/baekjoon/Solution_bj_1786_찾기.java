package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1786_찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] s = br.readLine().toCharArray();
		char[] ptn = br.readLine().toCharArray();
		int pLen = ptn.length;
		int sLen = s.length;
		int[] pi = new int[pLen];
		int ans = 0;
		List<Integer> list = new ArrayList<>();
		
		for(int i=1, j=0; i<pLen; i++) {
			while(j>0&&ptn[i]!=ptn[j]) j = pi[j-1];
			if(ptn[i]==ptn[j]) pi[i] = ++j;
		}
		for(int i=0, j=0; i<sLen; i++) {
			while(j>0&&s[i]!=ptn[j]) j = pi[j-1];
			if(s[i]==ptn[j]) {
				if(j==pLen-1) {
					j = pi[j];
					ans++;
					list.add(i-pLen+2);
				} else {
					j++;
				}
			}
		}
		System.out.println(ans);
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}
