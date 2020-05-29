public class Node {

    public int compare(Service to_compare) {
        if(greater == null)
        {
            if(smaller.compare(to_compare) == 1)
                return -1;
            else
                return 1;
        } else {
            if(smaller.compare(to_compare) == 1)
                return -1;
            else if(greater.compare(to_compare) == -1)
                return 1;
            else if(smaller.compare(to_compare) == -1 && greater.compare(to_compare) == 1)
                return 2;
        }

        return 0;
    }

    public int compare(float cost) {
        if(greater == null)
        {
            if(smaller.compare(cost) == 1)
                return -1;
            else
                return 1;
        } else {
            if(smaller.compare(cost) == 1)
                return -1;
            else if(greater.compare(cost) == -1)
                return 1;
            else if(smaller.compare(cost) == -1 && greater.compare(cost) == 1)
                return 2;
        }

        return 0;
    }

    public int compareName(String to_compare)
    {
        if(smaller == null)
            return 0;
        else {
            if(to_compare.equals(smaller.getName()) == true)
                return 1;
            else if(greater != null && to_compare.equals(greater.getName()) == true)
                return 2;
            else
                return 0;
        }
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
                smaller = null;
                smaller = new Service(to_add);
                return 1;
            }
        }
        else {
            return 0;
        }
    }

    public Node getParent() {
        if(this.parent == null)
            return null;
        else
            return this.parent;
    }
    public void addParent(Node to_add)
    {
        this.parent = to_add;
    }
    public Service getSmaller() {
        if(this.smaller == null)
            return null;
        else
            return this.smaller;
    }

    public Service getGreater() {
        if(this.greater == null)
            return null;
        else
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
    public Node goMiddle() {
        return this.middle;
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

