package api;

public class MyGsonEdje implements EdgeData{
    private int src;
    private double w;
    private int dest;

    public MyGsonEdje(EdgeData e){
        this.src= e.getSrc();
        this.dest= e.getDest();
        this.w = e.getWeight();
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
