package api;

public class MyGeoLocation implements GeoLocation{

    private double x;
    private double y;
    private double z;

    public MyGeoLocation(double nx, double ny, double nz)
    {
        this.x=nx;
        this.y=ny;
        this.z=nz;
    }
    public MyGeoLocation(String st)
    {
        String arr[]= st.split(",");
        this.x=Double.parseDouble(arr[0]);
        this.y=Double.parseDouble(arr[1]);
        this.z=Double.parseDouble(arr[2]);
    }
    public MyGeoLocation(GeoLocation g)
    {
        this.x=g.x();
        this.y=g.y();
        this.z=g.z();
    }
    @Override
    public double x() {
        return this.x;
    }

    @Override
    public double y() {
        return this.y;
    }

    @Override
    public double z() {
        return this.z;
    }

    @Override
    public double distance(GeoLocation g) {
        double x = this.x-g.x();
        x=x*x;
        double y = this.y-g.y();
        y=y*y;
        double z = this.z-g.z();
        z=z*z;
        return Math.sqrt(x+y+z);
    }

    public String posString()
    {
        String st = "";
        st=st+this.x+","+this.y+","+this.z;
        return st;
    }
}
