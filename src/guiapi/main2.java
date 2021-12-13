package guiapi;

import api.MyDirectedWeightedGraph;
import api.MyDirectedWeightedGraphAlgorithms;

public class main2 {

    public static void main(String[] args) {
        MyDirectedWeightedGraphAlgorithms trstAlgo = new MyDirectedWeightedGraphAlgorithms();
        new Gui_Menu(trstAlgo);
    }
}
