package api;

import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyDirectedWeightedGraphAlgorithmsTest {
    MyGeoLocation gl1 = new MyGeoLocation(1,2,0);
    MyNodeData nd1 = new MyNodeData(1,gl1);
    MyGeoLocation gl2 = new MyGeoLocation(4.5,3.5,0);
    MyNodeData nd2 = new MyNodeData(2,gl2);
    MyGeoLocation gl3 = new MyGeoLocation(10,15.3,0);
    MyNodeData nd3 = new MyNodeData(3,gl3);
    MyGeoLocation gl4 = new MyGeoLocation(8.7,2.4,0);
    MyNodeData nd4 = new MyNodeData(4,gl4);
    MyGeoLocation gl5 = new MyGeoLocation(9,1,0);
    MyNodeData nd5 = new MyNodeData(5,gl5);
    MyGeoLocation gl6 = new MyGeoLocation(14,11,0);
    MyNodeData nd6 = new MyNodeData(6,gl6);
    MyGeoLocation gl7 = new MyGeoLocation(20,8,0);
    MyNodeData nd7 = new MyNodeData(7,gl7);


    MyGeoLocation lc1 = new MyGeoLocation(1,2,0);
    MyNodeData n1 = new MyNodeData(1,lc1);
    MyGeoLocation lc2 = new MyGeoLocation(4.5,3.5,0);
    MyNodeData n2 = new MyNodeData(2,lc2);
    MyGeoLocation lc3 = new MyGeoLocation(10,15.3,0);
    MyNodeData n3 = new MyNodeData(3,lc3);
    MyGeoLocation lc4 = new MyGeoLocation(8.7,2.4,0);
    MyNodeData n4 = new MyNodeData(4,lc4);

    MyDirectedWeightedGraphAlgorithms graph1 = new MyDirectedWeightedGraphAlgorithms();

    public void insert(MyDirectedWeightedGraph g1){
        g1.addNode(nd1);
        g1.addNode(nd2);
        g1.addNode(nd3);
        g1.addNode(nd4);
        g1.addNode(nd5);
        g1.addNode(nd6);
        g1.addNode(nd7);


        g1.connect(1,3,2);
        g1.connect(1,4,2);
        g1.connect(1,5,15);
        g1.connect(1,7,40);
        g1.connect(2,1,20);
        g1.connect(2,5,23);
        g1.connect(3,2,9);
        g1.connect(3,4,8);
        g1.connect(4,7,50);
        g1.connect(5,3,17);
        g1.connect(5,7,5);
        g1.connect(7,4,32);
    }

    public void insert2(MyDirectedWeightedGraph g1){
        g1.addNode(nd1);
        g1.addNode(nd2);
        g1.addNode(nd3);
        g1.addNode(nd4);


        g1.connect(1,2,4);
        g1.connect(2,3,7);
        g1.connect(3,4,5);
        g1.connect(4,1,10);
    }

    public void insert3(MyDirectedWeightedGraph g1){
        g1.addNode(nd1);
        g1.addNode(nd2);
        g1.addNode(nd3);
        g1.addNode(nd4);


        g1.connect(1,2,10);
        g1.connect(1,3,15);
        g1.connect(1,4,20);
        g1.connect(2,1,5);
        g1.connect(2,3,9);
        g1.connect(2,4,10);
        g1.connect(3,1,6);
        g1.connect(3,2,13);
        g1.connect(3,4,12);
        g1.connect(4,1,8);
        g1.connect(4,2,8);
        g1.connect(4,3,9);
    }

    public void insert4(MyDirectedWeightedGraph g1){
        g1.addNode(nd1);
        g1.addNode(nd2);
        g1.addNode(nd3);
        g1.addNode(nd4);
        g1.addNode(nd5);



        g1.connect(1,2,7);
        g1.connect(1,3,5);
        g1.connect(1,4,12);
        g1.connect(1,5, 17);
        g1.connect(2,1,8);
        g1.connect(2,3,9);
        g1.connect(2,4,10);
        g1.connect(2,5,4);
        g1.connect(3,1,3);
        g1.connect(3,2,20);
        g1.connect(3,4,13);
        g1.connect(3,5,15);
        g1.connect(4,1,11);
        g1.connect(4,2,21);
        g1.connect(4,3,7);
        g1.connect(4,5,12);
        g1.connect(5,1,16);
        g1.connect(5,2,18);
        g1.connect(5,3,23);
        g1.connect(5,4,20);
    }


    @Test
    void init() {
        MyDirectedWeightedGraph g2 = new MyDirectedWeightedGraph();
        insert(g2);
        graph1.init(g2);
        assertEquals(graph1.getGraph().getEdge(1,3).getDest(), 3);
        assertEquals(graph1.getGraph().getNode(4).getLocation().x(), 8.7);
        assertEquals(graph1.getGraph().getEdge(2,1).getDest(), 1);
        g2.removeEdge(2,1);
        assertEquals(graph1.getGraph().getEdge(2,1), null);
    }

    @Test
    void getGraph() {
        MyDirectedWeightedGraph g2 = new MyDirectedWeightedGraph();
        insert(g2);
        graph1.init(g2);
        assertEquals(graph1.getGraph().getEdge(2,1).getDest(), 1);
        assertEquals(graph1.getGraph().getNode(1).getLocation().x(), 1);
        assertEquals(graph1.getGraph().getEdge(7,4).getDest(), 4);
        g2.removeEdge(1,7);
        assertEquals(graph1.getGraph().getEdge(1,7), null);
    }

    @Test
    void copy() {
        MyDirectedWeightedGraph g2 = new MyDirectedWeightedGraph();
        insert(g2);
        graph1.init(g2);
        MyDirectedWeightedGraph g3 = (MyDirectedWeightedGraph)(graph1.copy());
        assertEquals(g2.getEdge(2,1).getDest(), 1);
        g2.removeNode(2);
        assertEquals(g3.getEdge(2,1).getDest(), 1);
        assertEquals(g2.getNode(2), null);
    }

    @Test
    void isConnected() {
        MyDirectedWeightedGraph g2 = new MyDirectedWeightedGraph();
        insert2(g2);
        graph1.init(g2);
        assertEquals(graph1.isConnected(), true);
        graph1.getGraph().removeEdge(2,3);
        assertEquals(graph1.isConnected(), false);
        MyDirectedWeightedGraph g3 = new MyDirectedWeightedGraph();
        insert(g3);
        graph1.init(g3);
        assertEquals(graph1.isConnected(), false);
    }

    @Test
    void shortestPathDist() {
        MyDirectedWeightedGraph g2 = new MyDirectedWeightedGraph();
        insert(g2);
        graph1.init(g2);
        assertEquals(graph1.shortestPathDist(1,7), 20);
        graph1.getGraph().connect(3,5,40);
        assertEquals(graph1.shortestPathDist(3,5), 32);
        assertEquals(graph1.shortestPathDist(1,2), 11);
        graph1.getGraph().connect(1,2,10);
        assertEquals(graph1.shortestPathDist(1,2), 10);
    }

    @Test
    void shortestPath() {
        MyDirectedWeightedGraph g2 = new MyDirectedWeightedGraph();
        insert(g2);
        graph1.init(g2);
        List<NodeData> path1 = new LinkedList<>();
        path1.add(nd1);
        path1.add(nd5);
        path1.add(nd7);
        List<NodeData> afterFunc = graph1.shortestPath(1,7);
        for (int i = 0; i < path1.size(); i++) {
            assertEquals(path1.get(i).getKey(), afterFunc.get(i).getKey());
        }
        graph1.getGraph().connect(3,5,40);
        List<NodeData> path2 = new LinkedList<>();
        path2.add(nd3);
        path2.add(nd2);
        path2.add(nd5);
        afterFunc = graph1.shortestPath(3,5);
        for (int i = 0; i < path2.size(); i++) {
            assertEquals(path2.get(i).getKey(), afterFunc.get(i).getKey());
        }
    }

    @Test
    void center() {
        MyDirectedWeightedGraph g2 = new MyDirectedWeightedGraph();
        insert3(g2);
        graph1.init(g2);
        assertEquals(graph1.center().getKey(), 4);
        MyDirectedWeightedGraphAlgorithms graph2 = new MyDirectedWeightedGraphAlgorithms();
        graph2.load("C:\\Users\\eylon\\IdeaProjects\\OOP_Ex2\\data\\G1.json");
    }

    @Test
    void tsp() {
        MyDirectedWeightedGraph g2 = new MyDirectedWeightedGraph();
        insert3(g2);
        graph1.init(g2);
        List<NodeData> cities = new LinkedList<>();
        cities.add(n1);
        cities.add(n2);
        cities.add(n3);
        cities.add(n4);

        List<NodeData> ans = new LinkedList<>();
        ans.add(n1);
        ans.add(n2);
        ans.add(n3);
        ans.add(n4);
        List<NodeData> funcAns = graph1.tsp(cities);
        for (int i = 0; i < funcAns.size(); i++) {
            assertEquals(ans.get(i).getKey(), funcAns.get(i).getKey());
        }

        insert4(g2);
        graph1.init(g2);
        List<NodeData> cities2 = new LinkedList<>();
        cities2.add(nd1);
        cities2.add(nd2);
        cities2.add(nd3);
        cities2.add(nd4);
        cities2.add(nd5);

        List<NodeData> ans2 = new LinkedList<>();
        ans2.add(nd1);
        ans2.add(nd3);
        ans2.add(nd1);
        ans2.add(nd2);
        ans2.add(nd5);
        ans2.add(nd4);
        List<NodeData> funcAns2 = graph1.tsp(cities2);

        for (int i = 0; i < funcAns2.size(); i++) {
            assertEquals(ans2.get(i).getKey(), funcAns2.get(i).getKey());
        }

    }

    @Test
    void save() {
        MyDirectedWeightedGraph g2 = new MyDirectedWeightedGraph();
        insert(g2);
        graph1.init(g2);
        graph1.save("Eylon.json");
        MyDirectedWeightedGraphAlgorithms graph2 = new MyDirectedWeightedGraphAlgorithms();
        graph2.load("C:\\Users\\eylon\\IdeaProjects\\OOP_Ex2\\Eylon.json");
        assertEquals(graph1.isConnected(), graph2.isConnected());
        assertEquals(graph1.shortestPathDist(1,7), graph2.shortestPathDist(1,7));
        assertEquals(graph1.getGraph().nodeSize(), graph2.getGraph().nodeSize());
        assertEquals(graph1.getGraph().edgeSize(), graph2.getGraph().edgeSize());
    }

    @Test
    void load() {
        MyDirectedWeightedGraph g2 = new MyDirectedWeightedGraph();
        insert(g2);
        graph1.init(g2);
        graph1.save("EylonMichael.json");
        MyDirectedWeightedGraphAlgorithms graph2 = new MyDirectedWeightedGraphAlgorithms();
        graph2.load("C:\\Users\\eylon\\IdeaProjects\\OOP_Ex2\\EylonMichael.json");
        assertEquals(graph1.isConnected(), graph2.isConnected());
        assertEquals(graph1.shortestPathDist(1,3), graph2.shortestPathDist(1,3));
        assertEquals(graph1.getGraph().nodeSize(), graph2.getGraph().nodeSize());
        assertEquals(graph1.getGraph().edgeSize(), graph2.getGraph().edgeSize());
        graph2.load("C:\\Users\\eylon\\IdeaProjects\\OOP_Ex2\\data\\G1.json");
        assertEquals(graph2.center().getKey(), 8);
        assertEquals(graph2.isConnected(), true);
        graph2.load("C:\\Users\\eylon\\IdeaProjects\\OOP_Ex2\\data\\G2.json");
        assertEquals(graph2.center().getKey(), 0);
        assertEquals(graph2.isConnected(), true);
        graph2.load("C:\\Users\\eylon\\IdeaProjects\\OOP_Ex2\\data\\G3.json");
        assertEquals(graph2.center().getKey(), 40);
        assertEquals(graph2.isConnected(), true);


    }
}