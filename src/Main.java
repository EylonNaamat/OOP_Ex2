import guiapi.*;
import api.*;
public class Main {
    public static <Gui_load> void main(String[] args) {
        MyDirectedWeightedGraphAlgorithms algo = new MyDirectedWeightedGraphAlgorithms();
        algo.load("C:\\Users\\Dell\\IdeaProjects\\OOP_Ex2\\data\\G3.json");
        System.out.println(algo.getGraph().edgeSize());
        System.out.println(algo.getGraph().nodeSize());


        Gui_Menu astart = new Gui_Menu();
    }
}