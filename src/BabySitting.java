/* Nick Winkler -- CS202 -- Fant -- BabySitting.java
* This file holds the class interface for our BabySitting class*/
public class BabySitting extends Service {

    public BabySitting() {
        this.numKids = 0;
        this.costPerKid = 0;
    }

    public BabySitting(BabySitting to_copy) {
        super(to_copy);
        this.numKids = to_copy.numKids;
        this.costPerKid = to_copy.costPerKid;
    }
    public int inputCost() {

        super.inputCost();

        System.out.print("How much will you charge per kid?: ");
        if(input.hasNextFloat()) {
            this.costPerKid = input.nextFloat();
            return 1;
        } else
            return 0;
    }

    public int inputNumKids()
    {
        System.out.print("How many kids will you be babysitting?: ");
        if(input.hasNextInt())
        {
            numKids = input.nextInt();
            return 1;
        } else {
            System.out.println("The value you entered was invalid");
            return 0;
        }
    }

    public void display()
    {
        super.display();
        System.out.println("Number of kids: " + numKids);
        System.out.println("Cost per kid $" + costPerKid);

    }

    public int getNumKids() {
        return this.numKids;
    }
    public float getCostPerKid() {
        return this.costPerKid;
    }

    private int numKids;
    private float costPerKid;
}
