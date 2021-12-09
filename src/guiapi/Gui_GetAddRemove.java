package guiapi;

import api.MyDirectedWeightedGraph;
import api.MyDirectedWeightedGraphAlgorithms;

import javax.swing.*;
import java.awt.*;
import java.security.PrivateKey;

public class Gui_GetAddRemove {

    private int width = 500;
    private int high = 500;
    private String active;
    private MyDirectedWeightedGraph mygraph;
    private JFrame failframe = new JFrame();
    private JLabel messege = new JLabel();



    public Gui_GetAddRemove(MyDirectedWeightedGraph gr, String st)
    {
        this.active=st;
        this.mygraph = gr;


        this.messege.setBounds(100,80,350,50);
        this.messege.setFont(new Font(null,Font.BOLD,30));
        this.messege.setText(st);
        this.failframe.add(this.messege);

        this.failframe.setLayout(null);
        this.failframe.setSize(width,high);
        this.failframe.getContentPane().setBackground(Color.gray);
        this.failframe.setVisible(true);
        this.failframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
