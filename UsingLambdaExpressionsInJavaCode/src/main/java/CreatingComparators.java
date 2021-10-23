import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class CreatingComparators {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        Comparator<String> cmp = (s1, s2) -> s1.compareTo(s2);  // Sort in alphabetical order
        strings.sort(cmp);
        System.out.println(strings);

//        Comparator<String> cmp2 = (s1, s2) -> Integer.compare(s1.length(), s2.length());  // Sort based on length
//        strings.sort(cmp2);
//        System.out.println(strings);


//        Function<String, Integer> toLength = s -> s.length();  // Uses boxing and unboxing, use primitive alternative instead
//        Comparator<String> cmp2 = Comparator.comparing(toLength);
//        strings.sort(cmp2);
//        System.out.println(strings);



        ToIntFunction<String> toLength = s -> s.length();
        Comparator<String> cmp2 = Comparator.comparingInt(toLength);
        strings.sort(cmp2);
        System.out.println(strings);


    }


}
