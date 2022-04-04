import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class DrawingPanel extends JPanel {
    Graphics2D graphics2D;
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 800, canvasHeight = 800;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;
    int[][] board;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        board = new int[100][100];
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    public void printBoard(){
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(this.board[i][j] + " ");
            System.out.println();
        }
        System.out.println("--------------------------------");
    }

    private void buildRandomLines () {
        graphics2D.setColor(Color.BLACK);
        graphics2D.setStroke(new BasicStroke(5));
        double prob = 0.7;
        Random rand = new Random();
        for (int row = 0 ; row < rows ; row++) {
            for (int col = 0 ; col < cols ; col++) {
                for (int dx = 0 ; dx <= 1; dx++) {
                    for (int dy = 0 ; dy <= 1 ; dy++) {
                        if( (dx == dy) || (row + dy >= rows) || (col + dx >= cols) ) {
                            continue;
                        }
                        if ( rand.nextDouble() < prob ) {
                            int x1 = padX + col * cellWidth;
                            int y1 = padY + row * cellHeight;
                            int x2 = x1 + dx * cellWidth;
                            int y2 = y1 + dy * cellHeight;
                            graphics2D.drawLine(x1, y1, x2, y2);
                            board[x1][y1]=board[x2][y2]=1;
                        }
                    }
                }
            }
        }
    }

    final void init(int rows, int cols) {
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                board[i][j]=0;
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        printBoard();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid();
        //paintSticks(g);
        //paintStones(g);
    }

    private void paintGrid() {
        graphics2D.setColor(Color.DARK_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            graphics2D.drawLine(x1, y1, x2, y2);
        }
        //vertical lines
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padX + boardWidth;
            graphics2D.drawLine(x1, y1, x2, y2);
        }
        //vertical lines TODO
        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                graphics2D.setColor(Color.LIGHT_GRAY);
                graphics2D.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
        buildRandomLines();
    }
}