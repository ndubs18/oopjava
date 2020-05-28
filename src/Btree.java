public class Btree {
    public Btree() {
        root = null;
    }

    public void display() {
        if(root == null)
            return;
        else
            display(root);
    }

    private Node root;

    private void display(Node root) {
        if(root == null)
            return;

        display(root.goLeft());
        root.display();
        display(root.goRight());

    }
    public int addService(Service to_add) {
        if(root == null ) {
            root = new Node();
            root.addData(to_add);
            return 1;
        }
        else if(root.goLeft() == null && root.goRight() == null) {
            int added = root.addData(to_add);
            if(added == 1)
                return 1;
            //if there are two keys in the leaf node
            else if(added == 0) {
                //store a reference to original root node
                Node temp = root;
                //assign a new node to root
                root = new Node();
                int toPush = temp.isBetween(to_add);
                //if to_add is the key to push up
                if(toPush == 0)
                {
                    root.addData(to_add);

                    Node right = new Node();
                    right.addData(temp.getGreater());
                    temp.removeGreater();

                    root.setRight(right);
                    root.setLeft(temp);
                    return 1;
                }
                //if smaller is the key to push up
                else if(toPush == -1)
                {
                    root.addData(temp.getSmaller());
                    Node right = new Node();
                    right.addData(temp.getGreater());
                    temp.removeSmaller();
                    temp.removeGreater();
                    temp.addData(to_add);


                    root.setLeft(temp);
                    root.setRight(right);

                    return 1;
                    //if greater is the key to push up
                } else {
                    root.addData(temp.getGreater());
                    temp.removeGreater();

                    Node right = new Node();
                    right.addData(to_add);
                    root.setLeft(temp);
                    root.setRight(right);
                    return 1;
                }
            }
            return 0;
        }
        else
            return addService(root, to_add);
    }

    private int addService(Node root, Service to_add) {
        if (root == null)
            return 0;

        if(root.compare(to_add) == 1)
            addService(root.goLeft(), to_add);
        else
            addService(root.goRight(), to_add);



    }
}
