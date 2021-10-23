import java.util.function.DoubleToIntFunction;
import java.util.function.IntSupplier;

public class PrimitiveLambdas {


    // You have specialized Functional interfaces for the following primitives int, long, double
    // These are optimized for performance, they dont cost performance regarding boxing and unboxing


    public static void main(String[] args) {

        IntSupplier supplier = () -> 10;
        int i = supplier.getAsInt();
        System.out.println("i = " + i);

        DoubleToIntFunction function = d -> (int) Math.floor(d);
        int pi = function.applyAsInt(Math.PI);
        System.out.println("Pi = " + pi);

    }

}
