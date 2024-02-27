package a0208.camp;

import java.io.*;
import java.util.*;
 
public class Solution_D9_2382_미생물격리_서울_20반_신호준 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N, M, K;
	static ArrayList<Microbe> list;
	// 미생물 정보 저장 클래스. 이차원 배열의 특정 인덱스를 별도로 저장. 위치가 동일하다면 미생물 개수 내림차순 정렬.
	static class Microbe implements Comparable<Microbe> {
		int index, i, j, cnt, d;
		Microbe(int label, int i, int j, int cnt, int d) {
			this.index = label;
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.d = d;
		}
		@Override
		// 현재 위치가 동일하다면 미생물 개수로 내림차순 정렬한다. 그렇지 않으면 인덱스 오름차순 정렬
		public int compareTo(Microbe o) {
			return (this.index==o.index)?Integer.compare(o.cnt, this.cnt):Integer.compare(this.index, o.index);
		}
		@Override
		public String toString() {
			return "Microbe [label=" + index + ", i=" + i + ", j=" + j + ", cnt=" + cnt + ", d=" + d + "]";
		}
	}
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d9_2382.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            // 정보 입력 받기
            for(int k=0; k<K; k++) {
            	st = new StringTokenizer(br.readLine(), " ");
            	int i = Integer.parseInt(st.nextToken());
            	int j = Integer.parseInt(st.nextToken());
            	int cnt = Integer.parseInt(st.nextToken());
            	int d = Integer.parseInt(st.nextToken());
            	list.add(new Microbe(i*N+j, i, j, cnt, d-1));
            }
            // 주어진 시간까지 반복
            int hour = 0;
            while(hour<M) {
            	// 리스트 인덱스 제거를 용이하게 하기 위해 인덱스를 뒤에서부터 탐색
            	for(int i=list.size()-1; i>=0; i--) {
            		Microbe m = list.get(i);
            		// 위치와 인덱스 갱신
            		m.i += di[m.d];
            		m.j += dj[m.d];
            		m.index = m.i*N+m.j;
            		// 이동한 위치가 약품 셀이면 미생물 개수를 절반으로 감소하고, 방향을 반대로 바꾼다.
            		if(m.i==0||m.i==N-1||m.j==0||m.j==N-1) {
            			m.cnt /= 2;
            			if(m.d==0) m.d=1;
            			else if(m.d==1) m.d=0;
            			else if(m.d==2) m.d=3;
            			else m.d=2;
            			// 만약 미생물 개수가 0이면 리스트에서 제거한다.
            			if(m.cnt==0) {
            				list.remove(i);
            			}
            		}
            	}
            	// 군집끼리 합쳐지는 경우를 위해 리스트 정렬
            	Collections.sort(list);
            	// 리스트 인덱스 제거를 용이하게 하기 위해 인덱스를 뒤에서부터 탐색
            	for(int i=list.size()-1; i>0; i--) {
            		Microbe current = list.get(i);
            		Microbe prev = list.get(i-1);
            		// 군집끼리 합쳐지면 더 큰 군집의 미생물 개수를 증가시키고, 합쳐진 군집을 리스트에서 제거.
            		if(current.index==prev.index) {
            			prev.cnt += current.cnt;
            			list.remove(i);
            		}
            	}
            	hour++;
            }
            // 전체 미생물 개수 구하기
            int sum = 0;
            for(Microbe m:list) {
            	sum += m.cnt;
            }
            sb.append("#"+tc+" "+sum+"\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
