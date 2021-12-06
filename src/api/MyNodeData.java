package api;

public class MyNodeData implements NodeData {

    private int id;
    private GeoLocation pos;
    private double weight;
    private String info;
    private int tag;

    public MyNodeData(int id, GeoLocation location) {
        this.id = id;
        this.pos = location;
        this.weight = 0;
        this.info = "default";
        this.tag = 0;
    }


    public MyNodeData(NodeData n) {
        this.id = n.getKey();
        this.pos = new MyGeoLocation(n.getLocation());
        this.weight =n.getWeight() ;
        this.info =n.getInfo();
        this.tag =n.getTag();
    }

    @Override
    public int getKey() {
        return this.id;
    }

    @Override
    public GeoLocation getLocation() {
        return this.pos;
    }

    @Override
    public void setLocation(GeoLocation p) {
        this.pos = p;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double w) {
        this.weight = w;
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(String s) {
        this.info = s;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag = t;
    }
}