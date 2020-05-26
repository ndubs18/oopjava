public class Btree {
    public Btree() {
        root = null;
    }

    public int addService(Service to_add) {
        if(root == null ) {
            root = new Node();
            root.addData(to_add);
            return 1;
        }
        else
            return addService(root, to_add);
    }

    private Node root;

    private int addService(Node root, Service to_add) {
        if(root == null)
        {
        }

    }
}
