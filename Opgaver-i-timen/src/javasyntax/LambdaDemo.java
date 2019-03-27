package javasyntax;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaDemo {

    public static void main(String[] args) {
        new LambdaDemo();
    }

    public LambdaDemo(){
        List<String> names = Arrays.asList("anna", "per", "olga", "hannus");

        Function<String, Boolean> filterShortNames = (name) -> name.length() > 3;

        Predicate<String> korte = (s) -> s.length() > 3;
        Consumer<String> print = (s) -> System.out.println(s);

        names.stream().filter(korte).forEach(print);

        Function<String, String> mapDouble = (s) -> s+s;
        names.stream().map(mapDouble).forEach(print);

        List<Integer> numbers = Arrays.asList(1,2,3);

        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("sum:" + numbers.stream().reduce(add).get());  // the accumulator function takes the first item from stream, and assigns to a.
        //for (String s : names) if(s.length() > 3) System.out.println(s);

        MyFunc myFunc = (a,b) -> {
            return a + b;
        };

        performCalculations(myFunc, 1, 2);
        performCalculations((int a, int b) -> a * b * 3, 1, 2);

    }

    private void performCalculations(MyFunc myFunc, int a, int b){
        System.out.println("the answer to myFunc is: " + myFunc.calc(a, b));
    }

    @FunctionalInterface interface MyFunc {
        public int calc(int a, int b);
    }

}
