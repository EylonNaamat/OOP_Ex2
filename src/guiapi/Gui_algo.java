package guiapi;

import api.MyDirectedWeightedGraph;
import api.MyDirectedWeightedGraphAlgorithms;
import api.NodeData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class Gui_algo implements ActionListener {
    private int width = 500;
    private int high = 500;
    private MyDirectedWeightedGraphAlgorithms thealgo;
    private JFrame algoframe = new JFrame(" algo function");
    private JLabel head = new JLabel(" algo functions:");
    private JButton isConnected = new JButton("isConnected");
    private JButton shortestPathDist = new JButton("shortestPathDist");
    private JButton shortestPath = new JButton("shortestPath");
    private JButton center = new JButton("center");
    private JButton tsp = new JButton("tsp");
    private JButton save = new JButton("save");
    private JButton loadNew = new JButton("load new graph");
    private JButton chang = new JButton("change graph");
    private JButton drowgraph = new JButton("Drow graph");

    public Gui_algo(MyDirectedWeightedGraphAlgorithms algo) {
        this.thealgo = algo;

        this.head.setBounds(150, 10, 220, 40);
        this.head.setFont(new Font(null, Font.BOLD, 25));
        this.algoframe.add(this.head);

        this.isConnected.setBounds(10, 80, 220, 50);
        this.isConnected.addActionListener(this);
        this.isConnected.setBackground(Color.ORANGE);
        this.algoframe.add(this.isConnected);

        this.shortestPathDist.setBounds(260, 80, 220, 50);
        this.shortestPathDist.addActionListener(this);
        this.shortestPathDist.setBackground(Color.ORANGE);
        this.algoframe.add(this.shortestPathDist);

        this.shortestPath.setBounds(10, 140, 220, 50);
        this.shortestPath.addActionListener(this);
        this.shortestPath.setBackground(Color.ORANGE);
        this.algoframe.add(this.shortestPath);

        this.center.setBounds(260, 140, 220, 50);
        this.center.addActionListener(this);
        this.center.setBackground(Color.ORANGE);
        this.algoframe.add(this.center);

        this.tsp.setBounds(10, 200, 220, 50);
        this.tsp.addActionListener(this);
        this.tsp.setBackground(Color.ORANGE);
        this.algoframe.add(this.tsp);

        this.save.setBounds(260, 200, 220, 50);
        this.save.addActionListener(this);
        this.save.setBackground(Color.ORANGE);
        this.algoframe.add(this.save);

        this.loadNew.setBounds(10, 260, 220, 50);
        this.loadNew.addActionListener(this);
        this.loadNew.setBackground(Color.ORANGE);
        this.algoframe.add(this.loadNew);

        this.chang.setBounds(260, 260, 220, 50);
        this.chang.addActionListener(this);
        this.chang.setBackground(Color.ORANGE);
        this.algoframe.add(this.chang);

        this.drowgraph.setBounds(40, 330, 400, 70);
        this.drowgraph.addActionListener(this);
        this.drowgraph.setBackground(Color.ORANGE);
        this.algoframe.add(this.drowgraph);

        this.algoframe.setLayout(null);
        this.algoframe.setSize(width,high);
        this.algoframe.getContentPane().setBackground(Color.gray);
        this.algoframe.setVisible(true);
        this.algoframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.isConnected)
        {
            String st = Boolean.toString(this.thealgo.isConnected());
            this.algoframe.dispose();
            Gui_TextShow tempText =new Gui_TextShow(this.thealgo,st);
        }
        if(event.getSource() == this.shortestPath)
        {
            String[] arr = {"src","dest"};
            this.algoframe.dispose();
            MyDirectedWeightedGraph dg = (MyDirectedWeightedGraph)this.thealgo.getGraph();
            Gui_needInPut tempGUIdist = new Gui_needInPut(dg,"shortestPath",arr);

        }
        if(event.getSource() == this.shortestPathDist)
        {
            String[] arr = {"src","dest"};
            this.algoframe.dispose();
            MyDirectedWeightedGraph dg = (MyDirectedWeightedGraph)this.thealgo.getGraph();
            Gui_needInPut tempGUIdist = new Gui_needInPut(dg,"shortestPathDist",arr);
        }
        if(event.getSource() == this.center)
        {
            List<NodeData> lst = new LinkedList<>();
            lst.add(this.thealgo.center());
            this.algoframe.dispose();
            new Gui_MyGraphDrow(this.thealgo,lst);
        }
        if(event.getSource() == this.tsp)
        {
            this.algoframe.dispose();
            List<NodeData> nls= new LinkedList<>();
            new Gui_addNodeToList(this.thealgo,nls);
        }
        if(event.getSource() == this.save)
        {
            this.algoframe.dispose();
            Gui_LoadASave tempGUIsave = new Gui_LoadASave(this.thealgo,"save");
        }
        if(event.getSource() == this.chang)
        {
            this.algoframe.dispose();
            MyDirectedWeightedGraph mg = (MyDirectedWeightedGraph) this.thealgo.getGraph();
            Gui_Gfunc tempGUIgfunc = new Gui_Gfunc(mg);
        }
        if(event.getSource() == this.loadNew)
        {
            this.algoframe.dispose();
            Gui_LoadASave tempGUInewload = new Gui_LoadASave(this.thealgo , "load");
        }
        if(event.getSource() == this.drowgraph)
        {
            this.algoframe.dispose();
            new Gui_MyGraphDrow(this.thealgo, new LinkedList<>());
        }
    }
}
