package api;

public class MyGsonEdge {
    private int src;
    private int dest;
    private double w;

    public MyGsonEdge(EdgeData e)
    {
        this.dest=e.getDest();
        this.src=e.getSrc();
        this.w=e.getWeight();
    }

    public int getSrc() {
        return this.src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDest() {
        return this.dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public double getW() {
        return this.w;
    }

    public void setW(double w) {
        this.w = w;
    }
}
