package meditrack.entity;

public final class BillSummary {

    private final double totalAmount;
    private final int totalAppointments;

    public BillSummary(double totalAmount, int totalAppointments) {
        this.totalAmount = totalAmount;
        this.totalAppointments = totalAppointments;
    }

    public double getTotalAmount() { return totalAmount; }
    public int getTotalAppointments() { return totalAppointments; }
}
