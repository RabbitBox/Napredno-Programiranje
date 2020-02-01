package mk.ukim.finki.np;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class TestPoint {
    public static void main(String[] args) {

        String s1 = "pen";
        String s2 = "pencil";

        System.out.println(IntStream.range(0,s1.length()).allMatch(i -> s1.charAt(i) == s2.charAt(i)));

        int [] array = new int[]{1,2,3,4,5};




    }
}
