package api;

public class MyEdgeData implements EdgeData{

    private int src;
    private int dest;
    private double width;

    public MyEdgeData(int Nsrc , double Nwidth, int Ndest)
    {
        this.src=Nsrc;
        this.dest=Ndest;
        this.width=Nwidth;
    }
    @Override
    public int getSrc() {
        return this.src;
    }

    @Override
    public int getDest() {
        return this.dest;
    }

    @Override
    public double getWeight() {
        return this.width;
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public void setInfo(String s) {

    }

    @Override
    public int getTag() {
        return 0;
    }

    @Override
    public void setTag(int t) {

    }
}
