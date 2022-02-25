package generics;

//https://docs.oracle.com/javase/tutorial/java/generics/types.html

interface Pair1<K, V> {
    public K getKey();
    public V getValue();
}

class OrderedPair<K, V> implements Pair1<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey()	{ return key; }
    public V getValue() { return value; }
}


public class GenericClass {
    public static void main(String[] args) {
        OrderedPair<String, Integer> p1 = new OrderedPair<>("Even", 8);
        OrderedPair<String, String>  p2 = new OrderedPair<>("hello", "world");
    }
}
