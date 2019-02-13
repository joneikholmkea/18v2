import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int tal = 3;
        String name = "ole";
        List<String> navne = new ArrayList<>();
        List<String> navne2 = new LinkedList<>();

        Map<Integer,String> map = new HashMap<>(); // nøgler er usorteret
        map.put(4, "fire");
        map.put(5, "fem");

        Map<Integer,String> map2 = new TreeMap<>();// nøgler er sorteret


        createAlphabet();

    }

    public static void createAlphabet(){
        for (int i = 97; i < 123 ; i++) {
            System.out.println("Bogstav: " + (char)i);
        }
    }
}
