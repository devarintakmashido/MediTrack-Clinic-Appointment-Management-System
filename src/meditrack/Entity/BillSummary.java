package Entity;

import java.time.LocalDateTime;

public final class BillSummary {
    private final String billId;
    private final String appointmentId;
    private final double totalAmount;
    private final LocalDateTime paidAt;

    public BillSummary(String billId, String appointmentId, double totalAmount, LocalDateTime paidAt) {
        this.billId = billId;
        this.appointmentId = appointmentId;
        this.totalAmount = totalAmount;
        this.paidAt = paidAt;
    }

    public String getBillId() {
        return billId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    @Override
    public String toString() {
        return "BillSummary{" +
                "billId='" + billId + '\'' +
                ", appointmentId='" + appointmentId + '\'' +
                ", totalAmount=" + totalAmount +
                ", paidAt=" + paidAt +
                '}';
    }
}
