public class Node {

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

    public int addData(Service to_add) {
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

    private Service smaller;
    private Service greater;

    private Node left;
    private Node middle;
    private Node right;
}

