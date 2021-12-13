package guiapi;

import api.MyDirectedWeightedGraph;
import api.MyDirectedWeightedGraphAlgorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_TextShow implements ActionListener {
    private int width = 500;
    private int high = 500;
    private MyDirectedWeightedGraphAlgorithms thealgo;
    private JFrame algoTestframe = new JFrame("result");
    private JLabel head = new JLabel("result:");
    private JTextArea text = new JTextArea();
    private JButton goalgo = new JButton("go to algo");
    private JButton gograph = new JButton("go to graph");

    public Gui_TextShow(MyDirectedWeightedGraphAlgorithms algo, String st)
    {
        this.thealgo = algo;

        this.head.setBounds(180, 10, 220, 40);
        this.head.setFont(new Font(null, Font.BOLD, 25));
        this.algoTestframe.add(this.head);

        this.text.setBounds(50,50,300,300);
        this.text.setText(st);
        this.text.setBackground(Color.gray);
        this.text.setFont(new Font(null, Font.BOLD, 15));
        this.algoTestframe.add(this.text);

        this.goalgo.setBounds(50, 350, 150, 50);
        this.goalgo.addActionListener(this);
        this.goalgo.setBackground(Color.ORANGE);
        this.algoTestframe.add(this.goalgo);

        this.gograph.setBounds(250, 350, 150, 50);
        this.gograph.addActionListener(this);
        this.gograph.setBackground(Color.ORANGE);
        this.algoTestframe.add(this.gograph);

        this.algoTestframe.setLayout(null);
        this.algoTestframe.setSize(width,high);
        this.algoTestframe.getContentPane().setBackground(Color.gray);
        this.algoTestframe.setVisible(true);
        this.algoTestframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.goalgo)
        {
            this.algoTestframe.dispose();
            new Gui_algo(this.thealgo);
        }
        if(event.getSource() == this.gograph)
        {
            this.algoTestframe.dispose();
            new Gui_Gfunc(this.thealgo);
        }
    }
}
