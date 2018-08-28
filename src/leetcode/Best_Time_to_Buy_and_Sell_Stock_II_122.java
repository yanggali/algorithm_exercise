package leetcode;

public class Best_Time_to_Buy_and_Sell_Stock_II_122 {
    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_II_122 t = new Best_Time_to_Buy_and_Sell_Stock_II_122();
        int[] array = {7,6,4,3,1};
        System.out.println(t.maxProfit(array));
    }
    public int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        sell[0] = 0;
        buy[0] = -prices[0];
        for (int i = 1;i < prices.length;i++){
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
            buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i]);
        }
        return sell[prices.length-1];
    }
}
