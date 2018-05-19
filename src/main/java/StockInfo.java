public class StockInfo {
    public final String ticker;
    public final double price;

    public StockInfo(final String ticker, final double price) {
        this.ticker = ticker;
        this.price = price;
    }

    public String toString(){
        return String.format("Symbol : %s, Price : %d",this.ticker,this.price);
    }
}

