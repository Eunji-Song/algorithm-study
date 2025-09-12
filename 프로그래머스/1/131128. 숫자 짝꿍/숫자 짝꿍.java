import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String X, String Y) {
       int[] cntX = new int[10];
        int[] cntY = new int[10];

        for (int i = 0; i < X.length(); i++) {
            cntX[X.charAt(i) - '0']++;
        }
        for (int i = 0; i < Y.length(); i++) {
            cntY[Y.charAt(i) - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int k = Math.min(cntX[i], cntY[i]);
            if (k > 0) sb.append(String.valueOf(i).repeat(k));
        }

        if (sb.length() < 1) return "-1";
        if (sb.charAt(0) == '0') return "0";

        return sb.toString();
    }
}