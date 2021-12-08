package api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyNodeDataTest {
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
    @Test
    void getKey() {
        assertEquals(1,nd1.getKey());
        assertEquals(2,nd2.getKey());
        assertEquals(3,nd3.getKey());
        assertEquals(4,nd4.getKey());
        assertEquals(5,nd5.getKey());
    }

    @Test
    void getLocation() {
        assertEquals(1,nd1.getLocation().x());
        assertEquals(2,nd1.getLocation().y());
        assertEquals(0,nd1.getLocation().z());
        assertEquals(4.5,nd2.getLocation().x());
        assertEquals(3.5,nd2.getLocation().y());
        assertEquals(0,nd2.getLocation().z());
        assertEquals(10,nd3.getLocation().x());
        assertEquals(15.3,nd3.getLocation().y());
        assertEquals(0,nd3.getLocation().z());
        assertEquals(8.7,nd4.getLocation().x());
        assertEquals(2.4,nd4.getLocation().y());
        assertEquals(0,nd4.getLocation().z());
        assertEquals(9,nd5.getLocation().x());
        assertEquals(1,nd5.getLocation().y());
        assertEquals(0,nd5.getLocation().z());
        assertNotEquals(nd1.getLocation().x(),nd2.getLocation().x());
        assertNotEquals(nd2.getLocation().x(),nd2.getLocation().y());
        assertEquals(nd4.getLocation().z(),nd5.getLocation().z());
    }

    @Test
    void setLocation() {
        nd1.setLocation(nd2.getLocation());
        assertEquals(nd1.getLocation().x(), nd2.getLocation().x());
        nd1.setLocation(nd3.getLocation());
        assertEquals(nd1.getLocation().y(), nd3.getLocation().y());
        nd2.setLocation(nd1.getLocation());
        nd1.setLocation(nd5.getLocation());
        assertNotEquals(nd1.getLocation().x(), nd2.getLocation().x());
        nd1.setLocation(nd3.getLocation());
        nd5.setLocation(nd3.getLocation());
        assertEquals(nd1.getLocation().x(), nd5.getLocation().x());

    }

    @Test
    void getWeight() {
        assertEquals(0,nd1.getWeight());
        nd1.setWeight(2);
        assertEquals(2,nd1.getWeight());
        nd3.setWeight(5);
        assertNotEquals(nd3.getWeight(),nd1.getWeight());
        nd1.setWeight(nd2.getWeight());
        assertEquals(nd2.getWeight(),nd1.getWeight());
    }

    @Test
    void setWeight() {
        assertEquals(0,nd1.getWeight());
        nd1.setWeight(23);
        assertEquals(23,nd1.getWeight());
        nd3.setWeight(9);
        assertNotEquals(nd3.getWeight(),nd1.getWeight());
        nd1.setWeight(nd2.getWeight());
        assertEquals(nd2.getWeight(),nd1.getWeight());
    }

    @Test
    void getInfo() {
        assertEquals(nd1.getInfo(), "default");
        nd1.setInfo("Eylon");
        assertEquals(nd1.getInfo(), "Eylon");
        nd2.setInfo("Michael");
        assertEquals(nd2.getInfo(), "Michael");
        assertEquals(nd5.getInfo(), nd4.getInfo());
    }

    @Test
    void setInfo() {
        assertEquals(nd1.getInfo(), "default");
        nd1.setInfo("Naamat");
        assertEquals(nd1.getInfo(), "Naamat");
        nd2.setInfo("Matveev");
        assertEquals(nd2.getInfo(), "Matveev");
        assertEquals(nd5.getInfo(), nd4.getInfo());
    }

    @Test
    void getTag() {
        assertEquals(nd1.getTag(), nd2.getTag());
        nd3.setTag(3);
        assertNotEquals(nd1.getTag(), nd3.getTag());
        nd5.setTag(7);
        assertNotEquals(nd3.getTag(), nd5.getTag());
    }

    @Test
    void setTag() {
        nd1.setTag(5);
        assertNotEquals(nd1.getTag(), nd2.getTag());
        nd3.setTag(nd1.getTag());
        assertEquals(nd1.getTag(), nd3.getTag());
        nd5.setTag(7);
        assertNotEquals(nd3.getTag(), nd5.getTag());
    }
}