package amazon;

public class BuySellStocks {
    public int maxProfit(int[] prices) {

        int minPrice = prices[0];

        boolean isIncreasing = false;

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < prices[i - 1]) {

                if (isIncreasing) {

                    profit = profit + prices[i - 1] - minPrice;

                }
                minPrice = prices[i];

                isIncreasing = false;

            } else {
                isIncreasing = true;
            }

        }

        if (isIncreasing) {
            profit = profit + prices[prices.length - 1] - minPrice;
        }

        return profit;
    }   
}
