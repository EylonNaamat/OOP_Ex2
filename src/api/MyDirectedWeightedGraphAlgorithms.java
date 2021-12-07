package api;

import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class MyDirectedWeightedGraphAlgorithms implements DirectedWeightedGraphAlgorithms{


    private MyDirectedWeightedGraph myGraph;

    public MyDirectedWeightedGraphAlgorithms(){
        this.myGraph = new MyDirectedWeightedGraph();
    }

    @Override
    public void init(DirectedWeightedGraph g) {
        this.myGraph = new MyDirectedWeightedGraph();
        Iterator<EdgeData> tempEdgeiter;
        Iterator<NodeData> tempNodeiter = g.nodeIter();
        while (tempNodeiter.hasNext()==true)
        {
            NodeData tempNode = tempNodeiter.next();
            this.myGraph.addNode(tempNode);
            tempEdgeiter = g.edgeIter(tempNode.getKey());
            while(tempEdgeiter.hasNext()==true)
            {
                EdgeData tempEdge = tempEdgeiter.next();
                this.myGraph.connect(tempEdge.getSrc(),tempEdge.getDest(),tempEdge.getWeight());
            }

        }
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return this.myGraph;
    }

    @Override
    public DirectedWeightedGraph copy() {
        MyDirectedWeightedGraphAlgorithms temp = new MyDirectedWeightedGraphAlgorithms();
        temp.init(this.myGraph);
        return temp.getGraph();
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
    public boolean save(String file) {
        Gson gson = new Gson();
        Iterator<EdgeData> iterEdge = this.myGraph.edgeIter();
        Iterator<NodeData> iterNode = this.myGraph.nodeIter();
        try{
            FileWriter fw = new FileWriter(file);
            while(iterEdge.hasNext()) {
                String jsonEdge = gson.toJson(iterEdge.next());
                fw.write((gson.toJson(jsonEdge)));
            }
            while(iterNode.hasNext()){
                String jsonNode = gson.toJson(iterNode.next());
                fw.write((gson.toJson(jsonNode)));
            }
            fw.close();
            return true;
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean load(String file) {
        return false;
    }
}
