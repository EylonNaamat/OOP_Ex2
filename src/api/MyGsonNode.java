package api;

public class MyGsonNode {
    private int id;
    private String pos;

    public MyGsonNode(NodeData n)
    {
        this.id = n.getKey();
        this.pos = "";
        this.pos = this.pos+n.getLocation().x()+",";
        this.pos = this.pos+n.getLocation().y()+",";
        this.pos = this.pos+n.getLocation().z();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPos() {
        return this.pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }
}
