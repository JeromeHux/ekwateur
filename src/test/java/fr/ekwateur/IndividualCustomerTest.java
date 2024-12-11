package fr.ekwateur;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IndividualCustomerTest {

    @Test
    @DisplayName("""
            Given an new individual customer,
            when getting its values,
            then get correct values.
            """)
    void correct_individual_customer() {
        final String reference = "EKW100000000";
        final String title = "Mr";
        final String lastName = "Doe";
        final String firstName = "John";

        final IndividualCustomer individualCustomer = new IndividualCustomer(reference, title, lastName, firstName);

        assertEquals(reference, individualCustomer.getReference());
        assertEquals(title, individualCustomer.getTitle());
        assertEquals(lastName, individualCustomer.getLastName());
        assertEquals(firstName, individualCustomer.getFirstName());
    }

    @Test
    @DisplayName("""
            Given an incorrect reference,
            when creating an individual customer,
            then throw an exception.
            """)
    void incorrect_individual_customer() {
        final String reference = "EK10000000";
        final String title = "Mr";
        final String lastName = "Doe";
        final String firstName = "John";

        assertThrows(IllegalArgumentException.class,
                () -> new IndividualCustomer(reference, title, lastName, firstName)
        );
    }
}
