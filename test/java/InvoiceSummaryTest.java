import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class InvoiceSummaryTest {
    Ride[] rides = null;
    InvoiceService invoiceService = null;
    private RideRepository rideRepository = null;
    @Before
    public void setUp() throws Exception{
        invoiceService = new InvoiceService();
        rideRepository = new RideRepository();
        invoiceService.setRideRepository(rideRepository);
        rides = new Ride[]{
                new Ride(CabRide.NORMAL,2.0,5),
                new Ride(CabRide.PREMIUM,0.1,1)
        };

    }
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25, fare,0.0);
    }
    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare(){
        double distance = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5, fare , 0.0);
    }
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary(){
        Ride[] rides = {new Ride(2.0, 5),
                        new Ride(0.1, 1)};
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary(){
        String userId = "a@b.com";
        Ride[] rides = {
                new Ride(2.0,5),
                new Ride(0.1,1)
        };
        invoiceService.addRides(userId,rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }

    @Test
    public void givenNormalAndPremiumRides_ShouldReturnFare(){
        double totalFarePremium = invoiceService.calculateTotalFare(2,5,CabRide.PREMIUM);
        Assert.assertEquals(40.0,totalFarePremium,0);
    }
}
