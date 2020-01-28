package mk.ukim.finki.np;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8StreamDemo2 {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(12,20,35,46,55,68,75);


        //Sum of elements divisible by 5
        System.out.println(values.stream().filter(i -> (i % 5 == 0)).reduce(0,((i,j) -> i+j)));

        //Find the first element divisible by 5
        System.out.println(values.stream()
                                .filter(i -> (i % 5 == 0))
                                .findFirst()
                                .orElse(0));

        /**Find the smallest in the list
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
               return integer - t1;
            }
        };*/
        System.out.println(values.stream().min((i,j) -> i - j).orElse(0));

        /** Other way to find the smallest, it wont work cz the stream is alredy used in the code above*/
        IntStream.of(values.stream().mapToInt(i->i).toArray()).min().ifPresent(System.out::println);

        /** Other way to find the smallest*/
        System.out.println(IntStream.of(values.stream().mapToInt(i->i).toArray()).min().orElse(1));




    }

}
