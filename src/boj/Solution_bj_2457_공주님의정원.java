package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_2457_공주님의정원 {
    static final int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] endDays = new int[366];
        for (int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	int[] arr = new int[4];
        	for(int j=0; j<4; j++) {
        		arr[j] = Integer.parseInt(st.nextToken());
        	}
            int start = getDay(arr[0], arr[1]);
            int end = getDay(arr[2], arr[3]);
            endDays[start] = Math.max(end, endDays[start]);
        }
        int lastDay = 1;
        int day = 60;
        int ct = 0;
        while (day<335) {
            int maxDay = 0;
            for (int i=lastDay; i<=day; i++) {
                maxDay = Math.max(endDays[i], maxDay);
            }
            if (maxDay==0) {
                break;
            }
            lastDay = day;
            day = maxDay;
            ct++;
        }
        if (day>=335) System.out.println(ct);
        else System.out.println(0);
    }
    static int getDay(int month, int day) {
        int ret = 0;
        for (int i=1; i<month; i++) {
            ret += days[i];
        }
        return ret + day;
    }
}
