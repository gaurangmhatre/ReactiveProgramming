import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import rx.Observable;
import rx.functions.Action1;

import java.util.Arrays;
import java.util.List;

public class Monitor {
    public static void main(String[] args) {
        System.out.println("Hello World!!");

        List<String> securities = Arrays.asList("GOOL","AAPL","MSFT","INTC");
        System.out.println(securities.toString());
        System.out.println();


        Observable<StockInfo> feed = StockServer.getFeed(securities);
        System.out.println("Got Observable");

        feed.subscribe(System.out::println);

    }





}
