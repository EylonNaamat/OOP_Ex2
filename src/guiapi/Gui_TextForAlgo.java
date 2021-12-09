package guiapi;

import api.MyDirectedWeightedGraphAlgorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_TextForAlgo implements ActionListener {
    private int width = 500;
    private int high = 500;
    private MyDirectedWeightedGraphAlgorithms thealgo;
    private JFrame algoframe = new JFrame("function");
    private JLabel head = new JLabel("functions:");
    private JButton isConnected = new JButton("isConnected");

    public Gui_TextForAlgo(MyDirectedWeightedGraphAlgorithms algo)
    {
        this.thealgo = algo;

        this.head.setBounds(180, 10, 220, 40);
        this.head.setFont(new Font(null, Font.BOLD, 25));
        this.algoframe.add(this.head);

        this.isConnected.setBounds(10, 80, 220, 50);
        this.isConnected.addActionListener(this);
        this.isConnected.setBackground(Color.ORANGE);
        this.algoframe.add(this.isConnected);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
