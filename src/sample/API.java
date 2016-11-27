package sample;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 47276138y on 21/11/16.
 */
public class API {

    private static final String BASE_URL = "https://api.magicthegathering.io/v1/cards";

   private static ArrayList<Card> jsonProcess(String jsonResponse) throws JSONException {

        ArrayList<Card> cartes = new ArrayList<>();

        JSONObject info = new JSONObject(jsonResponse);
        JSONArray jsonCartes = info.getJSONArray("cards");


        for (int i = 0; i < jsonCartes.length() ; i++) {

            JSONObject jsonCard =  jsonCartes.getJSONObject(i);


            Card c = new Card();

            c.setName(jsonCard.getString("name"));
            if(jsonCard.has("type")) {
                c.setTipus(jsonCard.getString("type"));
            }

            c.setImgURL(jsonCard.getString("imageUrl"));

            if(jsonCard.has("colors")){

                String total_colors="";
                JSONArray color = jsonCard.getJSONArray("colors");

                for (int j = 0; j < color.length(); j++) {

                    total_colors += color.get(j).toString() + ",";
                }

                c.setColor(total_colors.substring(0, total_colors.length()-1));

            }else{
                c.setColor("");
            }

            if(jsonCard.has("rarity")) {
                c.setRarity(jsonCard.getString("rarity"));
            }

            cartes.add(c);
        }
        return cartes;
    }



    private static ArrayList<Card> doCall(String url) throws IOException {
        String JsonResponse = HttpUtils.get(url);
        try {
            return jsonProcess(JsonResponse);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ArrayList<Card> getCartes() throws IOException {
        return doCall(BASE_URL);
    }



    public static ArrayList<Card>getCardsByColor(String color) throws IOException {
        return doCall(BASE_URL + "?colors=" + color );
    }



    public static ArrayList<Card>getCardsByRarity(String rarity) throws IOException {
        return doCall(BASE_URL + "?rarity=" + rarity);
    }


}
