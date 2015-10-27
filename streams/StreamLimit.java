package streams;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Shikhar on 25/10/15.
 */
public class StreamLimit {
    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom(new byte[]{1, 3, 3, 7});
        int[] randoms = IntStream.generate(secureRandom::nextInt)
                .filter(n -> n > 0)
                .limit(10)
                .toArray();

        System.out.println(Arrays.toString(randoms));


        int[] nums = IntStream.iterate(1, n -> n * 2)
                .limit(20)
                .toArray();
        System.out.println(Arrays.toString(nums));

        System.out.println("::::::::::StringStream creation:::::::::");
        IntStream.range(0, 4).forEach(value -> {
            System.out.println("String" + value);
        });

        System.out.println("::::::::::IntStream creation:::::::::");
        IntStream.range(1, 4).forEach(System.out::println); //method referencing

        System.out.println("::::::::::mapToInt implementation:::::::::");
        Stream.of("a1", "a2", "a3")    //creating a object stream of strings
                .map(s -> s.substring(1))  //taking out the integer part from s
                .mapToInt(Integer::parseInt)
                .forEach(System.out::println);
        //.max()			// taking out the maximum of the primitive stream
        //.ifPresent(System.out::println); // printing to console if not nul


        System.out.println(":::::::::::mapToObj implementation:::::::::::");
        IntStream.of(6, 5, 7, 1, 2, 3)
                .mapToObj(n -> "StringObject" + n)
                .forEach(System.out::println);

        System.out.println("::::::::::summaryStats implementation:::::::::");
        System.out.println(
         Stream.of("a1", "a2", "a3")    //creating a object stream of strings
                 .map(s -> s.substring(1))  //taking out the integer part from s
                 .mapToInt(Integer::parseInt) //mapping to primitive stream
                 .summaryStatistics().toString()
        );

    }
}
