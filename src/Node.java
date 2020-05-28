public class Node {

    public int compare(Service to_compare) {
        return this.smaller.compare(to_compare);
    }

    public int isBetween(Service to_compare) {
        if(smaller.compare(to_compare) == -1 && greater.compare(to_compare) == 1) {
            System.out.println("The new service is between");
            return 0;
        }
        else if(smaller.compare(to_compare) == 1 && greater.compare(to_compare) == 1) {
            System.out.println("The 'smaller' service is between");
            return -1;
        }
        else {
            System.out.println("The 'greater' service is between");
            return 1;
        }
    }

    public final void display() {
        if(smaller != null && greater == null)
            smaller.display();
        else if(smaller == null && greater != null)
            greater.display();
        else {
            smaller.display();
            greater.display();
        }
    }

    public int addData(Service to_add) {
        //if there are no keys in the this node
        if(smaller == null && greater == null) {
            smaller = new Service(to_add);
            return 1;
        }
        //if there is one data item in this node
        else if(smaller != null && greater == null) {
            //if the new data item is greater than the existing
            if(smaller.compare(to_add) == -1) {
                greater = new Service(to_add);
                return 1;
              //if the to_add data is smaller than the existing data
            } else {
                greater = new Service(smaller);
                smaller = new Service(to_add);
                return 1;
            }
        }
        else {
            return 0;
        }
    }

    public Service getSmaller() {
        return this.smaller;
    }

    public Service getGreater() {
        return this.greater;
    }

    public boolean removeSmaller() {
        smaller = null;
        return true;
    }

    public boolean removeGreater() {
        greater = null;
        return true;
    }

    public Node goLeft() {
        return left;
    }
    public Node goRight() {
        return right;
    }
    public void setLeft(Node to_set) {
        this.left = to_set;
    }
    public void setRight(Node to_set) {
        this.right = to_set;
    }
    public void setMiddle(Node to_set) {
        this.middle = to_set;
    }

    private Node parent;

    private Service smaller;
    private Service greater;

    private Node left;
    private Node middle;
    private Node right;
}

