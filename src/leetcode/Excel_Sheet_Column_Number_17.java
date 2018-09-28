package leetcode;

public class Excel_Sheet_Column_Number_17 {
    public static void main(String[] args) {
        Excel_Sheet_Column_Number_17 t = new Excel_Sheet_Column_Number_17();
        System.out.println(t.titleToNumber("AB"));
    }
    public int titleToNumber(String s) {
        if (s == null) return 0;
        char[] array = s.toCharArray();
        int num = 0,sum = 0;
        for (int i = 0; i < array.length; i++) {
            num = array[i]-'A'+1;
            sum = sum*26+num;
        }
        return sum;
    }
}
