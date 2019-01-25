import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StopFinder {
    private String text;

    public void findStops(int stopNum){
        System.out.println("The link for your route is : https://www.communitytransit.org/busservice/schedules/route/"+stopNum);
        HTMLGetter html = new HTMLGetter();
//Gets the HTML from the page where the stop information is located
        text = html.HTMLGetter("https://www.communitytransit.org/busservice/schedules/route/"+stopNum);

        String subText;

        Pattern subTxtFinder = Pattern.compile("<h2>Weekday<small>To(.*?)</small></h2>.*?</thead>", Pattern.DOTALL);
        Matcher matcher = subTxtFinder.matcher(text);
//Prints out the stops on the way to a destination
        while (matcher.find()){
            subText = matcher.group();
            System.out.println("Stops on the way to "+matcher.group(1)+":");
            System.out.println("***************************************");
            Pattern stopFinder = Pattern.compile("<p>(.*?)</p>");
            Matcher stopMatcher = stopFinder.matcher(subText);
            while (stopMatcher.find()){
                System.out.println(stopMatcher.group(1));
            }
            System.out.println();
        }
    }
    public StopFinder(){
    }
}
