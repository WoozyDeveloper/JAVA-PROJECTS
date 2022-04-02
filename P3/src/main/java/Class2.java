public class Class2 extends Class1 implements Int1, Int2{
    int x,y;

    public Class2(double a, double b) {
        super(a, b);
        this.x=(int)a;
        this.y=(int)b;
    }

    public int sum(){
        return x+y;
    }
    public double product(){
        return Class1.a * Class2.b;
    }
}
