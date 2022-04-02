public class Main {
    public static void main(String[] args){
        MyMatrix myMatrix = new MyMatrix();
        myMatrix.readArray();
        myMatrix.printArray();
        System.out.println();
        try{
            System.out.println(myMatrix.getElement(3,2));
        }
        catch (Exception e){
            System.out.println("Nu exista acest element");
            e.printStackTrace();
        }

        System.out.println("Am terminat programul!!!");
    }
}
