package guiapi;

import api.MyDirectedWeightedGraphAlgorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_LoadASaveFail implements ActionListener {
    private int width = 500;
    private int high = 500;
    private String st;
    private MyDirectedWeightedGraphAlgorithms thealgo;
    private JFrame failframe = new JFrame("fail");
    private JLabel messege = new JLabel();
    private JButton goback = new JButton("try again");

    public Gui_LoadASaveFail(MyDirectedWeightedGraphAlgorithms algo,String st)
    {
        this.st=st;
        this.thealgo=algo;

        this.messege.setBounds(100,80,350,50);
        this.messege.setFont(new Font(null,Font.BOLD,30));
        this.messege.setText("the " +st+ " was fail");
        this.failframe.add(this.messege);


        this.goback.setBounds(150,160,100,50);
        this.goback.addActionListener(this);
        this.goback.setBackground(Color.ORANGE);
        this.failframe.add(this.goback);

        this.failframe.setLayout(null);
        this.failframe.setSize(width,high);
        this.failframe.getContentPane().setBackground(Color.gray);
        this.failframe.setVisible(true);
        this.failframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public JFrame getframe()
    {
        return this.failframe;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.goback) {
            if(this.st=="load") {
                this.failframe.dispose();
                Gui_Menu tempGuimenu = new Gui_Menu();
            }
            if(this.st == "save")
            {
                this.failframe.dispose();
                Gui_algo tempGUIalgo = new Gui_algo(this.thealgo);
            }
        }
    }
}
