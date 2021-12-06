package api;

import java.util.HashMap;

public class MyNodeData implements NodeData{

    private int key;
    private MyGeoLocation location;
    private double weight;
    private String info;
    private int tag;
    private HashMap<Integer, MyEdgeData> nodeMap;

    public MyNodeData(int key, MyGeoLocation location){
        this.key = key;
        this.location = new MyGeoLocation(location.x(), location.y(), location.z());
        this.weight = 0;
        this.info = "default";
        this.tag = 0;
        this.nodeMap = new HashMap<>();
    }

    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public GeoLocation getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(GeoLocation p) {
        this.location = new MyGeoLocation(p.x(), p.y(), p.z());
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

    public void addEdge(MyEdgeData edge){
        this.nodeMap.put(edge.getDest(), edge);
    }
}
