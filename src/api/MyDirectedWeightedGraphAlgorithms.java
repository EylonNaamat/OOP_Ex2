package api;

import com.google.gson.*;
import org.w3c.dom.Node;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
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
        MyDirectedWeightedGraph temp = this.dijkstraAlgo(src);
        if(temp.getMyNodes().get(dest).getTag()==-1)
        {
            return -1;
        }
        return temp.getMyNodes().get(dest).getWeight();
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        MyDirectedWeightedGraph temp = this.dijkstraAlgo(src);
        List<NodeData> result = new LinkedList<>();
        NodeData tempNode = temp.getMyNodes().get(dest);
        if(tempNode.getTag()==-1)
        {
            return null;
        }
        while(tempNode.getTag()!=-1)
        {
            result.add(tempNode);
            tempNode=temp.getMyNodes().get(tempNode.getTag());
        }
        result.add(tempNode);
        return result;
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
    public MyDirectedWeightedGraph dijkstraAlgo(int src)
    {
        MyDirectedWeightedGraph results = (MyDirectedWeightedGraph)this.copy();
        for(NodeData nod : results.getMyNodes().values())
        {
            nod.setTag(-1);
            nod.setWeight(0.0);
            nod.setInfo("W");
        }
        int runkey = src;
        NodeData runNode = results.getNode(runkey);
        while(runkey!=-1)
        {
            runNode.setInfo("B");
            for(EdgeData temp : results.getMyEdges().get(runkey).values())
            {
                NodeData tempNode = results.getNode(temp.getDest());
                if(tempNode.getInfo()=="W")
                {
                    if((tempNode.getWeight()==0.0)||(tempNode.getWeight()>(temp.getWeight()+runNode.getWeight())))
                    {
                        tempNode.setWeight(temp.getWeight()+runNode.getWeight());
                        tempNode.setTag(runkey);
                    }
                }
            }
            runkey=-1;
            runNode = null;
            for(NodeData nod : results.getMyNodes().values())
            {
                if((nod.getInfo() == "W")&&(nod.getTag()!=-1))
                {
                    if(runkey==-1)
                    {
                        runkey = nod.getKey();
                        runNode=nod;
                    }
                    else
                    {
                        if(nod.getWeight()<runNode.getWeight())
                        {
                            runkey = nod.getKey();
                            runNode=nod;
                        }
                    }
                }
            }
        }
    return results;
    }
}
