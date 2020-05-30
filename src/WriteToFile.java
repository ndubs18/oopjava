import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteToFile {

    File file = new File("./services.txt");
    FileWriter fw = new FileWriter(file, true);
    PrintWriter pw = new PrintWriter(fw);

    public WriteToFile(Service to_write) throws IOException {

        if(to_write instanceof FoodDelivery)
        {
            FoodDelivery food = (FoodDelivery)to_write;
            pw.println(food.getName() + '|' + food.getCost() + '|' + food.getMealCost() + '|' + food.getDistance());
        }
        else if(to_write instanceof Landscaping) {
            Landscaping land = (Landscaping)to_write;
            pw.println(land.getName() + '|' + land.getCost() + '|' + land.getSqFt() + '|' + land.getCostSqFt());

        } else {
            BabySitting baby = (BabySitting)to_write;
            pw.println(baby.getName() + '|' + baby.getCost() + '|' + baby.getNumKids() + '|' + baby.getCostPerKid());
        }

        //make sure to close the file
        pw.close();


    }
}
