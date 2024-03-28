import java.util.*;
import java.io.*;


public class PrimMain2
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        StringBuilder sb = new StringBuilder();
        String[] sa = new String[100];
        int idx = 0;
        while(st.hasMoreTokens()) {
            sb.append(st.nextToken().charAt(0));
            idx++;
        }
        System.out.println(sb);
    }
}