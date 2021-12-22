package implementations;
import org.brotli.dec.BrotliInputStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class APIValidations {

    public static Long[] validatePokemonStats(String inputUrl)
    {

        HttpURLConnection http = null;
        try
        {
            URL url = new URL(inputUrl);
            http = (HttpURLConnection)url.openConnection();
            http.setRequestProperty("Accept", "*/*");
            http.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            http.setRequestProperty("User-Agent", "apiTest");

            //System.out.println(http.getResponseCode() +  " -----------");
            BufferedReader rd = new BufferedReader(new InputStreamReader(new BrotliInputStream(http.getInputStream() )));
            //System.out.println(rd +  " -----------");

            String jsonString = rd.lines().collect(Collectors.joining());

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject)parser.parse(jsonString);

            Long id = (Long) jsonObject.get("id");
           // System.out.println("The id is: " + id);

           // String name = (String) jsonObject.get("name");
            //System.out.println("The name is: " + name);

            String location_area_encounters = (String) jsonObject.get("location_area_encounters");
            //System.out.println("Locations: " + location_area_encounters);

            JSONArray stats = (JSONArray) jsonObject.get("stats");
            
            int num = 6;
            Long[] statsValueArray = new Long[num];
            
            for (int i = 0; i < stats.size(); i++) {
                //System.out.println("The " + i + " element of the array: " + stats.get(i));
            
                JSONObject stat = (JSONObject) stats.get(i);
                JSONObject statDetail = (JSONObject) stat.get("stat");
                //System.out.println("Stat detail: " + stat.get("base_stat"));
                //System.out.println("Stat detail: " + statDetail.get("name"));
                //System.out.println("Stat detail: " + statDetail.get("url"));

                statsValueArray[i] = (Long) stat.get("base_stat"); 
            }

            for (int i = 0; i < statsValueArray.length; i++) {
                //System.out.print(statsValueArray[i].toString());
            }
            
            
            http.disconnect();

            return statsValueArray;

        }
        catch (Exception e)
        {
            System.out.println(e + "...........");
            if (http != null)
            {
                http.disconnect();
            }
            return null;
        }

    }

    public static String[] validatePokemonAbilities(String inputUrl)
    {

        HttpURLConnection http = null;
        try
        {
            URL url = new URL(inputUrl);
            http = (HttpURLConnection)url.openConnection();
            http.setRequestProperty("Accept", "*/*");
            http.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            http.setRequestProperty("User-Agent", "apiTest");

            BufferedReader rd = new BufferedReader(new InputStreamReader(new BrotliInputStream(http.getInputStream() )));
            String jsonString = rd.lines().collect(Collectors.joining());

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject)parser.parse(jsonString);
            JSONArray abilities = (JSONArray) jsonObject.get("abilities");
            
            int num = 1;
            String[] abilitiesValueArray = new String[num];
            
            for (int i = 0; i < abilities.size(); i++) {

                JSONObject ability = (JSONObject) abilities.get(i);
                JSONObject abilityDetail = (JSONObject) ability.get("name");
                System.out.println("abilityDetail: " + abilityDetail.get("name"));


                abilitiesValueArray[i] = (String) abilityDetail.get("name"); 
            }

            for (int i = 0; i < abilitiesValueArray.length; i++) {
            }
            
            
            http.disconnect();

            return abilitiesValueArray;

        }
        catch (Exception e)
        {
            System.out.println(e + "...........");
            if (http != null)
            {
                http.disconnect();
            }
            return null;
        }

    }
}