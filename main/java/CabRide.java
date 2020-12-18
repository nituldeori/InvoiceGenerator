public enum CabRide {
    NORMAL(10.0,1.0,5.0), PREMIUM(15.0,2.0,20.0);

    public final double costPerKm;
    public final double costPerMin;
    public final double minFarePerRide;

    CabRide(double costPerKm, double costPerMin, double minFarePerRide){
        this.costPerKm = costPerKm;
        this.costPerMin = costPerMin;
        this.minFarePerRide = minFarePerRide;
    }



    public double calcCostOfCabRide(Ride ride){
        double rideCost = ride.distance * costPerKm + ride.time * costPerMin;
        return Math.max(rideCost, minFarePerRide);
    }
}
