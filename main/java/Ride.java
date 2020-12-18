public class Ride {
    public CabRide cabRide;
    public double distance;
    public  int time;

    public Ride(double distance, int time){
        this.distance = distance;
        this.time = time;
    }


    public Ride(CabRide cabRide, double distance, int time) {
        this.cabRide = cabRide;
        this.distance = distance;
        this.time = time;
    }

}
