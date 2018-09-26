package leetcode;

/**
 * 买卖价格的最佳时间，每次最多可以交易两次，一次交易包括一次买和一次卖，每次卖之前必须买
 */
public class Best_Time_to_Buy_and_Sell_Stock_III {
    public int maxProfit(int[] prices) {
        int b1 = Integer.MIN_VALUE,b2=Integer.MIN_VALUE;
        int s1 = 0,s2 = 0;
        for (int i = 0; i < prices.length; i++) {
            b1 = Math.max(b1, -prices[i]);
            s1 = Math.max(s1, b1+prices[i]);
            b2 = Math.max(b2, s1 - prices[i]);
            s2 = Math.max(s2, b2 + prices[i]);
        }
        return s2;
    }
}
