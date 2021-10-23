import java.util.ArrayList;
import java.util.List;

public class MoreLambdas {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(List.of("one", "two", "three", "four", "five"));

        strings.removeIf(s1 -> !s1.startsWith("t"));
        strings.forEach(s -> System.out.println(s));


    }

}
