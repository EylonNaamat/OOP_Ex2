import guiapi.*;
import api.*;
public class Main {
    public static <Gui_load> void main(String[] args) {
        MyDirectedWeightedGraphAlgorithms algo = new MyDirectedWeightedGraphAlgorithms();
        algo.load("C:\\Users\\eylon\\IdeaProjects\\OOP_Ex2\\data\\G3.json");
        System.out.println(algo.getGraph().edgeSize());
        System.out.println(algo.getGraph().nodeSize());

        DirectedWeightedGraph graph = Ex2.getGrapg("C:\\Users\\eylon\\IdeaProjects\\OOP_Ex2\\data\\G1.json");
        graph.getNode(0);
        System.out.println(graph.getNode(0).getLocation().x());

        DirectedWeightedGraphAlgorithms graph2 = Ex2.getGrapgAlgo("C:\\Users\\eylon\\IdeaProjects\\OOP_Ex2\\data\\G1.json");
        System.out.println(graph2.isConnected());
        System.out.println(graph2.center().getKey());


        Gui_Menu astart = new Gui_Menu();
    }
}