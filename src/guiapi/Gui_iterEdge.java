package guiapi;

import api.EdgeData;
import api.MyDirectedWeightedGraph;
import api.NodeData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class Gui_iterEdge implements ActionListener {
    private int width = 500;
    private int high = 500;
    private Iterator<EdgeData> iter;
    private MyDirectedWeightedGraph mygraph;
    private JFrame iterframe = new JFrame(" Iterator");
    private JLabel head = new JLabel(" Iterator:");
    private JTextArea text = new JTextArea();
    private JButton next = new JButton("Next");
    private JButton stopIter = new JButton("Stop");

    public Gui_iterEdge (MyDirectedWeightedGraph gr, Iterator<EdgeData> niter)
    {
        this.iter=niter;
        this.mygraph=gr;

        this.head.setBounds(180,10,220,40);
        this.head.setFont(new Font(null,Font.BOLD,30));
        this.iterframe.add(this.head);

        EdgeData tempEdje =this.iter.next();
        String st = "the Edje :";
        st=st+"\n src="+tempEdje.getSrc();
        st=st+"\n dest="+tempEdje.getDest();
        st=st+"\n Weight="+tempEdje.getWeight();
        st=st+"\n Info="+tempEdje.getInfo();
        st=st+"\n Tag="+tempEdje.getTag();

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
            Gui_Gfunc tempGUIfunc = new Gui_Gfunc(this.mygraph);
        }

        if(event.getSource() == this.next)
        {
            this.iterframe.dispose();
            if(this.iter.hasNext()==false)
            {
                Gui_Gfunc tempGUIfunc = new Gui_Gfunc(this.mygraph);
            }
            else
            {
                Gui_iterEdge tempGUIiter = new Gui_iterEdge(this.mygraph,this.iter);
            }
        }
    }
}
