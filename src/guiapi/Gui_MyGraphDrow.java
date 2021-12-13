package guiapi;

import api.DirectedWeightedGraphAlgorithms;
import api.MyDirectedWeightedGraph;
import api.MyDirectedWeightedGraphAlgorithms;
import api.NodeData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Gui_MyGraphDrow extends JFrame implements ActionListener{

    private MyDirectedWeightedGraphAlgorithms algo ;
    private Gui_GraphPamelhelper workPanel;
    public Gui_MyGraphDrow(MyDirectedWeightedGraphAlgorithms algo, List<NodeData> mylist)
    {
        this.algo = algo;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.workPanel = new Gui_GraphPamelhelper((MyDirectedWeightedGraph)algo.getGraph(),mylist);
        this.add(this.workPanel);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.workPanel.edit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()== this.workPanel.edit)
        {
            this.dispose();
            new Gui_algo(this.algo);
        }
    }
}
