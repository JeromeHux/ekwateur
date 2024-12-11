package fr.ekwateur;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvoiceTest {
    private final IndividualCustomer customer = new IndividualCustomer();
    private final Invoice invoice = new Invoice();

    @ParameterizedTest
    @MethodSource("provideConsumption")
    @DisplayName("""
            Given an individual customer
            and his energy consumption,
            when calculating amount,
            then get the correct total.
            """)
    void individual_customer_energy_consumption(Consumption consumption, double expectedAmount) {
        final double actualAmount = invoice.calculateBillAmount(customer, consumption);

        assertEquals(expectedAmount, actualAmount);

    }

    private static Stream<Arguments> provideConsumption() {
        return Stream.of(
                Arguments.of(new Consumption(100, 0), 10.8),
                Arguments.of(new Consumption(0, 250), 33.25),
                Arguments.of(new Consumption(151, 150), 36.258)
        );
    }
}
