package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 */

public class Letter_Case_Permutation_784 {
    public static void main(String[] args) {
        Letter_Case_Permutation_784 t = new Letter_Case_Permutation_784();
        System.out.println(t.letterCasePermutation("12345"));
    }
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        if (S == null) return list;
        char[] path = new char[S.length()];
        getLetterCasePermutation(S, list, path, 0);
        return list;
    }
    public void getLetterCasePermutation(String S, List<String> list, char[] path, int index){
        if (index == S.length()){
            list.add(new String(path));
        }
        else {
            if (S.charAt(index) >='0' && S.charAt(index) <='9'){
                path[index] = S.charAt(index);
                getLetterCasePermutation(S, list, path, index+1);
            }
            else {
                path[index] = Character.toLowerCase(S.charAt(index));
                getLetterCasePermutation(S, list, path, index+1);
                path[index] = Character.toUpperCase(S.charAt(index));
                getLetterCasePermutation(S, list, path, index+1);
            }
        }
    }
}
