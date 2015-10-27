package streams;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by ttnd on 27/10/15.
 */
public class SupplierExample {
    public static void main(String[] args){

        Supplier<Stream<String>> streamSupplier = () -> Stream.of("d2", "a2", "b1", "b3", "c")
                                                    .filter(s -> s.startsWith("a"));

        //checks if there is any match with prefix 'b'
        System.out.println(streamSupplier.get().anyMatch(s -> s.startsWith("b")));

        //checks if there is no match with prefix 'b'
        System.out.println(streamSupplier.get().noneMatch(s -> s.startsWith("b")));
    }
}
