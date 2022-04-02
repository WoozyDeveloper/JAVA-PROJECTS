import java.util.Scanner;

public class MyMatrix {
    int dim;
    double[][] arr;

    public MyMatrix()
    {
        this.dim=3;
        this.arr = new double[this.dim][this.dim];
    }
    public MyMatrix(int dim)
    {
        this.dim = dim;
        this.arr = new double[this.dim][this.dim];
    }
    public double getElement(int index1,int index2) throws ArrayIndexOutOfBoundsException{
        return this.arr[index1][index2];
    }
    public void readArray(){
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<this.dim;i++) {
            for(int j=0;j<this.dim;j++)
                this.arr[i][j] = scanner.nextDouble();
        }
    }
    public void printArray(){
        for(int i=0;i<this.dim;i++) {
            for(int j=0;j<this.dim;j++)
                System.out.print(this.arr[i][j] + " ");
            System.out.println();
        }
    }
}
