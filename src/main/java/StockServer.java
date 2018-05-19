import java.util.List;
import rx.Observable;
import rx.Subscriber;

public class StockServer {
    public static Observable<StockInfo> getFeed(List<String> securities) {
        return Observable.create(subscriber -> processRequest(subscriber,securities));
    }

    private static void processRequest(Subscriber<? super StockInfo> subscriber, List<String> securities) {
        System.out.println("Processing...");

        /*while(true){
            for (String security: securities){
                subscriber.onNext(StockFeatcher.fetch(security));
            }
        }*/

        //optimized
        while(true) {
            securities.stream()
                    .map(StockFeatcher::fetch)
                    .forEach(subscriber::onNext);
        }

    }
}
