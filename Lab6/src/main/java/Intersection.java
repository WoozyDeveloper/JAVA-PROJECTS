import javax.swing.*;
import java.awt.*;

public class Intersection extends DrawingPanel{
    int oxPos,oyPos,dim;
    int oxIndex,oyIndex;
    JButton button;
    Graphics2D graphics2D;
    MainFrame frame;
    public Intersection(Graphics2D graphics2D, MainFrame mainFrame, int ox, int oy){
        super(mainFrame);
        this.frame = mainFrame;
        this.graphics2D=graphics2D;
        this.dim=20;
        graphics2D.drawOval(ox, oy, this.dim, this.dim);
        this.oxPos=ox + dim / 2;
        this.oyPos=oy + dim / 2;
    }

    public void drawMove() {
        Graphics g = frame.getGraphics();
        g.drawOval(oxPos - (this.dim - 10)/2, oyPos + 60, this.dim + 5, this.dim + 5);
        g.setColor(Color.BLUE);
        g.fillOval(oxPos - (this.dim - 10)/2, oyPos + 60, this.dim + 5, this.dim + 5);
    }

    public boolean checkClickedPosition(int ox, int oy){
        System.out.println("MOUSE: " + ox + " " + oy);
        oy-=60;
        if(ox >=oxPos && ox <= oxPos + dim && oy >=oyPos && oy <= oyPos + dim){
            drawMove();
            repaint();
            return true;
        }
        return false;
    }

    public void changeColor(){
        graphics2D.setColor(Color.BLUE);
        graphics2D.drawOval(oxPos, oyPos, this.dim + 5, this.dim + 5);
        graphics2D.fillOval(this.oxPos + dim/2, this.oyPos + dim/2, this.dim + 5, this.dim + 5);
    }

    @Override
    public String toString() {
        return "Intersection{" +
                "oxPos=" + oxPos +
                ", oyPos=" + oyPos +
                '}';
    }
}
