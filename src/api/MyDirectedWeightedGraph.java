package api;

import java.util.HashMap;
import java.util.Iterator;

public class MyDirectedWeightedGraph implements DirectedWeightedGraph{

    private HashMap<Integer, MyNodeData> myGraph;
    private int edgesSize;
    private int nodesSize;
    private int mc;

    public MyDirectedWeightedGraph(){
        this.myGraph = new HashMap<>();
        this.edgesSize = 0;
        this.nodesSize = 0;
        this.mc = 0;
    }

    @Override
    public NodeData getNode(int key) {
        return this.myGraph.get(key);
    }

    @Override
    public EdgeData getEdge(int src, int dest) {
        return this.myGraph.get(src).getEdge(dest);
    }

    @Override
    public void addNode(NodeData n) {
        MyNodeData temp = new MyNodeData(n.getKey(), n.getLocation());
        this.myGraph.put(n.getKey(), temp);
        this.nodesSize++;
        this.edgesSize += this.myGraph.get(n.getKey()).getSize();
    }

    @Override
    public void connect(int src, int dest, double w) {

    }

    @Override
    public Iterator<NodeData> nodeIter() {
        return null;
    }

    @Override
    public Iterator<EdgeData> edgeIter() {
        return null;
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        return null;
    }

    @Override
    public NodeData removeNode(int key) {
        return null;
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        return null;
    }

    @Override
    public int nodeSize() {
        return 0;
    }

    @Override
    public int edgeSize() {
        return 0;
    }

    @Override
    public int getMC() {
        return 0;
    }
}
