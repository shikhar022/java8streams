package streams;

import java.util.stream.Stream;

/**
 * Created by Shikhar on 27/10/15.
 */
public class OrderExample {

    public static void main(String[] args){
        System.out.println(":::::test1:::::");
        test1();
        System.out.println();

        System.out.println(":::::test2:::::");
        test2();
        System.out.println();
    }

    public static void test1(){
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

    public static void test2(){
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

}
