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
        //if(root.goMiddle() != null)
            //display(root.goMiddle());
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

                    //attach the parent pointer to root in the node
                    right.addParent(root);
                    temp.addParent(root);
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

                    right.addParent(root);
                    temp.addParent(root);

                    return 1;
                    //if greater is the key to push up
                } else {
                    root.addData(temp.getGreater());
                    temp.removeGreater();

                    Node right = new Node();
                    right.addData(to_add);
                    root.setLeft(temp);
                    root.setRight(right);

                    right.addParent(root);
                    temp.addParent(root);
                    return 1;
                }
            }
            return 0;
        }
        else {

            return addService(root, to_add);
        }
    }

    private int addService(Node root, Service to_add) {
        if (root == null)
            return 0;

        int compare = root.compare(to_add);
        //go left
        if(compare == -1)
            addService(root.goLeft(), to_add);
        else if(compare == 2) {
            addService(root.goMiddle(), to_add);
        } else {
            addService(root.goRight(), to_add);
        }

        int added = root.addData(to_add);
        //TODO:why is this being run twice???
        if(added == 1) {
            return 1;
        }
        else if(added == 0)
        {
            int between = root.isBetween(to_add);
            //get the parent of the leaf node
            Node parent = root.getParent();

            //if the leaf node already has two keys
            if(between == 0) {
                int addToParent = parent.addData(to_add);
                //if the parent already has two keys
                if(addToParent == 0)
                {
                    //find what service is in the middle
                    int parBetween = parent.isBetween(to_add);
                    //if to_add needs to be pushed down
                    if(parBetween == 0) {
                        Node middle = new Node();
                        parent.setMiddle(middle);

                        middle.addData(to_add);
                        middle.addParent(parent);

                        return 1;
                    }
                    //if the smaller item in the parent needs to be pushed down
                    else if(parBetween == -1) {
                        Node middle = new Node();
                        parent.setMiddle(middle);

                        Service smaller = parent.getSmaller();
                        middle.addData(smaller);
                        parent.removeSmaller();
                        parent.addData(to_add);

                        middle.addParent(parent);

                        return 1;
                    } else {

                        Node middle = new Node();
                        parent.setMiddle(middle);

                        Service greater = parent.getGreater();
                        parent.removeGreater();
                        middle.addData(greater);

                        middle.addParent(parent);
                        return 1;
                    }

                }
            }
        }

        return 0;

    }
}
