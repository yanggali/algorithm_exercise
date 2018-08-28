package leetcode;

public class Number_of_Islands_200 {
    public static void main(String[] args) {
        Number_of_Islands_200 t = new Number_of_Islands_200();
        char[][] array = {{'1','1','1'},
                {'0','1','0'},
                {'1','1','1'},
                };
        System.out.println(t.numIslands(array));
    }
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        if (row < 0 || col < 0) return 0;
        int[][] visited = new int[row][col];

        int num = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0;j < col; j++){
                if (visited[i][j] == 0 && grid[i][j] == '1'){
                    visit(visited, grid, i,j,row,col);
                    num++;
                }
            }
        }
        return num;
    }
    public void visit(int[][] visited, char[][] array, int i, int j, int row, int col){
        if (visited[i][j] == 0 && array[i][j] == '1'){
            visited[i][j] = 1;
        }
        else return;
        if (i-1 >= 0){
            visit(visited, array, i-1, j, row, col);
        }
        if (i+1 < row){
            visit(visited, array,i+1, j, row, col);
        }
        if (j-1 >= 0){
            visit(visited, array,i, j-1, row, col);
        }
        if (j+1 < col){
            visit(visited, array,i, j+1, row, col);
        }
    }
}
