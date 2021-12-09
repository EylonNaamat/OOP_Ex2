package guiapi;

import api.MyDirectedWeightedGraph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_Gfunc implements ActionListener {
    private int width = 500;
    private int high = 500;
    private MyDirectedWeightedGraph theGraph;
    private JFrame gfuncframe = new JFrame("function");
    private JLabel head = new JLabel("functions:");
    private JButton getNode = new JButton("getNode");
    private JButton getEdge = new JButton("getEdge");
    private JButton addNode = new JButton("addNode");
    private JButton connect = new JButton("connect");
    private JButton removeNode = new JButton("removeNode");
    private JButton removeEdge = new JButton("removeEdge");
    private JButton nodeSize = new JButton("nodeSize");
    private JButton edgeSize = new JButton("edgeSize");
    private JButton getMC = new JButton("getMC");
    private JButton edgeIter = new JButton("edgeIter");
    private JButton nodeIter = new JButton("nodeIter");
    private JButton goalgo = new JButton("goalgo");

    public Gui_Gfunc(MyDirectedWeightedGraph gr)
    {
        this.theGraph = gr;

        this.head.setBounds(180,10,220,40);
        this.head.setFont(new Font(null,Font.BOLD,25));
        this.gfuncframe.add(this.head);

        this.getNode.setBounds(10,80,220,50);
        this.getNode.addActionListener(this);
        this.getNode.setBackground(Color.ORANGE);
        this.gfuncframe.add(this.getNode);

        this.getEdge.setBounds(260,80,220,50);
        this.getEdge.addActionListener(this);
        this.getEdge.setBackground(Color.ORANGE);
        this.gfuncframe.add(this.getEdge);

        this.addNode.setBounds(10,140,220,50);
        this.addNode.addActionListener(this);
        this.addNode.setBackground(Color.ORANGE);
        this.gfuncframe.add(this.addNode);

        this.connect.setBounds(260,140,220,50);
        this.connect.addActionListener(this);
        this.connect.setBackground(Color.ORANGE);
        this.gfuncframe.add(this.connect);

        this.removeNode.setBounds(10,200,220,50);
        this.removeNode.addActionListener(this);
        this.removeNode.setBackground(Color.ORANGE);
        this.gfuncframe.add(this.removeNode);

        this.removeEdge.setBounds(260,200,220,50);
        this.removeEdge.addActionListener(this);
        this.removeEdge.setBackground(Color.ORANGE);
        this.gfuncframe.add(this.removeEdge);

        this.nodeSize.setBounds(10,260,220,50);
        this.nodeSize.addActionListener(this);
        this.nodeSize.setBackground(Color.ORANGE);
        this.gfuncframe.add(this.nodeSize);

        this.edgeSize.setBounds(260,260,220,50);
        this.edgeSize.addActionListener(this);
        this.edgeSize.setBackground(Color.ORANGE);
        this.gfuncframe.add(this.edgeSize);

        this.edgeIter.setBounds(10,320,220,50);
        this.edgeIter.addActionListener(this);
        this.edgeIter.setBackground(Color.ORANGE);
        this.gfuncframe.add(this.edgeIter);

        this.nodeIter.setBounds(260,320,220,50);
        this.nodeIter.addActionListener(this);
        this.nodeIter.setBackground(Color.ORANGE);
        this.gfuncframe.add(this.nodeIter);

        this.getMC.setBounds(10,380,220,50);
        this.getMC.addActionListener(this);
        this.getMC.setBackground(Color.ORANGE);
        this.gfuncframe.add(this.getMC);

        this.goalgo.setBounds(260,380,220,50);
        this.goalgo.addActionListener(this);
        this.goalgo.setBackground(Color.ORANGE);
        this.gfuncframe.add(this.goalgo);

        this.gfuncframe.setLayout(null);
        this.gfuncframe.setSize(width,high);
        this.gfuncframe.getContentPane().setBackground(Color.gray);
        this.gfuncframe.setVisible(true);
        this.gfuncframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public JFrame getframe()
    {
        return this.gfuncframe;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.getNode )
        {

        }
        if(event.getSource() == this.getEdge)
        {

        }
        if(event.getSource() == this.getMC )
        {

        }
        if(event.getSource() ==this.removeEdge )
        {

        }
        if(event.getSource() == this.removeNode)
        {

        }
        if(event.getSource() == this.addNode)
        {

        }
        if(event.getSource() == this.connect)
        {

        }
        if(event.getSource() == this.edgeSize)
        {

        }
        if(event.getSource() == this.nodeSize)
        {

        }
        if(event.getSource() == this.nodeIter)
        {

        }
        if(event.getSource() == this.edgeIter)
        {

        }

    }
}
