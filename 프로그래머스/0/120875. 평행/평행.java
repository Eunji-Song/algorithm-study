class Solution {
     /**
     *  점선 연결 경우의 수
     *  (A,B) VS (C,D)
     *  (A,C) VS (B,D)
     *  (A,D) VS (B,C)
     */
    public int solution(int[][] dots) {

        int[] A = dots[0];
        int[] B = dots[1];
        int[] C = dots[2];
        int[] D = dots[3];

        
        if (getSlope(A, B) == getSlope(C, D)) return 1;
        if (getSlope(A, C) == getSlope(B, D)) return 1;
        if (getSlope(A, D) == getSlope(B, C)) return 1;

        return 0;
    }

    // 기울기 계산
    public double getSlope(int[] dot1, int[] dot2) {
        if (dot1[0] == dot2[0]) return 1; 
        return (double) (dot1[1] - dot2[1]) / (dot1[0] - dot2[0]);
    }
}