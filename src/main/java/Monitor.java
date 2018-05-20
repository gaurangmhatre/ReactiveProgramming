import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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

        //Approach 1
        //feed.subscribe(System.out::println, System.out::println, ()-> System.out.println("--Done--")); // 1. DATA CHANNEL, 2. ERROR CHANNEL 3. COMPLETED CHANNEL

        //Approach2
        feed.subscribe(new Subscriber<StockInfo>() {
            @Override
            public void onCompleted() {
                System.out.println("--DONE--");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error occured");
                System.out.println(throwable);
            }

            @Override
            public void onNext(StockInfo stockInfo) {
                System.out.println(stockInfo);

                /*if(stockInfo.ticker=="AAPL" && stockInfo.price>0.5){
                    System.out.println("Ready to trade. No more data needed.");
                    unsubscribe();
                }*/

            }
        });

        //Approach 3 with Schedulers on Client side
        /*feed.subscribeOn(Schedulers.io()) //JRE will handle number of threads to create
                .subscribe(Monitor::printStockInfo);

        try{ Thread.sleep(1000); }catch(Exception e){e.printStackTrace();}*/

    }

    public static void printStockInfo(StockInfo stockInfo ){
        System.out.println("Thread : "+ Thread.currentThread()); //print thread id op: Thread : Thread[RxIoScheduler-2,5,main]
        System.out.println(stockInfo);
    }




}
