
public class Service extends Utility {
    //default constructor
    public Service() {
        this.name = null;
        this.cost = 0;
    }

    //copy constructor
    public Service(final Service to_copy)
    {
        this.name = to_copy.name;
        this.cost = to_copy.cost;
    }

    //constructor
    public Service(String name, float cost) {
        this.name = name;
        this.cost = cost;
    }

    /*inputName() takes no arguments and will take user input and store the value into the name data member.

    */
    public int inputName() {
        System.out.print("Please enter the name of the service listing: ");
        if(input.hasNext()) {
            this.name = input.nextLine();
            return 1;
        } else {
            System.out.println("The value you entered is invalid");
            return 0;
        }

    }

    /*Takes no args and prompts the user to input the cost of the service. When the value is stored in
    the cost data member, return a 1. If the user input is not a floating point value, return a 0 */
    public int inputCost()
    {
        System.out.print("Enter the cost of this service: ");
        if(input.hasNextFloat()) {
            this.cost = input.nextFloat();
            input.nextLine();
            return 1;
        } else {
            System.out.println("The value you entered for the cost was invalid");
            return 0;
        }
    }
    //display
    public void display() {
        System.out.println("Listing Name: " + this.name);
        System.out.println("Total Cost: " + this.cost);
    }

    protected Service goLeft() {
        return null;
    }
    protected Service goRight() {
        return null;
    }

    protected void setLeft(Service to_set) {
    }

    protected void setRight(Service to_set)
    {
    }

    //PRIVATE DATA MEMBERS //
    private String name;
    private float cost;

}


