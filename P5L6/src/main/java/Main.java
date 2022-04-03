public class Main {
    public static void main(String[] args){
        Point a = new Point(1,0);
        Point b = new Point(2,0);
        Point c = new Point(0,2);

        Triunghi t = new Triunghi(a,b,c);

        try{
            System.out.println(t.eObtuzunghic());
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
