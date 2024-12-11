package fr.ekwateur;

public class Invoice {

    private static final double PRICE_OF_A_KWH_OF_GAS_FOR_INDIVIDUAL_CUSTOMER = 0.108;
    private static final double PRICE_OF_A_KWH_OF_ELECTRICITY_FOR_INDIVIDUAL_CUSTOMER = 0.133;

    public double calculateBillAmount(final IndividualCustomer individualCustomer, final Consumption consumption) {
        return consumption.gasInKwh() * PRICE_OF_A_KWH_OF_GAS_FOR_INDIVIDUAL_CUSTOMER
               + consumption.electricityInKwh() * PRICE_OF_A_KWH_OF_ELECTRICITY_FOR_INDIVIDUAL_CUSTOMER;
    }
}
