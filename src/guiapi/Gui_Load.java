package guiapi;

import api.MyDirectedWeightedGraphAlgorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_Load implements ActionListener {
    private int width = 500;
    private int high = 500;
    private MyDirectedWeightedGraphAlgorithms thealgo;
    private JFrame loadframe = new JFrame("load");
    private JLabel head = new JLabel("put puth:");
    private JButton startload = new JButton("load");
    private JButton clean = new JButton("clean");
    private JTextField puthString = new JFormattedTextField();

    public Gui_Load()
    {
        this.head.setBounds(80,50,150,50);
        this.head.setFont(new Font(null,Font.BOLD,30));
        this.loadframe.add(this.head);

        this.puthString.setBounds(80,120,300,40);
        this.puthString.setFont(new Font(null,Font.BOLD,30));
        this.loadframe.add(this.puthString);

        this.startload.setBounds(80,200,100,50);
        this.startload.addActionListener(this);
        this.startload.setBackground(Color.ORANGE);
        this.loadframe.add(this.startload);

        this.clean.setBounds(250,200,100,50);
        this.clean.addActionListener(this);
        this.clean.setBackground(Color.ORANGE);
        this.loadframe.add(this.clean);

        this.loadframe.setLayout(null);
        this.loadframe.setSize(width,high);
        this.loadframe.getContentPane().setBackground(Color.gray);
        this.loadframe.setVisible(true);
        this.loadframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public JFrame getframe()
    {
        return this.loadframe;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==this.startload)
        {
            this.puthString.setText("");
            String puth =this.puthString.getText();
            this.thealgo = new MyDirectedWeightedGraphAlgorithms();
            boolean flage = thealgo.load(puth);
            if(flage== true)
            {

            }
            else
            {

            }
        }
        if(event.getSource()==this.clean)
        {
            this.puthString.setText("");

        }
    }
}
