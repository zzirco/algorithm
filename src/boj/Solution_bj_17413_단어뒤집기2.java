package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_bj_17413_단어뒤집기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = br.readLine();
		String[] arr = s.split("");
		sb.append(Arrays.toString(arr));
		int cnt = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]=="<") {
				if(cnt!=0) {
					while(arr[i]!=" ") {
						i++;
					}
					String[] tmp = new String[cnt];
					for(int j=cnt-1; j>=0; j--) {
						tmp[j] = arr[i-cnt];
					}
					sb.append(tmp);
					cnt = 0;
				}
				while(arr[i]!=">") {
					i++;
				}
				i++;
			}
			cnt++;
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
