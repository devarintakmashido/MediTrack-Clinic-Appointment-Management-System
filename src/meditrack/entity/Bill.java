package meditrack.entity;

import com.airtribe.meditrack.Myinterface.Payable;

import java.io.Serializable;

public class Bill implements Payable, Serializable {

    private String appointmentId;
    private double amount;
    private boolean paid;

    public Bill(String appointmentId, double amount) {
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.paid = false;
    }

    public String getAppointmentId() { return appointmentId; }
    public double getAmount() { return amount; }
    public boolean isPaid() { return paid; }

    @Override
    public void payBill() {
        this.paid = true;
    }
}
