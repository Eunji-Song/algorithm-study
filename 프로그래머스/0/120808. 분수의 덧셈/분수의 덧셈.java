import java.util.*;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        // 1) 공통분모 L = lcm(denom1, denom2)
        int g = gcd(denom1, denom2);
        int l = denom1 / g * denom2; // 오버플로우 방지 위해 나눗셈 먼저

        // 2) 분자 맞춰 더하기
        int numer = numer1 * (l / denom1) + numer2 * (l / denom2);
        int denom = l;

        // 3) 기약분수로 약분
        int g2 = gcd(Math.abs(numer), denom);
        numer /= g2;
        denom /= g2;

        return new int[]{numer, denom};
    }

    // 유클리드 호제법 - 최대공약수 계산 
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }
}