class Opa {
    Opa() {
        System.out.println("Opas' default constructor");
    }
}

class Miel extends Opa {
    Miel () {
        System.out.println("Miels' default constructor");
    }
}

class Kim extends Miel {
    Kim() {
        System.out.println("Kims' default constructor");
    }
}



public class InheritanceTree {

    public static void main(String[] args) {
        Kim kim = new Kim();
    }

}
