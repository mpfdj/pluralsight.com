import java.util.function.Consumer;
import java.util.function.Supplier;

public class FirstLambdas {

    public static void main(String[] args) {

        // Supplier
        Supplier<String> supplier = () -> {
            System.out.println("I'm inside the Supplier");
            return "Hello";
        };

        String string = supplier.get();
        System.out.println("string = " + string);


        // Consumer
        Consumer<String> consumer = (String s) -> {
            System.out.println("I'm inside the Consumer");
            System.out.println(s);
        };
        consumer.accept("Hello");

    }

}
