import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

//This is just a helper class that gets the text from an HTML file for the other classes to use

public class HTMLGetter {
    public String HTMLGetter(String html) {
        String text = "";
        try {
            URLConnection bc = new URL(html).openConnection();
            bc.setRequestProperty("user-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            BufferedReader in = new BufferedReader(new InputStreamReader(bc.getInputStream()));
            String inputLine = "";
            while ((inputLine = in.readLine()) != null) {
                text += inputLine + "\n";
            }
            in.close();
        } catch (Exception e) { }
        return text;
    }
}
