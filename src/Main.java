import api.MyDirectedWeightedGraphAlgorithms;
import api.MyGsonGraph;

public class Main {
    public static void main(String[] args) {
        MyDirectedWeightedGraphAlgorithms algo = new MyDirectedWeightedGraphAlgorithms();
        algo.load("C:\\Users\\eylon\\IdeaProjects\\OOP_Ex2\\src\\api\\G1.json");
        System.out.println(algo.getGraph().edgeSize());
        System.out.println(algo.getGraph().nodeSize());
    }
}