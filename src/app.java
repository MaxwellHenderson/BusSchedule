/*
CS 320
Assignment 1
Max Henderson
1/24/19
 */

import java.util.Scanner;

public class app {
    public static void main(String[] args){
        HTMLGetter HTML = new HTMLGetter();
        String text = HTML.HTMLGetter("https://www.communitytransit.org/busservice/schedules/");
        RouteFinder rf = new RouteFinder(text);
        StopFinder stopFinder = new StopFinder();

        String input;
//This initializes the loop, and makes sure we don't go through the loop one more time if a user wants to quit
        System.out.println("Enter a letter to search for bus routes to a destination.\n" +
                "Enter a 3 digit route number to get stops along the route.\n" +
                "Enter \"0\" to close the program.\n*************************************");
        input = userIn();
//A menu loop
//If a user enters a number, looks for the bus route with that number and calls the StopFinder class to find stops
//If a user instead enters any string, takes the first character of that string and finds bus routes
//that go to a destination that start with that letter
        while (input!="0"){
            if(input.matches("^\\d+$")){
                stopFinder.findStops(Integer.parseInt(input));
            } else {
                rf.findRoute(Character.toUpperCase(input.charAt(0)));
            }

            System.out.println("Enter a letter to search for bus routes to a destination.\n" +
                    "Enter a 3 digit route number to get stops along the route.\n" +
                    "Enter \"0\" to close the program.\n*************************************");
            input = userIn();
        }
    }
    static public String userIn(){
        Scanner reader = new Scanner(System.in);
        return reader.next();
    }
}
