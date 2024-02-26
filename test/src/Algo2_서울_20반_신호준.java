import java.io.*;
import java.util.*;

public class Algo2_서울_20반_신호준 {
	static int N;
	static int[] a,b;
	static class Project implements Comparable<Project> {
		int sm; // 시작 달
		int sd; // 시작 날짜
		int em; // 끝나는 달
		int ed; // 끝나는 날짜
		public Project(int sm, int sd, int em, int ed) {
			super();
			this.sm = sm;
			this.sd = sd;
			this.em = em;
			this.ed = ed;
		}
		@Override
		public String toString() {
			return "Project [sm=" + sm + ", sd=" + sd + ", em=" + em + ", ed=" + ed + "]";
		}
		@Override
		// 정렬기준 : 프로젝트 시작이 빠른 순으로 정렬. 만약 시작이 같다면 끝이 빠른 순으로 정렬
		public int compareTo(Algo2_서울_20반_신호준.Project o) {
			if(this.sm==o.sm) {
				if(this.sd==o.sd) {
					if(this.em==o.em) {
						return Integer.compare(this.ed, o.ed);
					}
					return Integer.compare(this.em, o.em);
				}
				return Integer.compare(this.sd, o.sd);
			}
			return Integer.compare(this.sm, o.sm);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		ArrayList<Project> list = new ArrayList<>();
		ArrayList<Project> ans = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sm = Integer.parseInt(st.nextToken());
			int sd = Integer.parseInt(st.nextToken());
			int em = Integer.parseInt(st.nextToken());
			int ed = Integer.parseInt(st.nextToken());
			list.add(new Project(sm, sd, em, ed));
		}
		ans.add(list.get(0));
		boolean isOk = false;
		int start = 1;
		while(true) {
			Project cur = ans.get(ans.size()-1);
			// 만약 마지막 프로젝트가 11월 31일 이후에 끝난다면 선택한 프로젝트의 개수를 출력한다
			if(cur.em>11) {
				isOk = true;
				break;
			} else if(cur.em==11) {
				if(cur.ed>=31) {
					isOk = true;
					break;
				}
			}
			// 프로젝트를 선택하는 과정
			int i;
			if(start>=list.size()) break;
			for(i=start; i<list.size(); i++) {
				Project p = list.get(i);
				if(p.em>=cur.em) { 
					if(p.em==cur.em) { // 끝나는 달이 같으면
						if(p.ed>cur.ed) { // 끝나는 날 비교해서 더 늦게 끝나는 프로젝트 중
							if(p.sm<=cur.em&&p.sd<=cur.ed) { // 시작일이 끝나는날 전에 시작하면
								ans.add(p); // 정답 리스트에 추가
								break;
							}
						}
					}
					if(p.sm<=cur.em&&p.sd<=cur.ed) { // 끝나는 달이 크면 위와 같이 수행
						ans.add(p);
						break;
					}
				}
			}
			start = i+1; // 시작 인덱스 증가
		}
		if(isOk) System.out.println(ans.size());
		else System.out.println(0);
	}

}
