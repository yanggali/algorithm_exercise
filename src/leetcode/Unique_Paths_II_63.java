package leetcode;

/**
 * 求从矩阵左上角到右下角的所有路径数量
 */
public class Unique_Paths_II_63 {
    public static void main(String[] args) {
        int[][] array = {{0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        Unique_Paths_II_63 u = new Unique_Paths_II_63();
        System.out.println(u.uniquePathsWithObstacles(array));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] paths = new int[row + 1][col + 1];
        paths[1][1] = 1-obstacleGrid[0][0];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (i == 1 && j==1) continue;
                if (obstacleGrid[i - 1][j - 1] != 1) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
                else {
                    paths[i][j] = 0;
                }
            }
        }
        return paths[row][col];
    }
}
