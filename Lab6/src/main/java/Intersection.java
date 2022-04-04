import javax.swing.*;
import java.awt.*;

public class Intersection extends DrawingPanel{
    int oxPos,oyPos,dim;
    JButton button;
    Graphics2D graphics2D;
    public Intersection(Graphics2D graphics2D, MainFrame mainFrame, int ox, int oy){
        super(mainFrame);
        this.graphics2D=graphics2D;
        this.oxPos=ox;
        this.oyPos=oy;
        this.dim=20;
        graphics2D.drawOval(this.oxPos, this.oyPos, this.dim, this.dim);
    }
}
