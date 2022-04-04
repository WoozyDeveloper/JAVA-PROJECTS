import javax.swing.*;
import java.awt.*;

public class Intersection{

    int oxPos,oyPos,dim;
    Graphics2D graphics2D;
    DrawingPanel drawingPanel;
    public Intersection(Graphics2D graphics2D, DrawingPanel drawingPanel, int ox, int oy){
        this.drawingPanel = drawingPanel;
        this.graphics2D=graphics2D;
        this.dim=20;
        graphics2D.drawOval(ox, oy, this.dim, this.dim);
        this.oxPos=ox + dim / 2;
        this.oyPos=oy + dim / 2;
    }

    public boolean checkClickedPosition(int ox, int oy){
        //System.out.println("MOUSE: " + ox + " " + oy);
        drawingPanel.printBoard();
        int matrixLine = (oy - drawingPanel.padY) / drawingPanel.cellHeight;
        int matrixCol = (ox - drawingPanel.padX) / drawingPanel.cellWidth;
        if(drawingPanel.board[matrixLine][matrixCol] == 1) {
            if (ox >= oxPos && ox <= oxPos + dim && oy - 60 >= oyPos && oy - 60 <= oyPos + dim) {
                Graphics g = drawingPanel.getGraphics();
                g.drawOval(oxPos - (this.dim) / 2, oyPos - (this.dim) / 2, this.dim + 5, this.dim + 5);
                if (drawingPanel.turn == drawingPanel.BLUE) {
                    System.out.println("SCHIMB PE " + matrixLine + " si " + matrixCol + " cu " + drawingPanel.BLUE);
                    drawingPanel.board[matrixLine][matrixCol] = drawingPanel.BLUE;
                    g.setColor(Color.BLUE);
                    g.fillOval(oxPos - (this.dim) / 2, oyPos - (this.dim) / 2, this.dim + 5, this.dim + 5);
                    System.out.println("BLUE");
                    drawingPanel.turn = drawingPanel.RED;
                } else if(drawingPanel.turn == drawingPanel.RED){
                    System.out.println("SCHIMB PE " + matrixLine + " si " + matrixCol + " cu " + drawingPanel.RED);
                    drawingPanel.board[matrixLine][matrixCol] = drawingPanel.RED;
                    g.setColor(Color.RED);
                    g.fillOval(oxPos - (this.dim) / 2, oyPos - (this.dim) / 2, this.dim + 5, this.dim + 5);
                    System.out.println("RED");
                    drawingPanel.turn = drawingPanel.BLUE;
                }
                return true;
            }
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
