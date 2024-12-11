package fr.ekwateur;

public class ProfessionalCustomer extends Customer {
    private double turnover;

    public ProfessionalCustomer(final double turnover) {
        this.turnover = turnover;
    }

    public double getTurnover() {
        return turnover;
    }
}
