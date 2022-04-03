import java.util.ArrayList;

public class Spatiu {
    private ArrayList<Pozitie> referencePoints;
    private Pozitie otherPoint;
    private double referenceDistance;


    public Spatiu(Pozitie p1, Pozitie p2, Pozitie p3, double referenceDistance){
        referencePoints = new ArrayList<>();
        referencePoints.add(p1);
        referencePoints.add(p2);
        referencePoints.add(p3);
    }

    public double calculateEdge(Pozitie x, Pozitie y){
        return Math.sqrt(Math.pow(x.getX()-y.getX(),2) +
                Math.pow(x.getY()-y.getY(),2) + Math.pow(x.getZ()-y.getZ(),2));
    }

    public boolean checkPoints() throws PunctPreaAproape{
        for(Pozitie p : referencePoints)
            if(calculateEdge(p,otherPoint) <= referenceDistance)
                return false;
        return true;
    }

    public Pozitie getOtherPoint() {
        return otherPoint;
    }

    public void setOtherPoint(Pozitie otherPoint) {
        this.otherPoint = otherPoint;
    }
}
