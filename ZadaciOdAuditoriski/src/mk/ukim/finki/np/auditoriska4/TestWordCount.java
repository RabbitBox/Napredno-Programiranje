package mk.ukim.finki.np.auditoriska4;

import java.io.*;
import java.util.function.Consumer;

class Result implements Consumer<String> {
    private int characters;
    private int words;
    private int lines;

    @Override
    public void accept(String s) {
        lines++;
        words += s.split("\\s+").length;
        characters += s.length();
    }

    @Override
    public String toString() {
        return "Result{" +
                "characters=" + characters +
                ", words=" + words +
                ", lines=" + lines +
                '}';
    }
}

public class TestWordCount {
    public static void proccesFile()throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("checkMe.txt"));
        Result result = new Result();
        reader.lines().forEach(result);
        System.out.println(result.toString());
    }

    public static void main(String[] args) {

        try{
           proccesFile();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
