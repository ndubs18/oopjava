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
            else if(added == 0) {
                System.out.println("There are two keys in this node");
                Node temp = root;
                root = new Node();

                int toPush = temp.isBetween(to_add);

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
                else if(toPush == -1)
                {
                //TODO we need to figure out why we were getting a segfault/pointer exception here

                    return 1;
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
        if(root == null)
            return 0;

        //go to left subtree
        if(root.compare(to_add) == -1) {
            int rc = addService(root.goLeft(), to_add);
        }
        //go to right subtree
        else {
            int rc = addService(root.goRight(), to_add);
        }

        //try to add the data to the node
        int added = root.addData(to_add);

        //if there is less than two data items in the node
        if(added == 1) {
            return 1;
        } else { //if the node to add into already has two keys
            //hold onto the existing root
            Node temp = root;
            //make a new root node
            root = new Node();
            //find which data item needs to be pushed up
            int pushUp = temp.isBetween(to_add);
            //if to_add is the data that needs to get pushed up
            if(pushUp == 0) {
                System.out.println("Push up the new service to a new root node");




                return 1;

            }
            //if smaller is the data item we need to push up
            else if(pushUp == -1) {

                System.out.println("push the smaller item up:");


                return 1;

            } else {
                System.out.println("push the greater item up");


                return 1;
            }


        }






    }
}
