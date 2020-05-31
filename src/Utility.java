/* Nick Winkler -- CS202 -- Fant -- Utility.java
* This file holds the class interface for our Utility class.
* This class's purpose is to provide I/O operations between the client and program*/
import java.util.Scanner;
//Class for user input
public class Utility {
    //scanner object
    protected Scanner input;
    //constructor
    public Utility() {
        //initialize the scanner object with the input stream
        input = new Scanner(System.in);
    }

}
