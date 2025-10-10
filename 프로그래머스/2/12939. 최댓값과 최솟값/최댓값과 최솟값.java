class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");

        int min = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int v = Integer.parseInt(String.valueOf(arr[i]));

            if (i == 0) {
                min = v;
                max = v;
            } else {
                min = Math.min(min, v);
                max = Math.max(max, v);
            }
        }

        return min + " " + max;
    }
}