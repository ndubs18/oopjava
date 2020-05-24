public class List {

    List() {
        this.root = null;
    }

    public boolean insertNode(Service to_add) {
        if(root == null)
        {
            //if the Service is a Landscaping reference, cast and create a new LandNode passing it in as a constructor
            if(to_add instanceof Landscaping)
            {
                root = new LandNode((Landscaping)to_add);
                return true;
            }
            return true;
        }
        else
            return insertNode(root, to_add);
    }

    public final void display()
    {
        if(root == null)
            return;
        else {
            display(root);
        }
    }

    //private members and methods
    private boolean insertNode(Service root, Service to_add) {
        if(root == null)
        {

            return true;
        }

        boolean rc = insertNode(root.goLeft(), to_add);
        boolean rc2 = insertNode(root.goRight(), to_add);

        return false;
    }

    private void display(Service root)
    {
        if(root == null)
            return;
        display(root.goLeft());
        root.display();
        display(root.goRight());
        return;
    }
    private Service root;
}
