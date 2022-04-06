import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//managing the game with buttons like load,save,exit,etc placed on the bottom
public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton exportImg = new JButton("EXPORT PNG");
    JButton saveButton = new JButton("SAVE");
    //create all buttons (Load, Exit, etc.)

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));

        add(exportImg);
        add(saveButton);

        exitBtn.addActionListener(this::exitGame);
        exportImg.addActionListener(this::exportPNG);
    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void exportPNG(ActionEvent e){
        BufferedImage bi = new BufferedImage(frame.getSize().width, frame.getSize().height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        frame.canvas.paint(g);
        try{ImageIO.write(bi,"png",new File("test2.png"));}catch (Exception ex) {}


    }

    private void saveGame(ActionEvent e){

    }
}
