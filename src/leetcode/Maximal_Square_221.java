package leetcode;

/**
 * dp
 */
public class Maximal_Square_221 {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        Maximal_Square_221 m = new Maximal_Square_221();
        System.out.println(m.maximalSquare(matrix));
    }
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] max = new int[row + 1][col + 1];
        int res = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i-1][j-1] == '1') {
                    max[i][j] = Math.min(max[i - 1][j], Math.min(max[i][j - 1], max[i - 1][j - 1])) + 1;
                    res = Math.max(res, max[i][j] * max[i][j]);
                }
            }
        }
        return res;
    }
}
