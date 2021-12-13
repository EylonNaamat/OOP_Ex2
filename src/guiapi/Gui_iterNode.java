package guiapi;

import api.MyDirectedWeightedGraph;
import api.MyDirectedWeightedGraphAlgorithms;
import api.NodeData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class Gui_iterNode implements ActionListener {

    private int width = 500;
    private int high = 500;
    private Iterator<NodeData> iter;
    private MyDirectedWeightedGraphAlgorithms myalgo;
    private JFrame iterframe = new JFrame(" Iterator");
    private JLabel head = new JLabel(" Iterator:");
    private JTextArea text = new JTextArea();
    private JButton next = new JButton("Next");
    private JButton stopIter = new JButton("Stop");

    public Gui_iterNode (MyDirectedWeightedGraphAlgorithms gr, Iterator<NodeData> niter)
    {
        this.iter=niter;
        this.myalgo=gr;

        this.head.setBounds(180,10,220,40);
        this.head.setFont(new Font(null,Font.BOLD,30));
        this.iterframe.add(this.head);

        NodeData n =this.iter.next();
        String st = "the node :";
        st=st+"\n id="+n.getKey();
        st=st+"\n x="+n.getLocation().x();
        st=st+"\n y="+n.getLocation().y();
        st=st+"\n z="+n.getLocation().z();
        st=st+"\n Weight="+n.getWeight();
        st=st+"\n Info="+n.getInfo();
        st=st+"\n Tag="+n.getTag();

        this.text.setBounds(90,50,250,300);
        this.text.setText(st);
        this.text.setBackground(Color.gray);
        this.text.setFont(new Font(null, Font.BOLD, 15));
        this.iterframe.add(this.text);

        this.next.setBounds(400,250,80,40);
        this.next.addActionListener(this);
        this.next.setBackground(Color.ORANGE);
        this.iterframe.add(this.next);


        this.stopIter.setBounds(10,250,80,40);
        this.stopIter.addActionListener(this);
        this.stopIter.setBackground(Color.orange);
        this.iterframe.add(this.stopIter);

        this.iterframe.setLayout(null);
        this.iterframe.setSize(width,high);
        this.iterframe.getContentPane().setBackground(Color.gray);
        this.iterframe.setVisible(true);
        this.iterframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.stopIter)
        {
            this.iterframe.dispose();
            new Gui_Gfunc(this.myalgo);
        }

        if(event.getSource() == this.next)
        {
            this.iterframe.dispose();
            if(this.iter.hasNext()==false)
            {
                new Gui_Gfunc(this.myalgo);
            }
            else
            {
                new Gui_iterNode(this.myalgo,this.iter);
            }
        }
    }
}
