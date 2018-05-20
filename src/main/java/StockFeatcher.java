public class StockFeatcher {
    public static StockInfo fetch(String security) {
        /*if(Math.random()>0.99)
                throw new RuntimeException("OH! NO");*/

        return new StockInfo(security,YahooFinance.getPrice(security));
    }
}
