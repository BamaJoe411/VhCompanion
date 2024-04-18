package hibi.vhcompanion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class PostRequest {

    public static String sendPost(String name) throws IOException, MalformedURLException {
        URL url = new URL("https://uovh.net:5000/api");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);

        String json = "{\"username\":\"" + name + "\",\"key\":\"123mykey\"}";
        byte[] out = json.getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        OutputStream os = http.getOutputStream();
        os.write(out);
        os.flush();
        os.close();

        int responseCode = http.getResponseCode();
        if(responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
            String response = in.readLine();
            in.close();

            return response;
        } else {
            return "Error";
        }
    }
}