package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_bj_14891_톱니바퀴 {
	static ArrayList<Integer>[] list = new ArrayList[4];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0; i<4; i++) {
			String s = br.readLine();
			String[] sa = s.split("");
			list[i] = new ArrayList<>();
			for(int j=0; j<8; j++) {
				list[i].add(Integer.parseInt(sa[j]));
			}
		}
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken())-1;
			int rotate = Integer.parseInt(st.nextToken());
			int tmp = num;
			int rotTmp = rotate;
			Queue<int[]> q = new ArrayDeque<>();
			while(num-1>=0&&list[num-1].get(2)!=list[num].get(6)) { // 만약 자신 왼쪽에 톱니바퀴가 존재하고, 자석의 극이 다르다면
				if(rotate==1) rotate = -1;
				else rotate = 1;
				q.offer(new int[]{--num, rotate}); // 해당 톱니의 정보를 큐에 저장하고 계속해서 탐색
			}
			num = tmp; // 시작 톱니 초기화
			rotate = rotTmp;
			while(num+1<=3&&list[num].get(2)!=list[num+1].get(6)) { // 만약 자신 오른쪽에 톱니바퀴가 존재하고, 자석의 극이 다르다면
				if(rotate==1) rotate = -1;
				else rotate = 1;
				q.offer(new int[]{++num, rotate});// 해당 톱니의 정보를 큐에 저장하고 계속해서 탐색
			}
			while(!q.isEmpty()) { // 큐에 저장된 톱니의 정보를 토대로 회전
				int[] info = q.poll();
				int idx = info[0];
				int rot = info[1];
				if(rot==1) rotation(rot, idx); // 만약 자신이 시계방향회전이면 왼쪽 톱니는 반시계회전
				else rotation(rot, idx); // 만약 자신이 반시계방향회전이면 왼쪽 톱니는 시계회전
			}
			num = tmp; // 시작 톱니 정보 초기화
			rotate = rotTmp;
			rotation(rotate, num); // 자기자신 회전
		}
		int ans = 0;
		if(list[0].get(0)==1) ans += 1;
		if(list[1].get(0)==1) ans += 2;
		if(list[2].get(0)==1) ans += 4;
		if(list[3].get(0)==1) ans += 8;
		System.out.println(ans);
	}
	static void rotation(int rotate, int num) {
		if(rotate==-1) {
			int tmp = list[num].get(0);
			for(int j=0; j<7; j++) {
				list[num].set(j, list[num].get(j+1));
			}
			list[num].set(7, tmp);
		} else {
			int tmp = list[num].get(7);
			for(int j=7; j>=1; j--) {
				list[num].set(j, list[num].get(j-1));
			}
			list[num].set(0, tmp);
		}
	}
}
