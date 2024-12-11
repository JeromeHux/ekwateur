package fr.ekwateur;

public class Invoice {

    private static final double PRICE_OF_A_KWH_OF_GAS_FOR_INDIVIDUAL_CUSTOMER = 0.108;
    private static final double PRICE_OF_A_KWH_OF_ELECTRICITY_FOR_INDIVIDUAL_CUSTOMER = 0.133;
    private static final double PRICE_OF_A_KWH_OF_GAS_FOR_PRO_CUSTOMER_WITH_SMALL_TURNOVER = 0.112;
    private static final double PRICE_OF_A_KWH_OF_ELECTRICITY_FOR_PRO_CUSTOMER_WITH_SMALL_TURNOVER = 0.117;

    public double calculateBillAmount(final Customer customer, final Consumption consumption) {
        if (customer instanceof IndividualCustomer) {
            return consumption.gasInKwh() * PRICE_OF_A_KWH_OF_GAS_FOR_INDIVIDUAL_CUSTOMER
                   + consumption.electricityInKwh() * PRICE_OF_A_KWH_OF_ELECTRICITY_FOR_INDIVIDUAL_CUSTOMER;
        } else {
            return consumption.gasInKwh() * PRICE_OF_A_KWH_OF_GAS_FOR_PRO_CUSTOMER_WITH_SMALL_TURNOVER
                   + consumption.electricityInKwh() * PRICE_OF_A_KWH_OF_ELECTRICITY_FOR_PRO_CUSTOMER_WITH_SMALL_TURNOVER;
        }
    }
}
