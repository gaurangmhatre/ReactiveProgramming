public class StockFeatcher {
    public static StockInfo fetch(String security) {
        return new StockInfo(security,YahooFinance.getPrice(security));
    }
}
