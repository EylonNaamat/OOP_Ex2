package guiapi;

import api.MyDirectedWeightedGraphAlgorithms;
import api.NodeData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Gui_addNodeToList implements ActionListener {
    private int width = 500;
    private int high = 500;
    private List<NodeData> mylist;
    private MyDirectedWeightedGraphAlgorithms myAlgo;
    private JFrame getnlistframe = new JFrame("make list");
    private JLabel head = new JLabel("inset node to list");
    private JButton add = new JButton("next");
    private JButton finish = new JButton("finish");
    private JTextArea key = new JTextArea("key: ");
    private JTextField inputkey;

    public Gui_addNodeToList(MyDirectedWeightedGraphAlgorithms gs , List<NodeData> nls)
    {
        this.mylist=nls;
        this.myAlgo =gs;

        this.key.setBounds(20,50,50,40);
        this.key.setFont(new Font(null,Font.BOLD,15));
        this.key.setBackground(Color.gray);
        this.getnlistframe.add(this.key);

        this.inputkey = new JTextField();
        this.inputkey.setBounds(100,50,150,40);
        this.getnlistframe.add(this.inputkey);

        this.add.setBounds(300,250,100,50);
        this.add.addActionListener(this);
        this.add.setBackground(Color.ORANGE);
        this.getnlistframe.add(this.add);

        this.finish.setBounds(50,250,100,50);
        this.finish.addActionListener(this);
        this.finish.setBackground(Color.red);
        this.getnlistframe.add(this.finish);

        this.getnlistframe.setLayout(null);
        this.getnlistframe.setSize(width,high);
        this.getnlistframe.getContentPane().setBackground(Color.gray);
        this.getnlistframe.setVisible(true);
        this.getnlistframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent event) {

        if(event.getSource()==this.add)
        {
            this.getnlistframe.dispose();
            int inputkeyn = Integer.parseInt(this.inputkey.getText());
            NodeData n = this.myAlgo.getGraph().getNode(inputkeyn);
            this.mylist.add(n);
            new Gui_addNodeToList(this.myAlgo,this.mylist);
        }
        if(event.getSource()==this.finish)
        {
            this.getnlistframe.dispose();
            new Gui_MyGraphDrow(this.myAlgo,this.mylist);
        }
    }
}
