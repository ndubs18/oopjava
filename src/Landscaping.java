/* Nick Winkler -- CS202 -- Fant -- Landscaping.java
* This file holds the class interface for our Landscaping class*/
public class Landscaping extends Service {

    public Landscaping() {
        this.sqFt = 0;
        this.costPerSqFt = 0;
    }

    public Landscaping(Landscaping to_copy) {
        super(to_copy);
        this.sqFt = to_copy.sqFt;
        this.costPerSqFt = to_copy.costPerSqFt;

    }
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

    public void display() {
        super.display();
        System.out.println("Size of property: " + this.sqFt + "sqFt");
        System.out.println("cost sq/ft: $" + this.costPerSqFt);

    }

    //getters
    public float getSqFt() {
        return this.sqFt;
    }
    public float getCostSqFt() {
        return this.costPerSqFt;
    }

    private float sqFt;
    private float costPerSqFt;
}
