package a0130.camp;
import java.io.*;
import java.util.*;

public class Solution_D4_1210_Ladder1_서울_20반_신호준 {
	static int[] di = {0,0,-1}; // 좌, 우, 상 순서로 탐색
	static int[] dj = {-1,1,0};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int I=0, J=0, ans=0; // 도착지점(탐색출발위치)의 위치를 저장할 변수 I, J. 정답 사다리를 저장할 변수 ans.
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100]; // 사다리 배열 100*100
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken()); // 사다리 배열 입력 받기
					if(arr[i][j]==2) { // 도착 지점을 입력받는다면
						I = i;  // 도착지점의 행렬 값 저장
						J = j;
					}
				}
			}
			
			while(true) {
				if(I==0) {  // 0번째 행에 도착하면
					ans = J;  // 그때의 열을 정답으로 저장
					break;
				}
				for(int d=0; d<3; d++) {  // 좌, 우, 상 세방향에 대해서 순차적으로 탐색
					int ni = I + di[d]; // 도착지점 부터 거꾸로 탐색
					int nj = J + dj[d];
					
					// 탐색하려는 위치가 인덱스를 벗어나지 않고, 사다리가 존재할 때
					if(ni>=0 && ni<100 && nj>=0 && nj<100 && arr[ni][nj]==1) {
						arr[ni][nj] = -1; // 탐색이 끝난 위치를 -1로 변경
						I = ni; // 해당 위치를 저장해서 다음 탐색에 사용
						J = nj;
						break;
					}
				}
			}
			sb.append("#"+N+" "+ans+"\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
