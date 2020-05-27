public class Main {
    public static void main(String args[])
    {
        Btree tree = new Btree();
        Landscaping land = new Landscaping();
        BabySitting baby = new BabySitting();
        FoodDelivery food = new FoodDelivery();

        land.inputName();
        land.inputCost();

        baby.inputName();
        baby.inputCost();

        food.inputName();
        food.inputCost();

        tree.addService(land);
        tree.addService(baby);
        tree.addService(food);
        tree.display();






    }
}
