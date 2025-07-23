package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_12891_DNA비밀번호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		String[] sa = s.split("");
		int[] compare = new int[4];
		int ans = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<4; i++) {
			compare[i] = Integer.parseInt(st.nextToken());
		}
		int[] count = new int[4];
		for(int i=0; i<R; i++) {
			if(sa[i].equals("A")) count[0]++;
			else if(sa[i].equals("C")) count[1]++;
			else if(sa[i].equals("G")) count[2]++;
			else if(sa[i].equals("T")) count[3]++;
		}
		//System.out.println(Arrays.toString(count));
		boolean isgood = true;
		for(int k=0; k<4; k++) {
			if(compare[k]>count[k]) {
				isgood = false;
			}
		}
		if(isgood==true) {
			ans++;
		}
		for(int j=R; j<N; j++) {
			int i=j-R;
			if(sa[i].equals("A")) count[0]--;
			else if(sa[i].equals("C")) count[1]--;
			else if(sa[i].equals("G")) count[2]--;
			else if(sa[i].equals("T")) count[3]--;
			if(sa[j].equals("A")) count[0]++;
			else if(sa[j].equals("C")) count[1]++;
			else if(sa[j].equals("G")) count[2]++;
			else if(sa[j].equals("T")) count[3]++;
			//System.out.println(Arrays.toString(count));
			isgood = true;
			for(int k=0; k<4; k++) {
				if(compare[k]>count[k]) {
					isgood = false;
				}
			}
			if(isgood==true) {
				ans++;
			}
		}
		System.out.println(ans);
		br.close();
	}
}
