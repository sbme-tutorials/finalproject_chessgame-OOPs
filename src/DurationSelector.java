import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DurationSelector extends JFrame {
    private JComboBox<Integer> durationCombo;

    public DurationSelector() {
        // Create a combo box with durations in minutes
        durationCombo = new JComboBox<>(new Integer[]{1, 5, 10, 15, 30, 60});

        // Add a label for the combo box
        JLabel label = new JLabel("Select duration:");
        label.setLabelFor(durationCombo);

        // Create a button to submit the selected duration
        JButton submitButton = new JButton("Start");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedDuration = (int) durationCombo.getSelectedItem();
                // Store the selected duration and start the timer
                // ...
            }
        });

        // Add the components to the content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(label);
        contentPane.add(durationCombo);
        contentPane.add(submitButton);

        // Set the frame properties
        setTitle("Duration Selector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Center the frame on screen
    }

/*
 * public static void main(String[] args) { // Create and show the duration
 * selector frame DurationSelector timer = new DurationSelector();
 * timer.setVisible(true); timer.setSize(800,550); JPanel panel2 = new
 * JPanel(new FlowLayout()); panel2.add(timer);
 * 
 * JPanel panel1 = new JPanel(new FlowLayout()); panel1.setLayout(null); JLabel
 * label1 = new JLabel("Please choose your color"); label1.setFont(new
 * Font("Arial", Font.PLAIN, 28)); label1.setBounds(50, 0, 550, 100);
 * 
 * 
 * JButton white = new JButton("white"); white.setBounds(50, 100, 100, 100);
 * white.setBackground(Color.WHITE); white.setForeground(Color.black);
 * 
 * JButton black = new JButton("black"); black.setBounds(175, 100, 100, 100);
 * black.setBackground(Color.black); black.setForeground(Color.white);
 * 
 * JLabel label2 = new JLabel("Please set a timer"); label2.setFont(new
 * Font("Arial", Font.PLAIN, 28)); label2.setBounds(50, 300, 550, 100);
 * 
 * 
 * 
 * 
 * 
 * JButton start = new JButton("Start Game"); start.setBounds(650, 450, 100,
 * 100); start.setBackground(Color.GREEN);
 * 
 * 
 * 
 * panel1.add(label1); panel1.add(label2); panel1.add(white); panel1.add(black);
 * panel1.add(start);
 * 
 * JFrame frame = new JFrame("Label Example"); frame.add(panel1);
 * frame.add(panel2);
 * 
 * frame.pack(); frame.setVisible(true); } 
 */
}