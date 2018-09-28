package leetcode;


import java.util.*;

public class Brick_Wall_554 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>(){{
            add(new ArrayList<Integer>(){{
                add(1);add(2);add(2);add(1);
            }});
            add(new ArrayList<Integer>(){{
                add(3);add(1);add(2);
            }});
            add(new ArrayList<Integer>(){{
                add(1);add(3);add(2);
            }});
            add(new ArrayList<Integer>(){{
                add(2);add(4);
            }});
            add(new ArrayList<Integer>(){{
                add(3);add(1);add(2);
            }});
            add(new ArrayList<Integer>(){{
                add(1);add(3);add(1);add(1);
            }});
        }};
        Brick_Wall_554 b = new Brick_Wall_554();
        System.out.println(b.leastBricks(list));
    }
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();

        for (List<Integer> list : wall) {
            int temp = 0;
            for (int i = 0;i < list.size()-1;i++) {
                int num = list.get(i);
                int exist = map.getOrDefault(temp + num,0)+1;
                map.put(num + temp, exist);
                temp += num;
            }
        }
        if (map.size() <= 0){
            return wall.size();
        }
        return wall.size() - Collections.max(map.values());
    }
}
