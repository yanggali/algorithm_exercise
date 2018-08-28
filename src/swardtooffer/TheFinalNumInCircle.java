package swardtooffer;

import java.util.ArrayList;
import java.util.List;

public class TheFinalNumInCircle {
    public int TheFinalNumInCircle(int n, int m) {
        if (n == 0 || m == 0) return -1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(i);
        }
        int index = m-1;
        while (list.size() > 1){
            if (index < list.size()){
                list.remove(index);
            }
            else {
                while (index >= list.size()){
                    index -= list.size();
                }
                list.remove(index);
            }
            index += m-1;
        }
        return list.get(0);
    }
}
