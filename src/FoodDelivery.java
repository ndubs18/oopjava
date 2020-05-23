public class FoodDelivery extends Service{

    public FoodDelivery()
    {
        this.mealCost = 0;
        this.distance = 0;
    }

    public int inputCost()
    {
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

    //display
    public void display() {
        System.out.println(mealCost);
        System.out.println(distance);
    }


    private float mealCost;
    private float distance;
}
