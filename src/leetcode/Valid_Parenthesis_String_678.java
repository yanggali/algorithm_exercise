package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Valid_Parenthesis_String_678 {
    public static void main(String[] args) {
        Valid_Parenthesis_String_678 v = new Valid_Parenthesis_String_678();
        System.out.println(v.checkValidString("())"));
    }
    public boolean checkValidString(String s) {
        if(s == null || s.length() < 1){
            return true;
        }
        Queue<Integer> q = new ArrayDeque<>();
        char[] array = s.toCharArray();
        if (array[0] == '('){
            q.add(1);
        }
        else if (array[0] == ')'){
            return false;
        }
        else {
            q.add(0);
            q.add(1);
        }
        for (int i = 1; i < array.length; i++) {
            int count = 0;
            int size = q.size();
            while (count < size && !q.isEmpty()) {
                int temp = ((ArrayDeque<Integer>) q).pop();
                if (array[i] == '('){
                    ((ArrayDeque<Integer>) q).offer(temp+1);
                }
                else if (array[i] == ')'){
                    if (temp > 0){
                        ((ArrayDeque<Integer>) q).offer(temp-1);
                    }
                }
                else {
                    if (temp < 1){
                        ((ArrayDeque<Integer>) q).offer(temp +1);
                        ((ArrayDeque<Integer>) q).offer(temp);
                    }
                    else {
                        ((ArrayDeque<Integer>) q).offer(temp - 1);
                        ((ArrayDeque<Integer>) q).offer(temp);
                        ((ArrayDeque<Integer>) q).offer(temp + 1);
                    }
                }
                count++;
            }
        }
        while (!q.isEmpty()) {
            int temp = ((ArrayDeque<Integer>) q).pop();
            if (temp == 0){
                return true;
            }
        }
        return false;
    }
}
