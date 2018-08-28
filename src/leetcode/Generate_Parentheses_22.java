package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses_22 {
    public List<String> generateParenthesis(int n) {
        int left = 0, right = 0;
        List<String> list = new ArrayList<>();
        String str = "";
        generateParenthesisHelper(str, 0, 0, n, list);
        return list;
    }

    public void generateParenthesisHelper(String str, int start, int end, int n, List<String> res){
        if (start + end == 2*n){
            res.add(str);
            return;
        }
        if (start < n){
            generateParenthesisHelper(str + "(", start+1, end, n, res);
        }
        if (start > end){
            generateParenthesisHelper(str + ")",start, end+1, n, res );
        }
    }
}
