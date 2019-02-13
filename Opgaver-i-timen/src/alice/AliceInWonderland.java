package alice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AliceInWonderland {

    public static void main(String[] args) {

        // Læs fra en fil:
        File file = new File("alice.AliceInWonderland.txt");
        long start = System.currentTimeMillis();
        try {
            Scanner scanner = new Scanner(file);
            String txt = "";
            char current = ' ';
            Map<Character, Integer> map = createAlphabet();
            while (scanner.hasNextLine()){
                txt = scanner.nextLine().toLowerCase();
                for (int i = 0; i < txt.length() ; i++) {
                    current = txt.charAt(i);
                    if(current >= 'a' && current <= 'z'){
                        int tidl = map.get(current);  // den er 0 nu
                        map.put(current, tidl + 1);
                    }
                }
            }
            long stop = System.currentTimeMillis();
            long forskel = stop - start;
            System.out.println("tid: " + forskel);
            System.out.println(map.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Map<Character, Integer> createAlphabet(){
        Map<Character,Integer> map = new TreeMap<>();
        for (int i = 97; i < 123 ; i++) {
            map.put((char)i,0);
            System.out.println("Bogstav: " + (char)i);
        }
        return map;
    }


}

