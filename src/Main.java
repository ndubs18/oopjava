public class Main {
    public static void main(String args[])
    {
        Btree tree = new Btree();
        Landscaping land = new Landscaping();
        BabySitting baby = new BabySitting();
        FoodDelivery food = new FoodDelivery();

        Landscaping land2 = new Landscaping();


        land.inputName();
        land.inputCost();

        baby.inputName();
        baby.inputCost();

        food.inputName();
        food.inputCost();

        land2.inputName();
        land2.inputCost();


        tree.addService(land);
        tree.addService(baby);
        tree.addService(food);
        tree.addService(land2);
        tree.display();






    }
}
