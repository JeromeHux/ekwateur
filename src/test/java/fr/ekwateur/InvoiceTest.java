package fr.ekwateur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InvoiceTest {

    @Test
    @DisplayName("""
            Given an individual customer
            and his gaz consumption,
            when calculating amount,
            then get the correct total.
            """)
    void individual_customer_gaz_consumption() {
        final double gasInKwh = 100;
        final double electricityInKwh = 0;
        final Consumption consumption = new Consumption(gasInKwh, electricityInKwh);
        final IndividualCustomer customer = new IndividualCustomer();
        final Invoice invoice = new Invoice();

        final double actualAmount = invoice.calculateBillAmount(customer, consumption);

        final double expectedAmount = 10.8;
        Assertions.assertEquals(expectedAmount, actualAmount);

    }
}
