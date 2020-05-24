public class Main {
    public static void main(String args[])
    {
        List BST = new List();
        Service newS = new Landscaping();

        newS.inputName();
        newS.inputCost();
        ((Landscaping) newS).inputSquareFt();


        BST.insertNode(newS);
        BST.display();

    }
}
