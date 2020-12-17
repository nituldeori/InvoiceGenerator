import java.util.Objects;

public class InvoiceSummary {
    private final int numOfRides;
    private final double totalFare;
    private final double averageFare;

    public InvoiceSummary(int numOfRides, double totalFare) {
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare/this.numOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary summary = (InvoiceSummary) o;
        return numOfRides == summary.numOfRides &&
                Double.compare(summary.totalFare, totalFare) == 0 &&
                Double.compare(summary.averageFare, averageFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOfRides, totalFare, averageFare);
    }
}
