package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1931_회의실배정 {
	static class Meeting implements Comparable<Meeting> {
		int start, end;
		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Meeting o) {
			return (this.end==o.end)?Integer.compare(this.start, o.start):Integer.compare(this.end, o.end);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(meetings);
		// 회의 선택을 최대로하고 선택된 회의들의 내용을 출력
		List<Meeting> list = new ArrayList<>();
		list.add(meetings[0]); // 첫 회의 선택
		for(int j=1; j<N; j++) { // j : 고려하는 회의
			if(list.get(list.size()-1).end<=meetings[j].start) {
				list.add(meetings[j]);
			}
		}
		System.out.println(list.size());
		br.close();
	}
}
