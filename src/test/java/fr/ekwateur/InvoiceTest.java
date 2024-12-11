package fr.ekwateur;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(expectedAmount, actualAmount);

    }

    @Test
    @DisplayName("""
            Given an individual customer
            and his electricity consumption,
            when calculating amount,
            then get the correct total.
            """)
    void individual_customer_electricity_consumption() {
        final double gasInKwh = 0;
        final double electricityInKwh = 250;
        final Consumption consumption = new Consumption(gasInKwh, electricityInKwh);
        final IndividualCustomer customer = new IndividualCustomer();
        final Invoice invoice = new Invoice();

        final double actualAmount = invoice.calculateBillAmount(customer, consumption);

        final double expectedAmount = 33.25;
        assertEquals(expectedAmount, actualAmount);

    }

    @Test
    @DisplayName("""
            Given an individual customer
            and his energy consumption,
            when calculating amount,
            then get the correct total.
            """)
    void individual_customer_energy_consumption() {
        final double gasInKwh = 151;
        final double electricityInKwh = 150;
        final Consumption consumption = new Consumption(gasInKwh, electricityInKwh);
        final IndividualCustomer customer = new IndividualCustomer();
        final Invoice invoice = new Invoice();

        final double actualAmount = invoice.calculateBillAmount(customer, consumption);

        final double expectedAmount = 36.258;
        assertEquals(expectedAmount, actualAmount);

    }
}
