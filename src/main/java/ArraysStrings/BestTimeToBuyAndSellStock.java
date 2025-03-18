package ArraysStrings;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int [] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices){
        int maior = Integer.MIN_VALUE;
        int profit;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                profit = prices[j] - prices[i];
                if(profit > maior){
                    maior = profit;
                }
            }
        }
        return maior;
    }
}
