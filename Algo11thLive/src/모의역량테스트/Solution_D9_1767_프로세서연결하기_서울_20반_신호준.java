package 모의역량테스트;

import java.io.*;
import java.util.*;

public class Solution_D9_1767_프로세서연결하기_서울_20반_신호준 {
	static final int[] di = {-1,1,0,0};
	static final int[] dj = {0,0,-1,1};
	static int N;
	static int[][] arr;
	static boolean[][] v;
	static int ansCore, ansLine;
	static int cnt;
	static ArrayList<int[]> list;
	static void dfs(int depth, int c, int lineCnt) {
		// 기저조건 : 모든 코어에 대해 탐색 완료했으면 기존 정답과 비교해서 코어개수와 전선개수 갱신
		if(depth==list.size()) {
			if(ansCore<c) { // 만약 이번 분기의 코어개수가 더 많으면
				ansCore = c; // 코어개수 갱신
				ansLine = lineCnt; // 전선 개수 갱신
			} else if(ansCore==c) { // 만약 이번 분기의 코어개수가 기존과 같으면
				if(ansLine>lineCnt) { // 전선개수 비교 후 더 작다면
					ansLine = lineCnt; // 전선 개수 갱신
				}
			}
			return; // 이번 분기 dfs 종료
		}
		
		int[] ij = list.get(depth); // 코어 정보 추출
		for(int d=0; d<4; d++) { // 사방으로 탐색하면서
			if(isPossible(ij, d)) { // 만약 해당 방향으로 전선이 놓일 수 있다면
				fill(ij,d,2); // 전선을 놓고
				dfs(depth+1,c+1,lineCnt+cnt); // 다음 코어 탐색, 연결한 코어개수 1 증가, 전선개수 증가
				fill(ij,d,0); // 탐색완료 후 다시 전선을 치운다
			}
		}
		dfs(depth+1,c,lineCnt); // 만약 사방 전부 탐색 후 연결 가능한 방향이 없으면, 다음 코어 탐색을 진행하되 코어개수와 전선개수는 그대로 진행.
	}
	static boolean isPossible(int[] ij, int d) { // 현재 코어 위치에서 해당 방향으로 전선이 놓일 수 있는지 검사
		int i = ij[0];
		int j = ij[1];
		while(true) { // 인덱스를 나가거나 불가능 할 때까지 반복
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0&&ni<N&&nj>=0&&nj<N) {
				if(arr[ni][nj]!=0) return false; // 중간에 코어나 다른 전선을 만난다면 불가능 리턴
				i = ni;
				j = nj;
			} else { // 중간에 장애물을 만나지 않고 배열 범위를 벗어나면 가능 리턴
				return true;
			}
		}
	}
	static void fill(int[] ij, int d, int value) { // 전선 연결이 가능할 경우 전선을 놓는 함수
		cnt = 0; // 전선 개수 카운팅 할 변수
		int i = ij[0];
		int j = ij[1];
		while(true) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0&&ni<N&&nj>=0&&nj<N) { // 인덱스를 벗어나지 않는 범위에서
				arr[ni][nj] = value; // 주어진 값으로 설정
				i = ni;
				j = nj;
				cnt++; // 전선 수 카운팅
			} else { // 인덱스를 벗어나면 종료
				return;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_1767.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			v = new boolean[N][N];
			ansCore = Integer.MIN_VALUE;
			ansLine = Integer.MAX_VALUE;
			list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!(i==0||i==N-1||j==0||j==N-1)&&arr[i][j]==1) {
						list.add(new int[] {i,j});
					}
				}
			}
			dfs(0, 0, 0);
			sb.append("#"+tc+" "+ansLine+"\n");
		}
		System.out.println(sb);
	}
}
