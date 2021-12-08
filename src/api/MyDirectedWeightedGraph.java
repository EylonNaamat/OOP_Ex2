package api;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyDirectedWeightedGraph implements DirectedWeightedGraph{

    private HashMap<Integer, HashMap<Integer, EdgeData>> myEdges;
    private HashMap<Integer, NodeData> myNodes;
    private int edgesSize;
    private int nodesSize;
    private int mc;

    public MyDirectedWeightedGraph(){
        this.myNodes = new HashMap<>();
        this.myEdges = new HashMap<>();
        this.edgesSize = 0;
        this.nodesSize = 0;
        this.mc = 0;
    }
    public MyDirectedWeightedGraph(HashMap<Integer, NodeData> myNodes, HashMap<Integer, HashMap<Integer,EdgeData>> myEdges){
        this.myNodes = myNodes;
        this.myEdges = myEdges;
        this.nodesSize = myNodes.size();
        this.edgesSize = myEdges.size();
        this.mc = 0;
    }

    public HashMap<Integer, HashMap<Integer, EdgeData>> getMyEdges() {
        return this.myEdges;
    }

    public HashMap<Integer, NodeData> getMyNodes() {
        return this.myNodes;
    }

    @Override
    public NodeData getNode(int key) {
        return this.myNodes.get(key);
    }

    @Override
    public EdgeData getEdge(int src, int dest) {
        return this.myEdges.get(src).get(dest);
    }

    @Override
    public void addNode(NodeData n) {
        NodeData temp = new MyNodeData(n);
        this.myNodes.put(temp.getKey(), temp);
        this.myEdges.put(temp.getKey(),new HashMap<>());
        this.nodesSize++;
        this.mc++;
    }

    @Override
    public void connect(int src, int dest, double w) {
        if(this.myNodes.containsKey(src)==false)
        {
            return;
        }
        EdgeData tempEdge = this.getEdge(src,dest);
        if(tempEdge!=null)
        {
            this.removeEdge(src, dest);
        }
        EdgeData tempMyEdge = new MyEdgeData(src, w ,dest);
        this.myEdges.get(src).put(dest,tempMyEdge);
        this.edgesSize++;
        this.mc++;
    }

    @Override
    public Iterator<NodeData> nodeIter() {
        return this.myNodes.values().iterator();
    }

    @Override
    public Iterator<EdgeData> edgeIter() {
        List<EdgeData> tempList = new LinkedList<>();
        Iterator<EdgeData> tempedgeiter;
        Iterator<NodeData> tempnodeiter = this.nodeIter();
        while (tempnodeiter.hasNext()==true)
        {
            tempedgeiter = this.edgeIter(tempnodeiter.next().getKey());
            while(tempedgeiter.hasNext()==true)
            {
                tempList.add(tempedgeiter.next());
            }

        }
        return tempList.iterator();
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        return this.myEdges.get(node_id).values().iterator();
    }

    @Override
    public NodeData removeNode(int key) {
        if(this.myNodes.containsKey(key)==true)
        {
            this.nodesSize--;
            this.edgesSize -= this.myEdges.get(key).size();
            this.mc++;
            this.myEdges.remove(key);
            return this.myNodes.remove(key);
        }
        return null;
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        if(this.myNodes.containsKey(src)==true)
        {
            EdgeData temp = this.myEdges.get(src).remove(dest);
            if(temp!=null) {
                this.mc++;
                this.edgesSize--;
                return temp;
            }
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

    public void dfs(NodeData node){
        node.setTag(1);
        Iterator<EdgeData> iter = this.edgeIter(node.getKey());
        while(iter.hasNext()){
            int temp = iter.next().getDest();
            NodeData tempNode = this.getNode(temp);
            if(tempNode.getTag() == 0){
                dfs(tempNode);
            }
        }
    }

    public void setTags(){
        Iterator<NodeData> iter = this.nodeIter();
        while(iter.hasNext()){
            iter.next().setTag(0);
        }
    }

//    public MyDirectedWeightedGraph getTranspose2(){
//        MyDirectedWeightedGraph transpose = new MyDirectedWeightedGraph();
//        Iterator<NodeData> nodeIter = this.nodeIter();
//        NodeData temp = nodeIter.next();
//        int first = temp.getKey();
//        Iterator<EdgeData> edgeIter = this.edgeIter(first);
//        while(nodeIter.hasNext()){
//            while(edgeIter.hasNext()){
//                EdgeData next = edgeIter.next();
//                int tempSrc = nodeIter.next().getKey();
//                int tempDest = next.getDest();
//                newEdges.get(tempDest).put(tempSrc,next);
//            }
//        }
//        MyDirectedWeightedGraph newGraph = new MyDirectedWeightedGraph(this.myNodes, newEdges);
//        return newGraph;
//    }

    public MyDirectedWeightedGraph getTranspose(){
        MyDirectedWeightedGraph transpose = new MyDirectedWeightedGraph();
        Iterator<NodeData> Iter = this.nodeIter();
        while(Iter.hasNext()){
            transpose.addNode(Iter.next());
        }
        Iterator<NodeData> nodeIter = this.nodeIter();
        while(nodeIter.hasNext()){
            Iterator<EdgeData> edgeIter = this.edgeIter(nodeIter.next().getKey());
            while(edgeIter.hasNext()){
                EdgeData temp = edgeIter.next();
                transpose.connect(temp.getDest(), temp.getSrc(), temp.getWeight());
            }
        }
        return transpose;
    }
}
