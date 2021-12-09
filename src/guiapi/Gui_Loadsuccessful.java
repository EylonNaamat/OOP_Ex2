package guiapi;

import api.MyDirectedWeightedGraphAlgorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_Loadsuccessful implements ActionListener {

    private int width = 500;
    private int high = 500;
    private MyDirectedWeightedGraphAlgorithms thealgo;
    private JFrame successfulframe = new JFrame("successful");
    private JLabel messege = new JLabel("the load");
    private JLabel messege2 = new JLabel("was successful:");
    private JButton moveon = new JButton("continue");

    public Gui_Loadsuccessful(MyDirectedWeightedGraphAlgorithms ng)
    {
        this.thealgo = ng;
        this.messege.setBounds(120,50,200,50);
        this.messege.setFont(new Font(null,Font.BOLD,30));
        this.successfulframe.add(this.messege);
        this.messege2.setBounds(120,100,300,50);
        this.messege2.setFont(new Font(null,Font.BOLD,30));
        this.successfulframe.add(this.messege2);

        this.moveon.setBounds(150,200,100,50);
        this.moveon.addActionListener(this);
        this.moveon.setBackground(Color.ORANGE);
        this.successfulframe.add(this.moveon);

        this.successfulframe.setLayout(null);
        this.successfulframe.setSize(width,high);
        this.successfulframe.getContentPane().setBackground(Color.gray);
        this.successfulframe.setVisible(true);
        this.successfulframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public JFrame getframe()
    {
        return this.successfulframe;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.moveon) {
            this.successfulframe.dispose();
            Gui_algo tempGUIalgo = new Gui_algo(this.thealgo);
        }
    }
}
