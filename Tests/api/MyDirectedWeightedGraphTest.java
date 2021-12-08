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



    MyDirectedWeightedGraph g4 = new MyDirectedWeightedGraph();
    public void insert2(){
        g4.addNode(nd1);
        g4.addNode(nd2);
        g4.addNode(nd3);
        g4.addNode(nd4);
        g4.addNode(nd5);
        g4.addNode(nd6);

        g4.connect(1,2,5);
        g4.connect(1,3,10);
        g4.connect(1,4,14);
        g4.connect(2,5,20);
        g4.connect(2,3,12);
        g4.connect(4,3,17);
        g4.connect(5,1,30);
        g4.connect(5,6,7);
        g4.connect(6,4,25);
    }

    @Test
    void getMyEdges() {
        insert2();
        assertEquals(5, g4.getMyEdges().get(1).get(2).getWeight());
        assertEquals(5, g4.getMyEdges().get(2).get(5).getDest());
        assertEquals(1, g4.getMyEdges().get(5).get(1).getDest());
    }

    @Test
    void getMyNodes() {
        insert2();
        assertEquals(1, g4.getMyNodes().get(1).getKey());
        assertEquals(4.5, g4.getMyNodes().get(2).getLocation().x());
        assertEquals(11, g4.getMyNodes().get(6).getLocation().y());
    }

    @Test
    void getNode() {
        insert2();
        assertEquals(g4.getNode(3).getLocation().y(), 15.3);
        assertEquals(g4.getNode(6).getKey(), 6);
        assertEquals(g4.getNode(7), null);
    }

    @Test
    void getEdge() {
        insert2();
        assertEquals(g4.getEdge(2, 5).getWeight(), 20);
        assertEquals(g4.getEdge(1,8), null);
        assertEquals(g4.getEdge(6, 4).getSrc(), 6);
        assertEquals(g4.getEdge(5,1).getDest(), g4.getEdge(1,2).getSrc());
    }

    @Test
    void addNode() {
        insert2();
        MyGeoLocation l1 = new MyGeoLocation(100,42,0);
        NodeData node1 = new MyNodeData(8, l1);
        g4.addNode(node1);
        assertEquals(g4.getNode(8).getLocation().x(), 100);
        MyGeoLocation l2 = new MyGeoLocation(32,7,0);
        NodeData node2 = new MyNodeData(100, l2);
        g4.addNode(node2);
        assertEquals(g4.getNode(100).getKey(), 100);
        MyGeoLocation l3 = new MyGeoLocation(8,24,0);
        NodeData node3 = new MyNodeData(100, l3);
        g4.addNode(node3);
        assertEquals(g4.getNode(100).getLocation().x(), 8);
        assertNotEquals(g4.getNode(100).getLocation().x(), 32);
    }

    @Test
    void connect() {
        insert2();
        g4.connect(1,5, 42);
        assertEquals(g4.getEdge(1,5).getWeight(), 42);
        g4.connect(1,5,24);
        assertNotEquals(g4.getEdge(1,5).getWeight(), 42);
        g4.connect(6,2,11);
        assertEquals(g4.getEdge(6,2).getSrc(), 6);
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
        insert2();
        assertEquals(g4.getMyNodes().containsKey(1), true);
        assertEquals(g4.getMyEdges().containsKey(1), true);

        g4.removeNode(1);
        assertEquals(g4.getMyNodes().containsKey(1), false);
        assertEquals(g4.getMyEdges().get(1), null);
        assertEquals(g4.getMyEdges().containsKey(1), false);
        //assertEquals(g4.getMyEdges().get(5).get(1), null);

    }

    @Test
    void removeEdge() {
        insert2();
        assertEquals(g4.getEdge(1,3).getSrc(), 1);
        g4.removeEdge(1,3);
        assertEquals(g4.getEdge(1,3), null);
        assertEquals(g4.removeEdge(100,200), null);

        assertEquals(g4.getEdge(5,1).getDest(), 1);
        g4.removeEdge(5,1);
        assertEquals(g4.getEdge(5,1), null);
    }

    @Test
    void nodeSize() {
        insert2();
        assertEquals(g4.getMyNodes().size(), 6);
        assertEquals(g4.nodeSize(), 6);
        assertEquals(g4.nodeSize(), 6);
        g4.removeNode(1);
        assertEquals(g4.nodeSize(), 5);
        g4.removeNode(2);
        assertEquals(g4.nodeSize(), 4);
        MyGeoLocation loc = new MyGeoLocation(23,24,0);
        MyNodeData node1 = new MyNodeData(8,loc);
        g4.addNode(node1);
        assertEquals(g4.nodeSize(), 5);
    }

    @Test
    void edgeSize() {
        insert2();
        assertEquals(g4.edgeSize(), 9);
        g4.removeEdge(1,3);
        assertEquals(8, g4.edgeSize());
        g4.removeEdge(5,1);
        g4.removeEdge(6,4);
        assertEquals(g4.edgeSize(), 6);
        g4.connect(1,6, 23);
        assertEquals(g4.edgeSize(), 7);
        g4.removeNode(1);
        assertEquals(4,g4.edgeSize());
    }

    @Test
    void getMC() {
        insert2();
        assertEquals(g4.getMC(), 15);
        MyGeoLocation loc = new MyGeoLocation(11,12,0);
        MyNodeData nd = new MyNodeData(8,loc);
        g4.addNode(nd);
        assertEquals(g4.getMC(), 16);
        g4.connect(1,8, 32);
        assertEquals(g4.getMC(), 17);
        g4.connect(8,1,13);
        assertEquals(g4.getMC(), 18);
        g4.removeNode(6);
        assertEquals(g4.getMC(), 19);
        g4.removeEdge(8,1);
        assertEquals(g4.getMC(), 20);
    }

    @Test
    void dfs() {
        insert2();
        assertEquals(g4.getNode(1).getTag(), 0);
        assertEquals(g4.getNode(2).getTag(), 0);
        assertEquals(g4.getNode(3).getTag(), 0);
        assertEquals(g4.getNode(4).getTag(), 0);
        assertEquals(g4.getNode(5).getTag(), 0);
        assertEquals(g4.getNode(6).getTag(), 0);
        g4.dfs(nd1);
        assertEquals(g4.getNode(1).getTag(), 1);
        assertEquals(g4.getNode(2).getTag(), 1);
        assertEquals(g4.getNode(3).getTag(), 1);
        assertEquals(g4.getNode(4).getTag(), 1);
        assertEquals(g4.getNode(5).getTag(), 1);
        assertEquals(g4.getNode(6).getTag(), 1);
        g4.setTags();
        g4.removeEdge(1,3);
        g4.removeEdge(2,3);
        g4.removeEdge(4,3);
        g4.dfs(nd1);
        assertEquals(g4.getNode(3).getTag(), 0);
        assertEquals(g4.getNode(1).getTag(), 1);
        assertEquals(g4.getNode(2).getTag(), 1);
        assertEquals(g4.getNode(4).getTag(), 1);
        assertEquals(g4.getNode(5).getTag(), 1);
        assertEquals(g4.getNode(6).getTag(), 1);
    }

    @Test
    void setTags() {
        insert2();
        g4.getNode(1).setTag(1);
        assertEquals(g4.getNode(1).getTag(), 1);
        g4.getNode(4).setTag(1);
        assertEquals(g4.getNode(4).getTag(), 1);
        g4.setTags();
        assertEquals(g4.getNode(1).getTag(), 0);
        assertEquals(g4.getNode(4).getTag(), 0);

    }

    @Test
    void getTranspose() {
        insert2();
        assertEquals(g4.getEdge(5,1).getDest(), 1);
        assertEquals(g4.getEdge(5,1).getSrc(), 5);
        assertEquals(g4.getEdge(6,4).getDest(), 4);
        assertEquals(g4.getEdge(6,4).getSrc(), 6);
        MyDirectedWeightedGraph transpose = g4.getTranspose();
        assertEquals(transpose.getEdge(1,5).getDest(), 5);
        assertEquals(transpose.getEdge(1,5).getSrc(), 1);
        assertEquals(transpose.getEdge(4,6).getDest(), 6);
        assertEquals(transpose.getEdge(4,6).getSrc(), 4);
    }
}