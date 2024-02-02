package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_2023_신기한소수 {
	static StringBuilder sb = new StringBuilder();
	static boolean isPrime(int num) {
		if(num<2) return false;
		for(int i=2; i<=num/2; i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
	static void getPrime(int output, int n) {
        if (n == 0) {
            if (isPrime(output)) sb.append(output).append("\n");
            return;
        }
        for (int i=0; i<10; i++) {
            int next = output*10+i;
            if (isPrime(next)) getPrime(next, n-1);
        }
    }
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		getPrime(0,N);
		System.out.println(sb);
		br.close();
	}
}
