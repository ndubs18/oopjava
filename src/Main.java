/* Nick Winkler -- CS202 -- Fant -- Main.java
* This class/file holds the primary calling routine for our program. The client is presented
* with a menu where they have 3 different actions to choose from. The user is able to continue
* to manage service until they instruct that they are finished. Every new service created will be written
* to the external file services.txt */
import java.io.IOException;
import java.util.Scanner;
public class Main {

    public static void main(String args[]) throws IOException {

        //for user input
        Scanner input;
        input = new Scanner(System.in);

        Btree tree = new Btree();

        String tempR;
        char response = '\0';
        int pick = 0;

        System.out.println("Hello, today we are going to be managing a list of different freelance services that people are" +
                " offering during the quarantine.");
        do {
            System.out.println("(1) Add a new service");
            System.out.println("(2) Retrieve a service");
            System.out.println("(3) Display Services");

            System.out.print("Enter a number that corresponds to the action you want to make: ");
            pick = input.nextInt();

            switch (pick) {
                case 1: {
                    System.out.println("\n What kind of service would you like to add?");
                    System.out.println("(1) Food Delivery");
                    System.out.println("(2) Landscaping");
                    System.out.println("(3) Babysitting");
                    System.out.print("Enter a number that corresponds to the service you want to create: ");
                    pick = input.nextInt();

                    switch(pick) {
                        case 1: {
                            FoodDelivery food = new FoodDelivery();
                            food.inputName();
                            food.inputCost();
                            food.inputDistance();

                            tree.addService(food);

                            WriteToFile write = new WriteToFile(food);

                            break;
                        }
                        case 2: {
                            Landscaping land = new Landscaping();
                            land.inputName();
                            land.inputCost();
                            land.inputSquareFt();

                            tree.addService(land);
                            WriteToFile write = new WriteToFile(land);
                            break;
                        }

                        case 3: {
                            BabySitting baby = new BabySitting();
                            baby.inputName();
                            baby.inputCost();
                            baby.inputNumKids();

                            tree.addService(baby);
                            WriteToFile write = new WriteToFile(baby);
                            break;
                        } default: System.out.println("The menu choice you entered was invalid");
                    }
                    break;
                }
                case 2: {
                    String name;
                    System.out.print("Enter a name of a service that you want to retrieve: ");
                    name = input.next();

                    float cost;
                    System.out.print("Enter the cost of that service: ");
                    cost = input.nextFloat();

                    Service retrieved = tree.retrieveByName(name,cost);

                    retrieved.display();
                    break;
                }

                case 3: {
                    tree.display();
                    break;
                } default: System.out.println("The number you entered was invalid");
            }

            System.out.print("Would you like to do something else?: ");
            tempR = input.next();
            response = tempR.charAt(0);
        }while(response == 'Y' || response == 'y');





    }
}
