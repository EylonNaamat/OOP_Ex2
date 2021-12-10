package guiapi;

import api.MyDirectedWeightedGraph;
import api.MyDirectedWeightedGraphAlgorithms;

public class main2 {

    public static void main(String[] args) {
        MyDirectedWeightedGraphAlgorithms algo = new MyDirectedWeightedGraphAlgorithms();
        algo.load("C:\\Users\\Dell\\IdeaProjects\\OOP_Ex2\\data\\G1.json");
        new Gui_Menu();
        new Gui_MyGraphDrow(algo);
    }
}
