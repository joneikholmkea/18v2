import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WhereAmI {
    public static void main(String[] args) {
        System.out.println("starting...");
        String location = "";
        JSONObject jsonObject = null;
        String mapLink = "";
        // test case:
        location = getData("");
        try {
            jsonObject = new JSONObject(location);
            System.out.println("you are near the city:");
            System.out.println(jsonObject.getString("city"));

            mapLink = "https://www.google.com/maps/@" + jsonObject.getString("loc");
            System.out.println(mapLink);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static String getData(String ip){
        URL url ;
        String response = "";
        if(!ip.equals("")) ip = "/" + ip;
        String a = "https://ipinfo.io"+ ip + "/json";
        try {
            url = new URL(a);
            URLConnection urlConnection = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputline;
            while((inputline = br.readLine())!=null){
                response += inputline;
            }
            br.close();

        }catch (Exception e){

        }

        return response;
    }
}
