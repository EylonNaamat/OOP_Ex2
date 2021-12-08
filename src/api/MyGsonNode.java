package api;

public class MyGsonNode implements NodeData{
    private String pos;
    private int id;

    public MyGsonNode(NodeData n)
    {
        this.pos = ((MyGeoLocation)n.getLocation()).posString();
        this.id=n.getKey();
    }
    @Override
    public int getKey() {
        return this.id;
    }

    @Override
    public GeoLocation getLocation() {
        GeoLocation g = new MyGeoLocation(this.pos);
        return g;
    }

    @Override
    public void setLocation(GeoLocation p) {
        this.pos = ((MyGeoLocation)p).posString();
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public void setWeight(double w) {

    }

    @Override
    public String getInfo() {
        return "defult";
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
