import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RouteFinder{
    private String text;
    public void findRoute(char city){
        Pattern routePatter = Pattern.compile("^\\s*<option value=\"([0-9]{3}.*)\">[0-9]{3}.* - .*to ("+city+".*)</option>$",Pattern.MULTILINE);
        Matcher matcher = routePatter.matcher(text);
//Uses an ArrayList to sort the results of destinations, so as to print all destinations in the same block
        ArrayList<String[]> routes=new ArrayList<String[]>();
        while(matcher.find()){
            routes.add(new String[]{matcher.group(1),matcher.group(2)});
        }
        String last="";
        for(String[] s:routes){
            if(!last.equals(s[1])){
                if(!last.equals(""))
                    System.out.println("+++++++++++++++++++++++++++");
                last=s[1];
                System.out.println("routes to "+s[1]);
            }
            System.out.println("Route Number: " + s[0] + " to " + s[1]);
        }
    }
    RouteFinder(String text){
        this.text = text;
    }
}