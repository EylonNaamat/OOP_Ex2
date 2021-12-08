package api;
import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class MyGsonGraph {
    private List<MyGsonNode> Nodes;
    private List<MyGsonEdge> Edges;

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
                MyGsonEdge tempedg = new MyGsonEdge(edg);
                this.Edges.add(tempedg);
            }
            MyGsonNode tempnod = new MyGsonNode(nod);
            this.Nodes.add(tempnod);
        }
    }
    public List<MyGsonNode> getNodes() {
        return this.Nodes;
    }

    public List<MyGsonEdge> getEdges() {
        return this.Edges;
    }

    public boolean load(String fileName)
    {

        try
        {
            Gson gson = new Gson();
            FileReader myread = new FileReader(fileName);
            MyGsonGraph mygraph = gson.fromJson(myread,MyGsonGraph.class);
            this.Edges=mygraph.getEdges();
            this.Nodes=mygraph.getNodes();
            return true;

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            return false;
        }
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
