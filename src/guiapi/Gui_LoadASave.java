package guiapi;

import api.MyDirectedWeightedGraphAlgorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_LoadASave implements ActionListener {
    private int width = 500;
    private int high = 500;
    private String st;
    private MyDirectedWeightedGraphAlgorithms thealgo;
    private JFrame lsframe = new JFrame();
    private JLabel head = new JLabel("put puth:");
    private JButton startlAs = new JButton();
    private JButton clean = new JButton("clean");
    private JTextField puthString = new JFormattedTextField();

    public Gui_LoadASave(MyDirectedWeightedGraphAlgorithms algo, String st)
    {
        this.st = st;
        this.thealgo = algo;
        this.head.setBounds(80,50,150,50);
        this.head.setFont(new Font(null,Font.BOLD,30));
        this.head.setText(st);
        this.lsframe.add(this.head);

        this.puthString.setBounds(80,120,300,40);
        this.puthString.setFont(new Font(null,Font.BOLD,30));
        this.lsframe.add(this.puthString);

        this.startlAs.setBounds(80,200,100,50);
        this.startlAs.addActionListener(this);
        this.startlAs.setBackground(Color.ORANGE);
        this.startlAs.setText(st);
        this.lsframe.add(this.startlAs);

        this.clean.setBounds(250,200,100,50);
        this.clean.addActionListener(this);
        this.clean.setBackground(Color.ORANGE);
        this.lsframe.add(this.clean);

        this.lsframe.setLayout(null);
        this.lsframe.setSize(width,high);
        this.lsframe.getContentPane().setBackground(Color.gray);
        this.lsframe.setVisible(true);
        this.lsframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public JFrame getframe()
    {
        return this.lsframe;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==this.startlAs)
        {
            boolean flage=false;
            String puth =this.puthString.getText();
            if(this.st=="load") {
                 flage = this.thealgo.load(puth);
            }
            if(this.st == "save")
            {
                 flage = this.thealgo.save(puth);
            }
            if(flage== true)
            {
                this.lsframe.dispose();
                new Gui_LoadASavesuccessful(this.thealgo,this.st);

            }
            else
            {
                this.lsframe.dispose();
                new Gui_LoadASaveFail(this.thealgo,this.st);
            }
        }
        if(event.getSource()==this.clean)
        {
            this.puthString.setText("");

        }
    }
}
