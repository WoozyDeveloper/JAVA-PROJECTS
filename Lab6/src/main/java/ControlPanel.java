import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//managing the game with buttons like load,save,exit,etc placed on the bottom
public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadButton = new JButton("LOAD");
    JButton saveButton = new JButton("SAVE");
    //create all buttons (Load, Exit, etc.)

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));

        add(loadButton);
        add(saveButton);

        exitBtn.addActionListener(this::exitGame);
    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void loadGame(ActionEvent e){

    }

    private void saveGamae(ActionEvent e){

    }
}
