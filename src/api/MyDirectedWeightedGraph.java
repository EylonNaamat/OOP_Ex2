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
        this.mc++;
    }

    @Override
    public void connect(int src, int dest, double w) {
        if(this.myGraph.containsKey(src)==false || this.myGraph.containsKey(dest)==false)
        {
            return;
        }
        EdgeData tempEdge = this.getEdge(src,dest);
        if(tempEdge==null)
        {
            MyEdgeData tempMyEdge = new MyEdgeData(src, w ,dest);
            this.myGraph.get(src).addEdge(tempMyEdge);
            this.edgesSize++;
        }
        else
        {
            this.myGraph.get(src).getEdge(dest).setWeight(w);
        }
        this.mc++;
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
        if(this.myGraph.containsKey(key)==true)
        {
            this.nodesSize--;
            this.edgesSize -= this.myGraph.get(key).getSize();
            this.mc++;
            return this.myGraph.remove(key);
        }
        return null;
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        if(this.myGraph.containsKey(src)==true)
        {
            EdgeData temp = this.myGraph.get(src).removeEdge(dest);
            if(temp!=null)
            {
                this.mc++;
                this.edgesSize--;
            }
            return temp;
        }
        return null;
    }

    @Override
    public int nodeSize() {
        return this.nodesSize;
    }

    @Override
    public int edgeSize() {
        return this.edgesSize;
    }

    @Override
    public int getMC() {
        return this.mc;
    }
}
