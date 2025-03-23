package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_10808 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] alphabet = new int[26];
		for(int i=0; i<s.length(); i++) {
			alphabet[s.charAt(i)-'a']++;
		}
		for(int i=0; i<26; i++) {
			System.out.print(alphabet[i] + " ");
		}
	}
}
