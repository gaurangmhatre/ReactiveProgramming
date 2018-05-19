import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ImperativeVsFunctional {
    public static void main(String[] args) {
        System.out.println("Hello World!!");

        List<String> securities = Arrays.asList("GOOL","AAPL","MSFT","INTC");

        System.out.println(securities.toString());
        System.out.println();

        printLowerCaseSymbols(securities);
        printLowerCaseSymbolsWithStream(securities);
    }

    //---Imperative way to make the symbols lower case
    public static void printLowerCaseSymbols(List<String> securities){
        List<String> lowercaseSecurities = new ArrayList<>(); // creating temp variables along the way
        for(String security: securities){
            lowercaseSecurities.add(security.toLowerCase());
        }
        System.out.println("--Loser way to print lower case securities--");
        System.out.println(lowercaseSecurities.toString());
    }

    //---Better way to print lower case symbols with functional programming
    // --FP advantages >> 1. Immutability 2. Higher order functions
    //---Lets enjoy function pipe line & lazy evaluation
    public static void printLowerCaseSymbolsWithStream(List<String> securities){
        System.out.println("--Little better way to print lower case securities--");
        //securities.stream()
        //        .map(String::toLowerCase)
        //        .forEach(System.out::println);

        System.out.println(
                securities.stream()
                        .map(String::toLowerCase)
                        .collect(toList()));
    }

}
