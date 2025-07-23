package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2083 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(name.equals("#")) break;
            sb.append(name).append(" ");
            if(age>17||weight>=80) sb.append("Senior").append("\n");
            else sb.append("Junior").append("\n");
        }
        System.out.println(sb);
    }
}
