package streams;

import java.util.stream.Stream;

/**
 * Created by Shikhar on 27/10/15.
 */
public class SortedExample {
    public static void main(String[] args){
        Stream.of("d2", "a2","a3","a5","a1", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    System.out.printf("compareTo value ::: %s", s1.compareTo(s2));
                    System.out.println();
                    return s2.compareTo(s1);
                })                    //.forEach(s -> System.out.println("forEach: " + s));
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }
}
