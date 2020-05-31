/* Nick Winkler -- CS202 -- Fant -- FoodDelivery.java
 * This file holds the class interface for our Landscaping class*/

public class FoodDelivery extends Service{

    public FoodDelivery()
    {
        this.mealCost = 0;
        this.distance = 0;
    }
    public FoodDelivery(FoodDelivery to_copy) {
        super(to_copy);
        this.mealCost = to_copy.mealCost;
        this.distance = to_copy.distance;
    }

    public int inputCost()
    {
        super.inputCost();
        System.out.print("How much will the meal cost?: ");

        if(input.hasNextFloat())
        {
            this.mealCost = input.nextFloat();
            input.nextLine();
            return 1;
        }
        else {
            System.out.println("The value you entered was invalid");
            return 0;
        }
    }

    public int inputDistance() {
        System.out.print("What is the distance traveled for this delivery?: ");
        distance = input.nextFloat();
        return 1;
    }

    //display
    public void display() {
        super.display();
        System.out.println("Meal Cost: " + mealCost);
        System.out.println("Distance Travelled: " + distance);
    }

    //getters
    public float getMealCost() {
        return this.mealCost;
    }
    public float getDistance() {
        return this.distance;
    }

    private float mealCost;
    private float distance;
}
