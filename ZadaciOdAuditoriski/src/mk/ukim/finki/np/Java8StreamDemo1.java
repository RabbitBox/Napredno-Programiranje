package mk.ukim.finki.np;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class Java8StreamDemo1 {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);

        /** we are trying to implement / explain this code, step by step */
        //System.out.println( values.stream().map(i -> i * 2).reduce(0,((i, j) -> i + j)) );

        Function<Integer, Integer> f = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*2;
            }
        };

        BinaryOperator<Integer> b = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer i, Integer j) {
                return i + j;
            }
        };

        Stream<Integer> s = values.stream();

        Stream<Integer> s1 = s.map(f);

        Integer result = s1.reduce(0,b);
        System.out.println(result);

    }
}