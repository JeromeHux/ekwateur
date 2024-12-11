package fr.ekwateur;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvoiceTest {
    private final Invoice invoice = new Invoice();

    @Nested
    @DisplayName("Individual customer invoice")
    class IndividualCustomerInvoiceTest {
        private final IndividualCustomer individualCustomer = new IndividualCustomer("EKW100000000", "Mr", "Doe", "John");

        @ParameterizedTest
        @MethodSource("provideConsumption")
        @DisplayName("""
                Given an individual customer
                and his energy consumption,
                when calculating amount,
                then get the correct total.
                """)
        void individual_customer_energy_consumption(Consumption consumption, double expectedAmount) {
            final double actualAmount = invoice.calculateBillAmount(individualCustomer, consumption);

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

    @Nested
    @DisplayName("Professional customer with small turnover invoice")
    class ProfessionalCustomerWithSmallTurnoverInvoiceTest {
        private final ProfessionalCustomer professionalCustomer = new ProfessionalCustomer("EKW100000001", "12345678901234", "foo", 1000);

        @ParameterizedTest
        @MethodSource("provideConsumption")
        @DisplayName("""
                Given an professional customer with a turnover of 1000
                and his energy consumption,
                when calculating amount,
                then get the correct total.
                """)
        void professional_customer_energy_consumption_with_small_turnover(Consumption consumption, double expectedAmount) {
            final double actualAmount = invoice.calculateBillAmount(professionalCustomer, consumption);

            assertEquals(expectedAmount, actualAmount);

        }

        private static Stream<Arguments> provideConsumption() {
            return Stream.of(
                    Arguments.of(new Consumption(101, 0), 11.312),
                    Arguments.of(new Consumption(0, 250), 29.25),
                    Arguments.of(new Consumption(151, 150), 34.462)
            );
        }
    }

    @Nested
    @DisplayName("Professional customer with big turnover invoice")
    class ProfessionalCustomerWithBigTurnoverInvoiceTest {
        private final ProfessionalCustomer professionalCustomer = new ProfessionalCustomer("EKW100000002", "12345678901235", "bar", 100000000);

        @ParameterizedTest
        @MethodSource("provideConsumption")
        @DisplayName("""
                Given an professional customer with a turnover of 100000000
                and his energy consumption,
                when calculating amount,
                then get the correct total.
                """)
        void professional_customer_energy_consumption_with_big_turnover(Consumption consumption, double expectedAmount) {
            final double actualAmount = invoice.calculateBillAmount(professionalCustomer, consumption);

            assertEquals(expectedAmount, actualAmount);

        }

        private static Stream<Arguments> provideConsumption() {
            return Stream.of(
                    Arguments.of(new Consumption(100, 0), 11.0),
                    Arguments.of(new Consumption(0, 250), 30.75),
                    Arguments.of(new Consumption(151, 150), 35.06)
            );
        }
    }
}
