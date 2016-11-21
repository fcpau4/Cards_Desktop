package sample;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by 47276138y on 21/11/16.
 */
public class HttpUtils {

    public static String get(String dataUrl) throws IOException {
        URL url = new URL(dataUrl); //Instanciem la classe URL.
        String response = "";
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        //Fem passar la connexió per un navegador perquè si no es pensa que som un robot que vol fer peticions infinites.
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        try {

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            response = readStream(in);

        } finally {

            urlConnection.disconnect();

        }
        return response;
    }

    private static String readStream(InputStream in) throws IOException {
        InputStreamReader is = new InputStreamReader(in);
        BufferedReader rd = new BufferedReader(is);

        String line ="";
        StringBuilder response = new StringBuilder();

        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }

        rd.close();

        return response.toString();
    }
}
