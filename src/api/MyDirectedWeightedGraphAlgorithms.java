package api;

import java.util.ArrayList;
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
        MyDirectedWeightedGraph graph = (MyDirectedWeightedGraph)(this.copy());
        graph.setTags();
        Iterator<NodeData> nodeIter = graph.nodeIter();
        NodeData first = graph.getNode(nodeIter.next().getKey());
        graph.dfs(first);
        while(nodeIter.hasNext()){
            if(nodeIter.next().getTag() == 0){
                return false;
            }
        }

        MyDirectedWeightedGraph transposeGraph = graph.getTranspose();
        transposeGraph.setTags();
        Iterator<NodeData> nodeItert = graph.nodeIter();
        transposeGraph.dfs(first);
        while(nodeItert.hasNext()){
            if(nodeItert.next().getTag() == 0){
                return false;
            }
        }
        return true;
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
            result.add(0,tempNode);
            tempNode=temp.getMyNodes().get(tempNode.getTag());
        }
        result.add(0,tempNode);
        return result;
    }

    @Override
    public NodeData center() {
        double min =-1.0;
        NodeData maxNode= null;
        if(this.isConnected()==false)
        {
            return null;
        }
        for(NodeData nod : this.myGraph.getMyNodes().values())
        {
            double temp = maxDist(nod.getKey());
            if(temp<min||min==-1.0)
            {
                min=temp;
                maxNode=nod;
            }
        }
        return maxNode;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        List<NodeData> ans = new ArrayList<>();
        MyDirectedWeightedGraph tempGrath;
        NodeData city = cities.get(0);
        NodeData destcity = city;
        while((city != null) && (cities.size()!=1))
        {
            cities.remove(city);
            tempGrath = this.dijkstraAlgo(city.getKey());
            double mindist =0.0;
            for (NodeData nod : cities)
            {
                NodeData tempnode = tempGrath.getMyNodes().get(nod.getKey());
                if(tempnode.getTag()==-1)
                {
                    return null;
                }
                if((mindist==0.0)||(tempnode.getWeight()<mindist))
                {
                    mindist =tempnode.getWeight();
                    destcity = nod;
                }
            }
            ans.addAll(shortestPath(city.getKey(),destcity.getKey()));
            ans.remove(ans.size()-1);
            city=destcity;
            mindist=0.0;
            
        }
        ans.add(city);
        return ans;
    }

    @Override
    public boolean save(String file) { // in the video minute 5:56
        MyGsonGraph temp = new MyGsonGraph(this.myGraph);
        return temp.save(file);
    }

    @Override
    public boolean load(String file) {
        MyGsonGraph tempG = new MyGsonGraph();
        Boolean ans = tempG.load(file);
        if(ans == false)
        {
            return false;
        }
        this.myGraph = new MyDirectedWeightedGraph();
        for(MyGsonNode nod : tempG.getNodes())
        {
            this.myGraph.addNode(nod);
        }
        for(MyGsonEdje edg : tempG.getEdges())
        {
            this.myGraph.connect(edg.getSrc(),edg.getDest(),edg.getWeight());
        }
        return true;
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

    public double maxDist(int src)
    {
        MyDirectedWeightedGraph result = dijkstraAlgo(src);
        double max = 0 ;
        for(NodeData nod : result.getMyNodes().values())
        {
            if(max<nod.getWeight())
            {
                max = nod.getWeight();
            }
        }
        return max;
    }
}
