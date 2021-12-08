package api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyEdgeDataTest {
    MyEdgeData ed1 = new MyEdgeData(1,20,5);
    MyEdgeData ed2 = new MyEdgeData(2,3,1);
    MyEdgeData ed3 = new MyEdgeData(5,50,3);
    MyEdgeData ed4 = new MyEdgeData(3,40,4);
    MyEdgeData ed5 = new MyEdgeData(4,40,3);
    MyEdgeData ed6 = new MyEdgeData(3,3,1);

    @Test
    void getSrc() {
        assertEquals(ed6.getSrc(), ed4.getSrc());
        assertEquals(ed1.getSrc(), 1);
        assertNotEquals(ed2.getSrc(), ed3.getSrc());
        assertNotEquals(ed1.getSrc(), ed5.getSrc());
    }

    @Test
    void getDest() {
        assertEquals(ed3.getDest(), ed5.getDest());
        assertEquals(ed2.getDest(), ed6.getDest());
        assertNotEquals(ed1.getDest(), ed4.getDest());
        assertNotEquals(ed2.getDest(), ed1.getDest());
    }

    @Test
    void getWeight() {
        assertEquals(ed4.getWeight(), ed5.getWeight());
        assertEquals(ed2.getWeight(), ed6.getWeight());
        assertNotEquals(ed1.getWeight(), ed4.getWeight());
        assertNotEquals(ed2.getWeight(), ed3.getWeight());
    }

    @Test
    void getInfo() {
        assertEquals(ed1.getInfo(), ed2.getInfo());
        ed1.setInfo("blahblah");
        assertNotEquals(ed1.getInfo(), ed2.getInfo());
        ed5.setInfo("blahblah");
        assertEquals(ed1.getInfo(), ed5.getInfo());
        assertNotEquals(ed5.getInfo(), ed3.getInfo());
    }

    @Test
    void setInfo() {
        assertEquals(ed1.getInfo(), ed2.getInfo());
        ed1.setInfo("BetShemesh");
        assertNotEquals(ed1.getInfo(), ed2.getInfo());
        ed5.setInfo("Jerusalem");
        assertEquals("Jerusalem", ed5.getInfo());
        assertNotEquals(ed5.getInfo(), ed3.getInfo());
    }

    @Test
    void getTag() {
        assertEquals(0, ed1.getTag());
        ed1.setTag(3);
        assertEquals(3, ed1.getTag());
        assertNotEquals(ed2.getTag(), ed1.getTag());
        ed4.setTag(ed1.getTag());
        assertEquals(ed4.getTag(), ed1.getTag());
    }

    @Test
    void setTag() {
        assertEquals(0, ed1.getTag());
        ed1.setTag(8);
        assertEquals(8, ed1.getTag());
        assertNotEquals(ed2.getTag(), ed1.getTag());
        ed4.setTag(ed1.getTag());
        assertEquals(ed4.getTag(), ed1.getTag());
    }
}