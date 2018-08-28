package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Shopping_Offers_638 {
    public static void main(String[] args) {
        Shopping_Offers_638 temp = new Shopping_Offers_638();
        List<Integer> price = new ArrayList<Integer>(){{
           add(2);
           add(5);
        }};

        List<List<Integer>> special = new ArrayList<>();
        special.add(new ArrayList<Integer>(){{
            add(3);
            add(0);
            add(5);
        }});
        special.add(new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(10);
        }});

        List<Integer> needs = new ArrayList<Integer>(){{
            add(3);
            add(2);
        }};
        System.out.println(temp.shoppingOffers(price, special, needs));
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int minPrice = directBuy(price, needs);
        if (minPrice == 0){
            return 0;
        }
        for (int i = 0;i < special.size(); i++){
            boolean isUsed = true;
            List<Integer> newNeeds = new ArrayList<>();
            for (int j = 0;j < needs.size();j++){
                if (special.get(i).get(j) > needs.get(j)){
                    isUsed = false;
                    break;
                }
                newNeeds.add(needs.get(j) - special.get(i).get(j));
            }
            if (isUsed){
                minPrice = Math.min(minPrice, special.get(i).get(needs.size()) + shoppingOffers(price, special, newNeeds));
            }
        }
        return minPrice;
    }
    public int directBuy(List<Integer> price, List<Integer> needs){
        int totalPrice = 0;
        if (price.size() != needs.size()){
            return totalPrice;
        }
        for (int i = 0;i < needs.size();i++) {
            totalPrice += price.get(i) * needs.get(i);
        }
        return totalPrice;
    }
}
