package guiapi;

import api.DirectedWeightedGraphAlgorithms;
import api.MyDirectedWeightedGraph;
import api.MyDirectedWeightedGraphAlgorithms;

import javax.swing.*;
import java.awt.*;

public class Gui_MyGraphDrow extends JFrame {

    private MyDirectedWeightedGraphAlgorithms algo;
    private Gui_GraphPamelhelper workPanel;
    public Gui_MyGraphDrow(MyDirectedWeightedGraphAlgorithms algo)
    {
        this.algo = algo;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.workPanel = new Gui_GraphPamelhelper((MyDirectedWeightedGraph)this.algo.getGraph());
        this.add(this.workPanel);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
