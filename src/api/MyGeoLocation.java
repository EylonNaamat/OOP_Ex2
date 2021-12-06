package api;

public class MyGeoLocation implements GeoLocation{

    private double x;
    private double y;
    private double z;

    public MyGeoLocation(double Nx, double Ny, double Nz)
    {
        this.x=Nx;
        this.y=Ny;
        this.z=Nz;
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
}
