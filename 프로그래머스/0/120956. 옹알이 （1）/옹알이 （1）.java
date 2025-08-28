import java.util.Arrays;

class Solution {
    public int solution(String[] babbling) {
        return (int) Arrays.stream(babbling)
                .map(s -> s.replaceAll("(aya|ye|woo|ma)", ""))
                .filter(s -> s.equals(""))
                .count();
    }
}