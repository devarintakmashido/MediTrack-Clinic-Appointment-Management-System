package meditrack.Entity;

import meditrack.constants.Constants;

import java.time.LocalDateTime;

public class Bill implements Payable {
    private final String billId;
    private final Appointment appointment;
    private double baseAmount;
    private double tax;
    private double totalAmount;
    private final LocalDateTime generatedAt;

    public Bill(String billId, Appointment appointment) {
        this.billId = billId;
        this.appointment = appointment;
        this.generatedAt = LocalDateTime.now();

        this.baseAmount = appointment.getDoctorFee();
        calculateTax(Constants.TAX_RATE);
        calculateTotal();
    }

    public void calculateTax(double taxRate) {
        this.tax = baseAmount * taxRate;
    }

    public void calculateTotal() {
        this.totalAmount = baseAmount + tax;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getBillId() {
        return billId;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    @Override
    public BillSummary generateBillSummary() {
        return new BillSummary(
                this.billId,
                this.appointment.getAppointmentId(),
                this.totalAmount,
                java.time.LocalDateTime.now()
        );
    }
}
