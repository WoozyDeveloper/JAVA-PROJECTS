import com.sun.tools.javac.Main;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame{
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    int oxSize,oySize;


    public MainFrame(int ox, int oy) {
        super("My Drawing Application");
        this.oxSize = ox;
        this.oySize = oy;
        init();
    }
    public MainFrame() {
        super("My Drawing Application");
        this.oxSize = 10;
        this.oySize = 10;
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        configPanel = new ConfigPanel(this);
        configPanel.setGridSize(this.oxSize,this.oySize);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);


        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        //invoke the layout manager
        pack();
    }

}