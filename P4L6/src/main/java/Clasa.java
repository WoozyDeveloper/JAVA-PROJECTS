public class Clasa {
    static int x=0;
    public static void a() throws ExceptieMaiMica{
        x=1;
    }
    public static void b() throws SuperExceptie{
        x=2;
    }

    public static void main(String[] args){
        try{
            b();
            if(x==2)
                throw new SuperExceptie();
        }
        catch (SuperExceptie e){
            e.printStackTrace();
        }

        try{
            a();
            if(x==1)
                throw new ExceptieMaiMica();
        }
        catch (ExceptieMaiMica e){
            e.printStackTrace();
        }

        try{
            a();
            if(x==1)
                throw new ExceptieMaiMica();
        }
        catch (SuperExceptie e){
            e.printStackTrace();
        }
    }
}
