import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Intersection{
    ArrayList<Intersection> reachableIntersections = new ArrayList<>();
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

    public boolean checkForPossibleMoves(){
        //region CURRENT
        int currentOX = this.oxPos;
        int currentOY = this.oyPos;
        //endregion
        //region UP
        int upOX = this.oxPos;
        int upOY = this.oyPos - drawingPanel.cellHeight;
        //endregion
        //region RIGHT
        int rightOX = this.oxPos + drawingPanel.cellWidth;
        int rightOY = this.oyPos;
        //endregion
        //region LEFT
        int leftOX = this.oxPos - drawingPanel.cellWidth;
        int leftOY = this.oyPos;
        //endregion
        //region DOWN
        int downOX = this.oxPos;
        int downOY = this.oyPos + drawingPanel.cellHeight;
        //endregion
        return true;
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

    @Override
    public String toString() {
        return "Intersection{" +
                "oxPos=" + oxPos +
                ", oyPos=" + oyPos +
                '}';
    }
}
