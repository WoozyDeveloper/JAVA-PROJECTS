import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Intersection{
    ArrayList<Intersection> reachableIntersections = new ArrayList<>();
    boolean occupied = false;
    int color = 0;
    int oxPos,oyPos,dim;
    Graphics2D graphics2D;
    DrawingPanel drawingPanel;
    public Intersection(Graphics2D graphics2D, DrawingPanel drawingPanel, int ox, int oy){
        this.drawingPanel = drawingPanel;
        this.graphics2D=graphics2D;
        this.dim=20;
        this.oxPos=ox + dim / 2;
        this.oyPos=oy + dim / 2;
    }

    public void printReachableIntersections(){
        for(Intersection intersection : reachableIntersections)
            System.out.print(intersection + " ");
    }

    public void printStatusReachableIntersections(){
        System.out.println("STATUS");
        for(Intersection intersection : reachableIntersections)
            System.out.print(intersection.occupied + " ");
        System.out.println();
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
        //drawingPanel.printBoard();
        int matrixLine = (oy - drawingPanel.padY) / drawingPanel.cellHeight;
        int matrixCol = (ox - drawingPanel.padX) / drawingPanel.cellWidth;
        if(drawingPanel.board[matrixLine][matrixCol] == 1) {
            if (ox >= oxPos && ox <= oxPos + dim && oy - 60 >= oyPos && oy - 60 <= oyPos + dim) {
                Graphics g = drawingPanel.getGraphics();
                if (drawingPanel.turn == drawingPanel.BLUE) {
                    boolean search = false;
                    for(Intersection intersection : reachableIntersections){
                        if(intersection.color == drawingPanel.RED)
                            search = true;
                    }
                    if((search == true || drawingPanel.firstMove == true) && occupied == false) {
                        occupied = true;
                        g.drawOval(oxPos - (this.dim) / 2, oyPos - (this.dim) / 2, this.dim + 5, this.dim + 5);
                        drawingPanel.firstMove = false;
                        color = drawingPanel.BLUE;
                        System.out.println("SCHIMB PE " + matrixLine + " si " + matrixCol + " cu " + drawingPanel.BLUE);
                        drawingPanel.board[matrixLine][matrixCol] = drawingPanel.BLUE;
                        g.setColor(Color.BLUE);
                        g.fillOval(oxPos - (this.dim) / 2, oyPos - (this.dim) / 2, this.dim + 5, this.dim + 5);
                        System.out.println("BLUE");
                        drawingPanel.turn = drawingPanel.RED;
                    }
                } else if(drawingPanel.turn == drawingPanel.RED){
                    boolean search = false;
                    for(Intersection intersection : reachableIntersections){
                        if(intersection.color == drawingPanel.BLUE)
                            search = true;
                    }

                    if((search == true || drawingPanel.firstMove == true) && occupied == false) {
                        occupied = true;
                        g.drawOval(oxPos - (this.dim) / 2, oyPos - (this.dim) / 2, this.dim + 5, this.dim + 5);
                        drawingPanel.firstMove = false;
                        color = drawingPanel.RED;
                        System.out.println("SCHIMB PE " + matrixLine + " si " + matrixCol + " cu " + drawingPanel.RED);
                        drawingPanel.board[matrixLine][matrixCol] = drawingPanel.RED;
                        g.setColor(Color.RED);
                        g.fillOval(oxPos - (this.dim) / 2, oyPos - (this.dim) / 2, this.dim + 5, this.dim + 5);
                        System.out.println("RED");
                        drawingPanel.turn = drawingPanel.BLUE;
                    }
                }
                boolean search = false;
                for(Intersection intersection : reachableIntersections){
                    if(intersection.occupied == false)
                        search = true;
                }
                if(search == false){
                    if(drawingPanel.turn == drawingPanel.RED){
                        System.out.println("BLUE WON");
                        graphics2D.setColor(Color.BLUE);
                    }
                    if(drawingPanel.turn == drawingPanel.BLUE){
                        System.out.println("RED WON");
                        graphics2D.setColor(Color.RED);
                    }
                }
                printStatusReachableIntersections();
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
