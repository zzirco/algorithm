package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1181_단어정렬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> sa = new ArrayList<>();
		ArrayList<Integer> ia = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			if(!sa.contains(s)) {
				sa.add(s);
				if(!ia.contains(s.length())) {
					ia.add(s.length());
				}
			}
		}
		Collections.sort(sa);
		Collections.sort(ia);
		
		for(int i:ia) {
			for(int j=0; j<sa.size(); j++) {
				if(sa.get(j).length()==i) {
					System.out.println(sa.get(j));
				}
			}
		}
	}
}
