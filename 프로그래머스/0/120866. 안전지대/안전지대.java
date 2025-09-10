import java.util.*;


class Solution {
    public int solution(int[][] board) {
        int n = board.length;

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        List<int[]> mines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    mines.add(new int[]{i, j});
                }
            }
        }

        // 각 지뢰 주변을 위험 지역으로 표시 (2로 표시)
        for (int[] mine : mines) {
            int x = mine[0];
            int y = mine[1];

            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0) {
                    board[nx][ny] = 2; // 위험 지역 표시
                }
            }
        }

        // 안전한 지역(0) 개수 세기
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    answer++;
                }
            }
        }
        
        return answer; 
    }
}