package api;

import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class MyDirectedWeightedGraphAlgorithms implements DirectedWeightedGraphAlgorithms{


    private MyDirectedWeightedGraph myGraph;

    public MyDirectedWeightedGraphAlgorithms(){
        this.myGraph = new MyDirectedWeightedGraph();
    }

    @Override
    public void init(DirectedWeightedGraph g) {
        this.myGraph=(MyDirectedWeightedGraph) g;
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return this.myGraph;
    }

    @Override
    public DirectedWeightedGraph copy() {
        MyDirectedWeightedGraph temp = new MyDirectedWeightedGraph();
        Iterator<EdgeData> tempEdgeiter;
        Iterator<NodeData> tempNodeiter = this.myGraph.nodeIter();
        while (tempNodeiter.hasNext()==true)
        {
            NodeData tempNode = tempNodeiter.next();
            temp.addNode(tempNode);
            tempEdgeiter = this.myGraph.edgeIter(tempNode.getKey());
            while(tempEdgeiter.hasNext()==true)
            {
                EdgeData tempEdge = tempEdgeiter.next();
                temp.connect(tempEdge.getSrc(),tempEdge.getDest(),tempEdge.getWeight());
            }

        }
        return temp;
    }

    @Override
    public boolean isConnected() {
        return false;
    }



    @Override
    public double shortestPathDist(int src, int dest) {
        return 0;
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        return null;
    }

    @Override
    public NodeData center() {
        return null;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        return null;
    }

    @Override
    public boolean save(String file) { // in the video minute 5:56
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(this.myGraph);
        try{
            PrintWriter pw = new PrintWriter(file);
            pw.write(json);
            pw.close();
            return true;
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean load(String file) {

        return false;
    }
}
