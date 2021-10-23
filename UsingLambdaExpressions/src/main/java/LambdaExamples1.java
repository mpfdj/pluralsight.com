import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaExamples1 {

    public static void main(String[] args) {

        List<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(2);
        items.add(3);
        items.add(4);

        // Classic for loop
        for (int item : items)
            System.out.println(item);

        // Passing a Method reference
        items.forEach(System.out::println);


        // Passing a Lambda
        // Pass code as an argument
        // Parameter -> Method body
        items.forEach(item -> System.out.println(item * item));

        // Using multiple statements
        items.forEach(item -> {
            int square = item * item;
            System.out.println(square);
        });


        // Let's sort a List by defining a custom Comparator with a Lambda

        // Sorting an Array with the Default String Comparator
        String[] words = {"Bye", "Hi", "Adios", "Hola", "Aloha"};
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));


        // Using a Comparator to Sort an Array using lambda here
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(Arrays.toString(words));


        // The "Old Way" using a Anonymous class
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        System.out.println(Arrays.toString(words));
    }


}
