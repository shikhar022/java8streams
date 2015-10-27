package streams;


import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Shikhar on 20/10/15.
 */
public class CollectExample {

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        System.out.println("::::::::::test1::::::::::");
        test1(persons);
        System.out.println();
        System.out.println("::::::::::test2::::::::::");
        test2(persons);
        System.out.println();
        System.out.println("::::::::::test3::::::::::");
        test3(persons);
        System.out.println();
        System.out.println("::::::::::test4::::::::::");
        test4(persons);
        System.out.println();
        System.out.println("::::::::::test5::::::::::");
        test5(persons);
        System.out.println();
        System.out.println("::::::::::test6::::::::::");

        test6(persons);
        System.out.println();
        System.out.println("::::::::::test7::::::::::");
        test7(persons);







    }

    private static void test1(List<Person> persons) {
        List<Person> filtered =
                persons
                        .stream()
                        .filter(p -> p.name.startsWith("P"))
                        .collect(Collectors.toList());

        System.out.println(filtered);
    }

    private static void test2(List<Person> persons) {
        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.age));

        personsByAge
                .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
    }

    private static void test3(List<Person> persons) {
        Double averageAge = persons
                .stream()
                .collect(Collectors.averagingInt(p -> p.age));

        System.out.println(averageAge);     // 19.0
    }

    private static void test4(List<Person> persons) {
        IntSummaryStatistics ageSummary =
                persons
                        .stream()
                        .collect(Collectors.summarizingInt(p -> p.age));

        System.out.println(ageSummary);

    }

    private static void test5(List<Person> persons) {
        String names = persons
                .stream()
                .filter(p -> p.age >= 18)
                .map(p -> p.name)
                .collect(Collectors.joining(",  ", "In Germany ", " are of legal age."));

        System.out.println(names);

    }

    private static void test6(List<Person> persons) {
        Map<Integer, String> map = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2) -> name1 + "|" + name2)); //separator for same key

        System.out.println(map);

    }

    private static void test7(List<Person> persons) {
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),          // supplier
                        (j, person) -> j.add(person.name.toUpperCase()),  // accumulator
                        (j1, j2) -> j1.merge(j2),               // combiner
                        StringJoiner::toString);                // finisher

        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.println(names);
    }

}

