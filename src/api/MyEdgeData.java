package api;

public class MyEdgeData implements EdgeData{

    private int src;
    private int dest;
    private double w;
    private String info;
    private int tag;

    public MyEdgeData(int nsrc , double nwidth, int ndest)
    {
        this.src = nsrc;
        this.dest = ndest;
        this.w = nwidth;
        this.info = "defult";
        this.tag = 0;
    }

    public MyEdgeData(EdgeData edge){
        this.src = edge.getSrc();
        this.dest = edge.getDest();
        this.w = edge.getWeight();
        this.info = edge.getInfo();
        this.tag = edge.getTag();
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
        return this.w;
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(String s) {
        this.info=s;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag=t;
    }
}
