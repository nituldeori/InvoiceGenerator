public class InvoiceService {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final double MINIMUM_FARE = 5;
    private RideRepository rideRepository;


    public void setRideRepository(RideRepository rideRepository){
        this.rideRepository = rideRepository;
    }

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare,MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides){
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length,totalFare);

    }

    public double calculateTotalFare(double distance, double time, CabRide cabRide){
        double fare = 0;
        fare = distance*cabRide.costPerKm+time*cabRide.costPerMin;
        return Math.max(cabRide.minFarePerRide,fare);
    }



    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRide(userId, rides);

    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}
