package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_11559_PuyoPuyo {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N;
	static char[][] arr;
	static boolean[][] v;
	static int ans, cnt;
	static Stack<int[]> remove;
	static void bfs(int i, int j, char color) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		v[i][j] = true;
		cnt++;
		remove.push(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<12&&nj>=0&&nj<6&&!v[ni][nj]&&arr[ni][nj]==color) {
					v[ni][nj] = true;
					cnt++;
					q.offer(new int[] {ni,nj});
					remove.push(new int[] {ni,nj});
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[12][6];
		v = new boolean[12][6];
		remove = new Stack<>();
		for(int i=0; i<12; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		// 더이상 터질 블럭이 없을 때 까지 반복
		while(true) {
			boolean puyo = false; // 이번 분기의 연쇄 여부를 나타낼 변수
			v = new boolean[12][6];
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					if(arr[i][j]!='.'&&!v[i][j]) { // 만약 블럭이 있으면
						cnt = 0;
						bfs(i,j,arr[i][j]); // 연결된 블럭을 탐색하고
						if(cnt<4) { // 연결된 블럭이 4개보다 적으면
							for(int k=0; k<cnt; k++) {
								remove.pop(); // 제거 리스트에서 제외
							}
						} else { // 연결된 블럭이 4개보다 많으면 이번 분기 연쇄 여부를 true로 변경
							puyo = true;
						}
					}
				}
			}
			if(puyo) ans++; // 만약 이번 분기에 연쇄가 있었다면 연쇄 1 증가
			if(remove.size()==0) break;
			while(!remove.isEmpty()) {
				int[] ij = remove.pop(); // 제거리스트에 있는 블럭 제거
				int i = ij[0];
				int j = ij[1];
				arr[i][j] = '.';
			}
			// 공중에 떠있는 블럭 낙하
			Stack<Character> s = new Stack<>();
			for(int j=0; j<6; j++) {
				for(int i=0; i<12; i++) {
					if(arr[i][j]!='.') {
						s.push(arr[i][j]);
					}
				}
				for(int i=11; i>=0; i--) {
					if(s.size()>0) {
						char c = s.pop();
						arr[i][j] = c;
					} else {
						arr[i][j] = '.';
					}
				}
			}
//			for(int i=0; i<12; i++) {
//				for(int j=0; j<6; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		System.out.println(ans);
	}
}
