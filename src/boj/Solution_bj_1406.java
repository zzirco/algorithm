package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_bj_1406 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Character> list = new ArrayList<>();
		String s = br.readLine();
		int N = s.length();
		for(int i=0; i<N; i++) {
			list.add(s.charAt(i));
		}
		int M = Integer.parseInt(br.readLine());
		int it = N;
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char command = st.nextToken().charAt(0);
			if(command=='L') {
				it--;
				if(it<0) it = 0;
			} else if(command=='D') {
				it++;
				if(it>=list.size()) it = list.size();
			} else if(command=='B') {
				if(it==0) continue;
				list.remove(it-1);
				it--;
			} else {
				char c = st.nextToken().charAt(0);
				if(it==list.size()) list.add(c);
				else list.add(it, c);
				it++;
			}
		}
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i));
		}
	}
}
