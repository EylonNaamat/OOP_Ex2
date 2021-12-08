package api;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MyDirectedWeightedGraphTest {
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

    MyEdgeData ed1 = new MyEdgeData(1,5,2);
    MyEdgeData ed2 = new MyEdgeData(1,10,3);
    MyEdgeData ed3 = new MyEdgeData(1,14,4);
    MyEdgeData ed4 = new MyEdgeData(2,20,5);
    MyEdgeData ed5 = new MyEdgeData(2,12,3);
    MyEdgeData ed6 = new MyEdgeData(4,17,3);
    MyEdgeData ed7 = new MyEdgeData(5,30,1);
    MyEdgeData ed8 = new MyEdgeData(5,7,6);
    MyEdgeData ed9 = new MyEdgeData(6,25,4);

    HashMap<Integer, NodeData> nodes = new HashMap<>();
    HashMap<Integer, HashMap<Integer, EdgeData>> edges = new HashMap<>();
    HashMap<Integer, EdgeData> hash1 = new HashMap<>();
    HashMap<Integer, EdgeData> hash2 = new HashMap<>();
    HashMap<Integer, EdgeData> hash3 = new HashMap<>();
    HashMap<Integer, EdgeData> hash4 = new HashMap<>();
    HashMap<Integer, EdgeData> hash5 = new HashMap<>();
    HashMap<Integer, EdgeData> hash6 = new HashMap<>();

    public void insert(){
        nodes.put(nd1.getKey(), nd1);
        nodes.put(nd2.getKey(), nd2);
        nodes.put(nd3.getKey(), nd3);
        nodes.put(nd4.getKey(), nd4);
        nodes.put(nd5.getKey(), nd5);
        nodes.put(nd6.getKey(), nd6);


        hash1.put(ed1.getDest(), ed1);
        hash1.put(ed2.getDest(), ed2);
        hash1.put(ed3.getDest(), ed3);
        hash2.put(ed4.getDest(), ed4);
        hash2.put(ed5.getDest(), ed5);
        hash4.put(ed6.getDest(), ed6);
        hash5.put(ed7.getDest(), ed7);
        hash5.put(ed8.getDest(), ed8);
        hash6.put(ed9.getDest(), ed9);

        edges.put(nd1.getKey(), hash1);
        edges.put(nd2.getKey(), hash2);
        edges.put(nd3.getKey(), hash3);
        edges.put(nd4.getKey(), hash4);
        edges.put(nd5.getKey(), hash5);
        edges.put(nd6.getKey(), hash6);
    }
    MyDirectedWeightedGraph g2 = new MyDirectedWeightedGraph(nodes, edges);


    @Test
    void getMyEdges() {
        insert();
        HashMap<Integer, HashMap<Integer,EdgeData>> h1 = g2.getMyEdges();
        assertEquals(h1.get(1).get(2).getWeight(), g2.getMyEdges().get(1).get(2).getWeight());
        assertEquals(h1.get(2).get(5).getDest(), g2.getMyEdges().get(2).get(5).getDest());
        assertEquals(h1.get(5).get(1).getSrc(), 5);
    }

    @Test
    void getMyNodes() {
        insert();
        HashMap<Integer, NodeData> h1 = g2.getMyNodes();
        assertEquals(h1.get(1).getKey(), g2.getMyNodes().get(1).getKey());
        assertEquals(h1.get(1).getKey(), 1);
        assertEquals(h1.get(3).getKey(), 3);
    }

    @Test
    void getNode() {
        insert();
        assertEquals(g2.getNode(3).getLocation().y(), 15.3);
        assertEquals(g2.getNode(6).getKey(), 6);
        assertEquals(g2.getNode(7), null);
    }

    @Test
    void getEdge() {
        insert();
        assertEquals(g2.getEdge(2, 5).getWeight(), 20);
        assertEquals(g2.getEdge(1,8), null);
        assertEquals(g2.getEdge(6, 4).getSrc(), 6);
        assertEquals(g2.getEdge(5,1).getDest(), g2.getEdge(1,2).getSrc());
    }

    @Test
    void addNode() {
        MyGeoLocation l1 = new MyGeoLocation(100,42,0);
        NodeData node1 = new MyNodeData(8, l1);
        g2.addNode(node1);
        assertEquals(g2.getNode(8).getLocation().x(), 100);
        MyGeoLocation l2 = new MyGeoLocation(32,7,0);
        NodeData node2 = new MyNodeData(100, l2);
        g2.addNode(node2);
        assertEquals(g2.getNode(100).getKey(), 100);
        MyGeoLocation l3 = new MyGeoLocation(8,24,0);
        NodeData node3 = new MyNodeData(100, l3);
        g2.addNode(node3);
        assertEquals(g2.getNode(100).getLocation().x(), 8);
        assertNotEquals(g2.getNode(100).getLocation().x(), 32);
    }

    @Test
    void connect() {
        insert();
        g2.connect(1,5, 42);
        assertEquals(g2.getEdge(1,5).getWeight(), 42);
        g2.connect(1,5,24);
        assertNotEquals(g2.getEdge(1,5).getWeight(), 42);
        g2.connect(6,2,11);
        assertEquals(g2.getEdge(6,2).getSrc(), 6);
    }

    @Test
    void nodeIter() {
    }

    @Test
    void edgeIter() {
    }

    @Test
    void testEdgeIter() {
    }

    @Test
    void removeNode() {
        insert();
        assertEquals(g2.getMyNodes().containsKey(1), true);
        assertEquals(g2.getMyEdges().containsKey(1), true);

        g2.removeNode(1);
        assertEquals(g2.getMyNodes().containsKey(1), false);
        assertEquals(g2.getMyEdges().get(1), null);
        assertEquals(g2.getMyEdges().containsKey(1), false);
//        assertEquals(g2.getMyEdges().get(5).get(1), null);
    }

    @Test
    void removeEdge() {
        insert();
        assertEquals(g2.getEdge(1,3).getSrc(), 1);
        g2.removeEdge(1,3);
        assertEquals(g2.getEdge(1,3), null);
        assertEquals(g2.removeEdge(100,200), null);

        assertEquals(g2.getEdge(5,1).getDest(), 1);
        g2.removeEdge(5,1);
        assertEquals(g2.getEdge(5,1), null);
    }

    @Test
    void nodeSize() {
        insert();
        assertEquals(g2.nodeSize(), 6);
        g2.removeNode(1);
        assertEquals(g2.nodeSize(), 5);
        g2.removeNode(2);
        assertEquals(g2.nodeSize(), 4);
        MyGeoLocation loc = new MyGeoLocation(23,24,0);
        MyNodeData node1 = new MyNodeData(8,loc);
        g2.addNode(node1);
        assertEquals(g2.nodeSize(), 5);
    }

    @Test
    void edgeSize() {
        insert();

    }

    @Test
    void getMC() {
    }

    @Test
    void dfs() {
    }

    @Test
    void setTags() {
    }

    @Test
    void getTranspose() {
    }
}