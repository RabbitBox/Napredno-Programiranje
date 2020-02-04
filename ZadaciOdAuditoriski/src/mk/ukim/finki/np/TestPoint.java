package mk.ukim.finki.np;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class TestPoint {
    public static boolean isPalindrome(String word){
       return IntStream.range(0, word.length() / 2).allMatch(i -> word.charAt(i) == word.charAt(word.length() -1 -i));
    }

    public static void main(String[] args) {

        String s1 = "pen";
        String s2 = "pencil";

        System.out.println(IntStream.range(0,s1.length()).allMatch(i -> s1.charAt(i) == s2.charAt(i)));

        String [] mystr = new String[]{"first", "second", "paap", "other", "kappppppppppppak", "pap"};

        System.out.println(Arrays.stream(mystr).filter(TestPoint::isPalindrome).max((i,j) -> j.compareTo(i)).orElse(null));

    }
}
