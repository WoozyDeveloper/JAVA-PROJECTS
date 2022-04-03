import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pozitie p1,p2,p3;
        p1 = new Pozitie(1,1,1);
        p2 = new Pozitie(2,2,2);
        p3 = new Pozitie(3,3,3);
        int dim;
        Spatiu spatiu = new Spatiu(p1,p2,p3,10);
        Scanner s = new Scanner(System.in);
        System.out.println("Nr de elemente pe care le citesc: ");
        dim = s.nextInt();

        int index=0;
        boolean condition = false;
        while(!condition){
            index++;
            if(index>dim)
                throw new ArrayIndexOutOfBoundsException();
            double x = s.nextDouble();
            double y = s.nextDouble();
            double z = s.nextDouble();

            Pozitie p = new Pozitie(x,y,z);
            spatiu.setOtherPoint(p);
            try {
                if (spatiu.checkPoints())
                    condition = true;
                else
                    throw new PunctPreaAproape();
            }
            catch(PunctPreaAproape e){
                e.printStackTrace();
            }
        }
        System.out.println("DAA");
    }
}
