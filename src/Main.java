public class Main {
    public static void main(String args[])
    {
        Service newS = new Landscaping();

        newS.inputName();
        newS.inputCost();
        ((Landscaping) newS).inputSquareFt();


    }
}
