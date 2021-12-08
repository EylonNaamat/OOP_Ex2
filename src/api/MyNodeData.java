package api;

public class MyNodeData implements NodeData {

    private int id;
    private MyGeoLocation location;
    private double weight;
    private String info;
    private int tag;

    public MyNodeData(int id, MyGeoLocation location) {
        this.id = id;
        this.location = location;
        this.weight = 0;
        this.info = "default";
        this.tag = 0;
    }
    
    public MyNodeData(NodeData n) {
        this.id = n.getKey();
        this.location = new MyGeoLocation(n.getLocation());
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
        return this.location;
    }

    @Override
    public void setLocation(GeoLocation p) {
        this.location = (MyGeoLocation) p;
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