package com.hantang.helix.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class WhatLambdaDemo {

    public static void process(Runnable runnable) {
        runnable.run();
    }

    public static <T> List<T> fileter(List<T> list, Predicate<T> predicate) {

        List<T> results = new ArrayList<T>();
        for (T t : list
                ) {
            if (predicate.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

    public static void main(String[] args) {

    }


    @Test
    public void lambdaSupplyDemo() {
        Double supplyResult = this.supply(() -> {
            return 110.2;
        });
        System.out.println("Allen Supply value is " + supplyResult);
    }


    @Test
    public void lambdaFunctionDemo() {
        Double result = this.function(111.23, (function) -> function + 100.2);

        System.out.println("Function Result " + result);
    }

    @Test
    public void lambdaPredicate() {
        String checkName = "Allen";
        Boolean checkResult = false;

        checkResult = this.predicate("Allen", (name) -> {
            if (name.equals(checkName)) {
                return true;
            } else {
                return false;
            }
        });

        System.out.println("Checking Result is " + checkResult);

        checkResult = this.predicate("James", (name) -> {

            if (name.equals(checkName)) {
                return true;
            } else {
                return false;
            }
        });

        System.out.println("Checking Result is " + checkResult);


    }


    @Test
    public void lambdaConsumerDemo() {

        this.consumer(110.2, (consumer) -> System.out.println("Allen Consume " + consumer + " Yuan"));
    }

    /**
     * Lambda Invoke another Method.
     * Method definition method follow the Function method
     */
    @Test
    public void lambdaMethodInvoke() {
        WhatLambdaDemo whatLambdaDemo = new WhatLambdaDemo();

        Consumer<String> consumer = whatLambdaDemo::consumerMethod;

        Consumer<String> consumer1 = WhatLambdaDemo::consuerClassInvoke;

        consumer.accept("Allen");

        consumer1.accept("James");
    }


    public static void consuerClassInvoke(String arg) {
        System.out.println("Class Method Invoke Hello World " + arg);
    }

    public void consumerMethod(String arg) {
        System.out.println("Hello World " + arg);
    }


    public Boolean predicate(String name, Predicate<String> predicate) {
        return predicate.test(name);
    }


    public Double function(Double prize, Function<Double, Double> function) {
        return function.apply(prize);
    }

    public void consumer(Double prize, Consumer<Double> consumer) {
        consumer.accept(prize);
    }

    public Double supply(Supplier<Double> supplier) {
        Double result = 1.0;
        result = supplier.get();

        return result;
    }

}
