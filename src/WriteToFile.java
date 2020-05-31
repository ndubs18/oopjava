/* Nick Winkler -- CS202 -- Fant -- WriteToFile.java
* This file holds the class interface for our WriteToFile class*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//Class for writing to an external .txt file
public class WriteToFile {

    File file = new File("./services.txt");
    FileWriter fw = new FileWriter(file, true);
    PrintWriter pw = new PrintWriter(fw);

    public WriteToFile(Service to_write) throws IOException {
        //Service to_write is a FoodDelivery reference
        if(to_write instanceof FoodDelivery)
        {
            FoodDelivery food = (FoodDelivery)to_write;
            pw.println(food.getName() + '|' + food.getCost() + '|' + food.getMealCost() + '|' + food.getDistance());
        }
        //Service to_write is a Landscaping reference
        else if(to_write instanceof Landscaping) {
            Landscaping land = (Landscaping)to_write;
            pw.println(land.getName() + '|' + land.getCost() + '|' + land.getSqFt() + '|' + land.getCostSqFt());
        //Service to_write is a BabySitting reference
        } else {
            BabySitting baby = (BabySitting)to_write;
            pw.println(baby.getName() + '|' + baby.getCost() + '|' + baby.getNumKids() + '|' + baby.getCostPerKid());
        }

        //make sure to close the file
        pw.close();
    }
}
