package leetcode;

public class Best_Time_to_Buy_and_Sell_Stock_121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2){
            return 0;
        }
        int minPrice = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length;i++){
            if (prices[i] > minPrice) {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
            else {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
