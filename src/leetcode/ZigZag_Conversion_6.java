package leetcode;

import javax.xml.bind.SchemaOutputResolver;

public class ZigZag_Conversion_6 {
    public static void main(String[] args) {
        ZigZag_Conversion_6 zz = new ZigZag_Conversion_6();
        System.out.println(zz.convert("ABC",2));
    }
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() ==1) return s;
        char[] array = s.toCharArray();
        char[][] matrix = new char[numRows][s.length()/2+1];
        int row = 0, col = 0, count = 0;
        boolean flag = true;
        //用一个二维数组存放字符串锯齿形形式，根据情况确定row和col的值
        for (int i = 0; i < array.length; i++) {
            matrix[row][col] = array[i];
            count++;
            if (flag){
                row++;
            }
            else {
                row--;
            }
            if (row == numRows-1 || row == 0){
                flag = !flag;
            }
            if (count / numRows != 0){
                col++;
                if (count == 2*numRows-2){
                    count = 0;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != '\0'){
                    sb.append(matrix[i][j]);
                }
            }
        }
        return sb.toString();
    }
}
