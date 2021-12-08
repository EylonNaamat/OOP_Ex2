package api;
import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class MyGsonGraph {
    private List<NodeData> Nodes;
    private List<EdgeData> Edges;

    public MyGsonGraph ()
    {
        this.Nodes = new LinkedList<>();
        this.Edges = new LinkedList<>();
    }
    public MyGsonGraph (MyDirectedWeightedGraph myGraph)
    {
        this.Nodes = new LinkedList<>();
        this.Edges = new LinkedList<>();
        for(NodeData nod : myGraph.getMyNodes().values())
        {
            for(EdgeData edg : myGraph.getMyEdges().get(nod.getKey()).values())
            {
                this.Edges.add(edg);
            }
            this.Nodes.add(nod);
        }
    }
    public List<NodeData> getNodes() {
        return this.Nodes;
    }

    public List<EdgeData> getEdges() {
        return this.Edges;
    }

    public boolean load(String fileName)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        MyGsonGraph newFrong = gson.fromJson(fileName, MyGsonGraph.class);
        this.Edges=newFrong.Edges;
        this.Nodes=newFrong.Nodes;
        return true;
    }
    public boolean save(String fileName)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(this);
        try
        {
            PrintWriter mywrite = new PrintWriter(fileName);
            mywrite.write(json);
            mywrite.close();
            return true;
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            return false;
        }
    }


}
