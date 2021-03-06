package api;

import java.util.*;

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
        if(this.myEdges.get(src) == null){
            return null;
        }
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
    public Iterator<NodeData> nodeIter() throws RuntimeException{
        int prev_MC = this.mc;
        if(prev_MC != this.mc){
            throw new RuntimeException("MC was changed!");
        }
        return this.myNodes.values().iterator();
    }

    @Override
    public Iterator<EdgeData> edgeIter() throws RuntimeException{
        List<EdgeData> tempList = new LinkedList<>();
        Iterator<EdgeData> tempedgeiter;
        Iterator<NodeData> tempnodeiter = this.nodeIter();
        int prev_MC = this.mc;
        while (tempnodeiter.hasNext()==true)
        {
            if(prev_MC != this.mc){
                throw new RuntimeException("MC was changed!");
            }
            tempedgeiter = this.edgeIter(tempnodeiter.next().getKey());
            while(tempedgeiter.hasNext()==true)
            {
                if(prev_MC != this.mc){
                    throw new RuntimeException("MC was changed!");
                }
                tempList.add(tempedgeiter.next());
            }

        }
        return tempList.iterator();
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) throws RuntimeException{
        int prev_MC = this.mc;
        if(prev_MC != this.mc){
            throw new RuntimeException("MC was changed!");
        }
        return this.myEdges.get(node_id).values().iterator();
    }

    @Override
    public NodeData removeNode(int key) {
        if(this.myNodes.containsKey(key)==true)
        {
            this.nodesSize--;
            this.edgesSize -= this.myEdges.get(key).size();
            this.mc++;
            for(int destnod : this.myNodes.keySet())
            {
                if(this.removeEdge(destnod,key)!=null)
                {
                    this.mc--;
                }
            }
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
        Stack<NodeData> stack = new Stack<>();
        stack.push(node);
        while(stack.isEmpty() == false){
            node = stack.pop();
            if(node.getTag() == 0){
                node.setTag(1);
            }
            Iterator<EdgeData> iter = this.edgeIter((node.getKey()));
            while(iter.hasNext()){
                EdgeData temp = iter.next();
                if(this.getNode(temp.getDest()).getTag() == 0){
                    stack.push(this.getNode(temp.getDest()));
                }
            }
        }
    }

    public void setTags(){
        Iterator<NodeData> iter = this.nodeIter();
        while(iter.hasNext()){
            iter.next().setTag(0);
        }
    }


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
