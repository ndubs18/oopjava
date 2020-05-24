public class LandNode extends Landscaping {

    public LandNode()
    {
        this.Left = null;
        this.Right = null;
    }
    public LandNode(Landscaping to_copy) {
        super(to_copy);
    }

    public LandNode(LandNode to_copy) {
        super(to_copy);
    }

    public final void display() {
        super.display();
    }
    public final Service goLeft() {

      return this.Left;
    }
    public final Service goRight() {
       return this.Right;
    }

    public final void setLeft(Service to_set) {
        this.Left = to_set;
    }

    public final void setRight(Service to_set)
    {
        this.Right = to_set;
    }

    private Service Left;
    private Service Right;

}
