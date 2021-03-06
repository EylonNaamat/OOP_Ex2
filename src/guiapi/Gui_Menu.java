package guiapi;


import api.DirectedWeightedGraphAlgorithms;
import api.MyDirectedWeightedGraph;
import api.MyDirectedWeightedGraphAlgorithms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_Menu implements ActionListener {
    private int width = 500;
    private int high = 500;
    private MyDirectedWeightedGraphAlgorithms Myalgo;
    private JFrame menuframe = new JFrame("menu");
    private JLabel head = new JLabel("menu:");
    private JButton newGraph = new JButton("creat new empty graph");
    private JButton loadgraph = new JButton("load graph from file");

    public Gui_Menu()
    {
        this.Myalgo = new MyDirectedWeightedGraphAlgorithms();
        this.head.setBounds(140,50,150,50);
        this.head.setFont(new Font(null,Font.BOLD,30));
        this.menuframe.add(this.head);

        this.newGraph.setBounds(140,150,200,70);
        this.newGraph.addActionListener(this);
        this.newGraph.setBackground(Color.ORANGE);
        this.menuframe.add(this.newGraph);

        this.loadgraph.setBounds(140,300,200,70);
        this.loadgraph.addActionListener(this);
        this.loadgraph.setBackground(Color.ORANGE);
        this.menuframe.add(this.loadgraph);

        this.menuframe.setLayout(null);
        this.menuframe.setSize(width,high);
        this.menuframe.getContentPane().setBackground(Color.gray);
        this.menuframe.setVisible(true);
        this.menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public Gui_Menu(DirectedWeightedGraphAlgorithms alg)
    {
        this.Myalgo = (MyDirectedWeightedGraphAlgorithms) alg;
        this.menuframe.dispose();
        new Gui_LoadASavesuccessful(this.Myalgo,"load");

    }
    public JFrame getframe()
    {
        return this.menuframe;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==this.newGraph)
        {
            this.menuframe.dispose();
            new Gui_Gfunc(new MyDirectedWeightedGraphAlgorithms());
        }
        if(event.getSource()==this.loadgraph)
        {
            this.menuframe.dispose();
            Gui_LoadASave nextGUIload = new Gui_LoadASave(new MyDirectedWeightedGraphAlgorithms(),"load");

        }
    }
}
