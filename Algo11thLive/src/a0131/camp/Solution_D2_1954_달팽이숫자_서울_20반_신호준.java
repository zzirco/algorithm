package a0131.camp;

import java.io.*;
import java.util.*;

public class Solution_D2_1954_달팽이숫자_서울_20반_신호준 {
	static int[] di = {0,1,0,-1}; //우, 하, 좌, 상 순서로 탐색
	static int[] dj = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_1954.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());  // 테스트 케이스 입력 받기
		
		for(int tc=1; tc<=T; tc++) {  // 테스트 케이스만큼 반복
			int N = Integer.parseInt(br.readLine()); // 달팽이 배열 크기 입력받기
			int[][] arr = new int[N][N]; // 달팽이 배열 선언
			int I=0, J=0, cnt=1; // 현재위치 저장할 변수 I,J 선언. 카운트 변수 cnt 선언.
			arr[I][J] = 1; // 첫 시작 위치에 1 저장
			
			while(true) {
				if(cnt==N*N) { // 모든 숫자를 출력하면 반복문 종료
					break;
				}
				for(int d=0; d<4; d++) { // 4방 탐색 시작
					int ni = I+di[d]; // 탐색위치 갱신
					int nj = J+dj[d];
					while(ni>=0 && ni<N && nj>=0 && nj<N && arr[ni][nj]==0) { // 탐색위치가 배열 인덱스를 벗어나지 않고, 아직 숫자를 저장하지 않았다면 현재 방향으로 계속해서 탐색.
						arr[ni][nj] = ++cnt; // 해당위치에 숫자 출력
						I = ni; // 탐색위치 갱신
						J = nj;
						ni = I+di[d];
						nj = J+dj[d];
					}
				}
			}
			
			System.out.print("#"+tc+"\n"); // 정답 출력
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
