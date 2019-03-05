package threads;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {


    Map<String, String> cprRegister = new TreeMap<>();
    public static void main(String[] args) {
        new MapDemo().runCpr();
    }

    private void runCpr(){
        cprRegister.put("9234", "jon");
        cprRegister.put("9176", "gustav");
        cprRegister.put("4321", "felix");
        cprRegister.put("5432", "jonathan"); //??  den overskriver den tidligere værdi

        for (Map.Entry<String,String> entry: cprRegister.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
