import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;

//parameters for gridsize and button for creating a new game
public class ConfigPanel extends JPanel {
    MainFrame frame;
    JLabel label;
    JSpinner spinnerOX,spinnerOY;
    JButton createButton;
    int oxGridValue,oyGridValue;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        this.oxGridValue = frame.oxSize;
        this.oyGridValue = frame.oySize;
        init();
    }

    public void setGridSize(int oxValue, int oyValue){
        this.oxGridValue = oxValue;
        this.oyGridValue = oyValue;
    }

    private void init() {
        //create the label and the spinner
        label = new JLabel("Grid size:");
        createButton = new JButton("CREATE");
        spinnerOX = new JSpinner(new SpinnerNumberModel(oxGridValue,2,100,1));
        spinnerOY = new JSpinner(new SpinnerNumberModel(oyGridValue,2,100,1));
        ChangeListener gridSizeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                oxGridValue = (Integer)spinnerOX.getValue();
                oyGridValue = (Integer)spinnerOY.getValue();
                setGridSize(oxGridValue,oyGridValue);
            }
        };

        spinnerOX.addChangeListener(gridSizeListener);
        spinnerOY.addChangeListener(gridSizeListener);
        createButton.addActionListener(this::createGame);

        //create spinners for rows and cols, and the button

        add(label);
        add(spinnerOX);
        add(spinnerOY);
        add(createButton);
    }
    private void createGame (ActionEvent e) {
        frame.dispose();
        new MainFrame(this.oxGridValue,this.oyGridValue).setVisible(true);
    }

    public int getRows() {
        return this.oxGridValue;
    }
    public int getCols() {
        return this.oyGridValue;
    }
}
