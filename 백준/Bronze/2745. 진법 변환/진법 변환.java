import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken().trim();
        int B = Integer.parseInt(st.nextToken());

        long ans = 0;
        for (int i = 0; i < N.length(); i++) {
            char ch = N.charAt(i);
            int digit;
            if ('0' <= ch && ch <= '9') {
                // 숫자 처리 
                digit = ch - '0';
            } else { 
                // 알파벳 처리 
                digit = ch - 'A' + 10;
            }
            
            ans = ans * B + digit;
        }
        System.out.println(ans);
    }
}