public class Main {
    public static void main(String[] args){
        int[] arr = new int[3];
        arr[1]=2;
        arr[2]=3;

        //ArrayIndexOutOfBoundsException
        try{
            System.out.println(arr[3]);
        }
        catch (Exception e){
            System.out.println("Bad index");
            //e.printStackTrace();
        }
        finally {
            System.out.println("Am prins sau nu excepții");
        }

        //ArithmeticException
        try{
            System.out.println(arr[0]/0);
        }
        catch (Exception e){
            System.out.println("Bad math!!!");
            //e.printStackTrace();
        }
        finally{
            System.out.println("Am prins sau nu excepții");
        }

        String s = null;
        //NullPointerException
        try {
            System.out.println(s.length());
        }
        catch (Exception e){
            System.out.println("Something is null");
        }
        finally {
            System.out.println("Am prins sau nu excepții");
        }

        //ArithmeticException
        try {
            Integer abc = new Integer("  432 ");
        }
        catch (Exception e){
            System.out.println("Bad conversion");
        }
        finally {
            System.out.println("Am prins sau nu excepții");
        }
    }
}
