package fr.ekwateur;

public class ProfessionalCustomer extends Customer {
    private double turnover;
    private String siret;
    private String companyName;

    public ProfessionalCustomer(final String reference, final String siret, final String companyName, final double turnover) {
        super(reference);
        this.siret = siret;
        this.companyName = companyName;
        this.turnover = turnover;
    }

    public double getTurnover() {
        return turnover;
    }

}
