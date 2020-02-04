package mk.ukim.finki.np.auditoriska4;

import mk.ukim.finki.np.TestPoint;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NajdolgPalindrom {          // This is all that matters in this task
    public static boolean isPalindrome(String word){
        return IntStream.range(0, word.length() / 2).allMatch(i -> word.charAt(i) == word.charAt(word.length() -1 -i));
    }

    public static void main(String[] args) {
        String [] mystr = new String[]{"first", "second", "paap", "other", "kappppppppppppak", "pap"};

        System.out.println(Arrays.stream(mystr).filter(TestPoint::isPalindrome).max((i, j) -> j.compareTo(i)).orElse(null));
    }
}
