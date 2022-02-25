package generics;

class Util {
    public static <K, V> boolean compare(Pair2<K, V> p1, Pair2<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }
}

class Pair2<K, V> {

    private K key;
    private V value;

    public Pair2(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class GenericMethod {

    public static void main(String[] args) {
        Pair2<Integer, String> p1 = new Pair2<>(1, "apple");
        Pair2<Integer, String> p2 = new Pair2<>(2, "pear");
        boolean same = Util.compare(p1, p2);  // This feature, known as type inference, allows you to invoke a generic method as an ordinary method, without specifying a type between angle brackets. This topic is further discussed in the following section, Type Inference.
    }

}
