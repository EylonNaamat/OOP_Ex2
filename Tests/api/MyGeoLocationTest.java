package api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyGeoLocationTest {
    MyGeoLocation gl1 = new MyGeoLocation(1,2,0);
    MyGeoLocation gl2 = new MyGeoLocation(12,5,0);
    MyGeoLocation gl3 = new MyGeoLocation(20,18,0);
    MyGeoLocation gl4 = new MyGeoLocation(6,3,0);
    MyGeoLocation gl5 = new MyGeoLocation(2,2,0);


    @Test
    void x() {
        assertNotEquals(gl1.x(), gl2.x());
        assertNotEquals(gl2.x(), gl3.x());
        assertNotEquals(gl3.x(), gl4.x());
        assertNotEquals(gl4.x(), gl5.x());
    }

    @Test
    void y() {
        assertEquals(gl5.y(), gl1.y());
        assertNotEquals(gl1.y(), gl2.y());
        assertNotEquals(gl3.y(), gl5.y());
    }

    @Test
    void z() {
        assertNotEquals(1, gl1.z());
        assertNotEquals(5, gl2.z());
        assertEquals(0, gl4.z());
        assertNotEquals(9, gl5.z());
    }

    @Test
    void distance() {
        assertNotEquals(gl1.distance(gl2), gl1.distance(gl3));
        assertEquals(1, gl1.distance(gl5));
    }
}