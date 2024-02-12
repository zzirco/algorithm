package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1244_스위치켜고끄기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());  // 스위치 개수 100이하 양의 정수
		int[] arr = new int[N+1]; // 스위치 상태 저장 배열
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 스위치 상태 입력 받기
		}
		int K = Integer.parseInt(br.readLine()); // 학생 수 100 이하 양의 정수. 남학생은 1, 여학생은 2.
		for(int i=0; i<K; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int Gender = Integer.parseInt(st2.nextToken()); // 학생 성별
			int num = Integer.parseInt(st2.nextToken()); // 학생이 받은 수
			if(Gender==1) { // 남학생의 경우
				for(int j=1; j<=N; j++) {
					if(j%num==0) { // 인덱스가 학생이 받은 수의 배수이면
						if(arr[j]==1) { // 1일 경우 0으로 바꾼다
							arr[j]=0;
						} else {  // 0일경우 1로 바꾼다
							arr[j]=1;
						}
					}
				}
			} else { // 여학생의 경우
				int cnt = 1; // 대칭을 확인하을 위한 인덱스 증감 카운트 변수
				if(arr[num]==1) { // 학생이 받은 수의 스위치 상태를 바꾼다
					arr[num]=0;
				} else {
					arr[num]=1;
				}
				while(num-cnt>=1 && num+cnt<=N && arr[num-cnt]==arr[num+cnt]) { // 받은 수를 기준으로 대칭 위치에 있는 스위치 상태가 같으면(인덱스 범위 내에서)
					if(arr[num-cnt]==1) { // 1일 경우 0으로 바꾼다
						arr[num-cnt]=0;
						arr[num+cnt]=0;
					} else {  // 0일 경우 1로 바꾼다
						arr[num-cnt]=1;
						arr[num+cnt]=1;
					}
					cnt++; // 다음 대칭 인덱스를 비교한다
				}
			}
		}
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(cnt!=0 && cnt%20==0) { // 스위치 상태를 20개 출력하면 줄을 바꾼다
				System.out.println(); 
			}
			System.out.print(arr[i]+" "); // 스위치 상태를 출력한다
			cnt++;
		}
		br.close();
	}
}
