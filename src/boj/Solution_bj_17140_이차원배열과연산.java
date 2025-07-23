package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_bj_17140_이차원배열과연산 {
	static class Node implements Comparable<Node> {
		int idx;
		int cnt;
		public Node(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Node o) {
			return (this.cnt==o.cnt)?Integer.compare(this.idx, o.idx):Integer.compare(this.cnt, o.cnt);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list = new ArrayList[3]; 
		for(int i=0; i<3; i++) 
			list[i] = new ArrayList<>();
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<3; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		int time = 0;
		while(time<100) {
			if(list[r-1].get(c-1)==K) {
				System.out.println(time);
				return;
			}
			if(list.length>=list[0].size()) { // 행의 개수>=열의 개수
				for(int i=0; i<list.length; i++) {
					ArrayList<Node> nodelist = new ArrayList<>();
					int[] cnt = new int[101];
					for(int j=0; j<list[0].size(); j++) {
						int num = list[i].get(j);
						cnt[num]++; // 숫자 개수 카운트
					}
					for(int j=0; j<cnt.length; j++) {
						if(cnt[j]!=0) {
							nodelist.add(new Node(j,cnt[j])); // 카운트한 숫자 인덱스와 카운트 저장
						}
					}
					Collections.sort(nodelist); // 카운트가 적은 순으로 정렬. 카운트가 같으면 인덱스 오름차순 정렬.
					list[i].clear(); // 기존 행 지우고
					for(int j=0; j<nodelist.size(); j++) { // 새로운 행 채우기
						list[i].add(nodelist.get(j).idx); // 숫자 종류와
						list[i].add(nodelist.get(j).cnt); // 해당 숫자 개수 저장
					}
				}
				// 부족한 부분 0으로 채우기
				int max = 0;
				for(int i=0; i<list.length; i++) {
					max = Math.max(max, list[i].size());
				}
				for(int i=0; i<list.length; i++) {
					while(list[i].size()<max) {
						list[i].add(0);
					}
				}
			} else { // 행의 개수 < 열의 개수
				for(int i=0; i<list[0].size(); i++) {
					ArrayList<Node> nodelist = new ArrayList<>();
					int[] cnt = new int[101];
					for(int j=0; j<list.length; j++) {
						int num = list[j].get(i);
						cnt[num]++; // 숫자 개수 카운트
					}
					for(int j=0; j<cnt.length; j++) {
						if(cnt[j]!=0) {
							nodelist.add(new Node(j,cnt[j])); // 카운트한 숫자 인덱스와 카운트 저장
						}
					}
					Collections.sort(nodelist); // 카운트가 적은 순으로 정렬. 카운트가 같으면 인덱스 오름차순 정렬.

					for(int j=0; j<list.length; j++) {
						list[j].remove(i); // 해당 열 지우고
						for(int k=0; k<2*nodelist.size(); k+=2) { // 새로운 행 채우기
							list[k].add(i,nodelist.get(k/2).idx); // 숫자 종류와
							list[k+1].add(i,nodelist.get(k/2).cnt); // 해당 숫자 개수 저장
						}
					}
				}
				// 부족한 부분 0으로 채우기
				int max = list.length;
				for(int i=0; i<list.length; i++) {
					while(list[i].size()<max) {
						list[i].add(0);
					}
				}
			}
			time++;
		}
		System.out.println(-1);
		br.close();
	}
}
