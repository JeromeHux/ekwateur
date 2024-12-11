package fr.ekwateur;

public class Invoice {
    public double calculateBillAmount(final IndividualCustomer individualCustomer, final Consumption consumption) {
        return consumption.gasInKwh() * 0.108;
    }
}
