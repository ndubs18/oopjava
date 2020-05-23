public class BabySitting extends Service {

    BabySitting() {
        this.numKids = 0;
        this.costPerKid = 0;
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

    private int numKids;
    private float costPerKid;
}
