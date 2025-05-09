package baekjoon;

import java.io.*;

public class Main_1264 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            int ans = 0;
            char[] carr = br.readLine().toCharArray();
            if(carr[0]=='#') break;
            for(int i=0; i<carr.length; i++) {
                switch (carr[i]) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        ans++;
                        break;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
