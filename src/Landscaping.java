public class Landscaping extends Service {

    public int inputCost() {
        super.inputCost();

        System.out.print("Enter the cost per square foot: ");
        if (input.hasNextFloat()) {
            this.costPerSqFt = input.nextFloat();
            return 1;
        } else
            return 0;
    }

    public int inputSquareFt() {
        System.out.print("How big is the property? (in square feet) ");
        if (input.hasNextFloat()) {
            this.sqFt = input.nextFloat();
            return 1;
        } else {
            System.out.println("The value you entered in invalid.");
            return 0;
        }
    }

    public final void display() {
        super.display();
        System.out.println("Size of property" + this.sqFt);
        System.out.println("cost sq/ft: $" + this.costPerSqFt);

    }

    private float sqFt;
    private float costPerSqFt;
}
