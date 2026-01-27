package org.example.lambda;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class Demo01 {
//    public static void main(String[] args) {
//        //如果这个匿名内部类是一个接口，并且这个接口中只有一个抽象方法需要重写，那就可以简化
//        //不关注是哪个接口，不关注那个唯一的抽象方法名，只关注方法的参数（具体操作的数据）和方法体（具体做了哪些操作），
//        //需要在数据和操作之间加一个箭头
//        new Thread(() -> System.out.println("新县城中run方式被执行了")
//        ).start();
//    }


//    public static int calculateNum(IntBinaryOperator operator) {
//        int a = 10;
//        int b = 20;
//        return operator.applyAsInt(a, b);
//    }
//
//    public static void main(String[] args) {
//        int i = calculateNum(Integer::sum
//        );
//        System.out.println(i);
//    }

//    public static void printNum(IntPredicate predicate) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        for (int i : arr) {
//            if (predicate.test(i)) {
//                System.out.println(i);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        printNum(value -> value % 2 == 0
//        );
//    }

//    public static <R> R typeConver(Function<String, R> function) {
//        String str = "1235";
//        R result = function.apply(str);
//        return result;
//    }
//
//    public static void main(String[] args) {
//        Integer i = typeConver(Integer::parseInt);
//        System.out.println(i);
//
//        String s = typeConver(s1 -> s1 + "朱兴宇");
//        System.out.println(s);
//    }

//    public static void foreachArr(IntConsumer consumer) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        for (int i : arr) {
//            consumer.accept(i);
//        }
//    }
//
//    public static void main(String[] args) {
//        foreachArr(System.out::println);
//    }
}
