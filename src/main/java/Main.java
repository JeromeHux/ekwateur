import fr.ekwateur.Consumption;
import fr.ekwateur.IndividualCustomer;
import fr.ekwateur.Invoice;
import fr.ekwateur.ProfessionalCustomer;

public class Main {
    public static void main(String[] args) {

        final Invoice invoice = new Invoice();
        final IndividualCustomer individualCustomer = new IndividualCustomer("EKW100000000", "Mr", "Doe", "John");
        final ProfessionalCustomer professionalCustomer = new ProfessionalCustomer("EKW100000001", "12345678901234", "foo", 1000);
        final ProfessionalCustomer anotherProfessionalCustomer = new ProfessionalCustomer("EKW100000002", "12345678901235", "bar", 100000000);

        final Consumption consumption = new Consumption(100, 200);

        System.out.println("Pour 100 kwh de gaz et 200 kwh d'électricité, les factures sont les suivantes :");
        System.out.println("Pour un client particulier : %s euros".formatted(invoice.calculateBillAmount(individualCustomer, consumption)));
        System.out.println("Pour un client professional avec un petit CA : %s euros".formatted(invoice.calculateBillAmount(professionalCustomer, consumption)));
        System.out.println("Pour un client professional avec un gros CA : %s euros".formatted(invoice.calculateBillAmount(anotherProfessionalCustomer, consumption)));


    }
}
