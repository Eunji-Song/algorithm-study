class Solution {
    public int[] solution(int num, int total) {
        // 가능한 시작값의 범위 설정
        int minStart = total / num - num;
        int maxStart = total / num + num;

        System.out.println("minStart = " + minStart);
        System.out.println("maxStart = " + maxStart);

        for (int start = minStart; start <= maxStart; start++) {
            int sum = 0;
            for (int i = 0; i < num; i++) {
                sum += start + i;
            }

            if (sum == total) {
                int[] answer = new int[num];
                for (int i = 0; i < num; i++) {
                    answer[i] = start + i;
                }
                return answer;
            }
        }

        return new int[]{}; 
    }
}