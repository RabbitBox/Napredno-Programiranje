package mk.ukim.finki.np.auditoriska4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String line) {
        String [] parts = line.split("\\s+");
        this.name = parts[0];
        this.age = Integer.parseInt(parts[1]);
    }

    @Override
    public int compareTo(Person person) {
        return this.age - person.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TestOldestPerson {
    public static void main(String[] args) throws IOException {
        File file = new File("persons.txt");
        BufferedReader br = null;
        try {
            br =  new BufferedReader(new FileReader("persons.txt"));
            List<Person> personList = br.lines().map(i -> new Person(i)).collect(Collectors.toList());
            Collections.sort(personList, Collections.reverseOrder());
            System.out.println(personList.get(0));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
