package log_in;

import chessGame.Frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class videoplayer {
    private Frame frame;
    private ImageIcon icon;
    private JLabel imageLabel;
    private JButton skipButton;

    public videoplayer() {
        frame = new Frame();

        // Set up the image label
        icon = new ImageIcon("1_deliverabless/Final Comp (2).gif");
        imageLabel = new JLabel(icon);
        imageLabel.setBounds(0, 0, 1060, 668);


        // Set up the skip button
        RoundBorderButton skipButton = new RoundBorderButton("Skip");
        skipButton.setBounds(880, 580, 120, 40);
        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new welcomePage();
                frame.dispose();
            }
        });
        frame.add(skipButton);
        frame.add(imageLabel);
frame.setVisible(true);
    }

}
