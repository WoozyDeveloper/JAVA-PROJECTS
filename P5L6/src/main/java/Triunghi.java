public class Triunghi {
    private Point a,b,c;
    private double lat1,lat2,lat3;

    public Triunghi(Point a, Point b, Point c){
        this.a=a;
        this.b=b;
        this.c=c;
        this.calculateEdges();
    }

    public double calculateEdge(Point x, Point y){
        return Math.sqrt(Math.pow(x.getX()-y.getX(),2) +
                Math.pow(x.getY()-y.getY(),2));
    }

    public static double mini(double r, double g, double b){
        return Math.min(Math.min(r, g), b);
    }

    public static double maxi(double r, double g, double b){
        return Math.max(Math.max(r, g), b);
    }

    public void calculateEdges(){
        lat1 = calculateEdge(this.a,this.b);
        lat2 = calculateEdge(this.a,this.c);
        lat3 = calculateEdge(this.b,this.c);

        System.out.println(lat1 + " " + lat2 + " " + lat3);
    }

    public boolean eObtuzunghic() throws TriunghiAscutitunghic,TriunghiImposibil,TriunghiDreptunghic{

        double low = lat1,mid=lat2,high=lat3;
        lat1=mini(low,mid,high);
        lat3=maxi(low,mid,high);
        lat2=low+mid+high-lat1-lat3;

        if(lat1 + lat2 == lat3)
            throw new TriunghiImposibil();

        if((Math.round(lat1 * lat1 + lat2 * lat2) == Math.round(lat3 * lat3)))
            throw new TriunghiDreptunghic();

        if((Math.round(lat1 * lat1 + lat2 * lat2) > Math.round(lat3 * lat3))) {
            System.out.println(Math.round(lat1 * lat1 + lat2 * lat2) + " < " + Math.round(lat3 * lat3));
            throw new TriunghiAscutitunghic();
        }

        if((Math.round(lat1 * lat1 + lat2 * lat2) < Math.round(lat3 * lat3))) {
            System.out.println(Math.round(lat1 * lat1 + lat2 * lat2) + " < " + Math.round(lat3 * lat3));
            return true;
        }
        return false;
    }
}
