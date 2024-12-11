package fr.ekwateur;

public abstract class Customer {
    private final String reference;

    Customer(String reference) {
        this.reference = validate(reference);
    }

    private String validate(final String reference) {
        if (reference == null || !reference.matches("^EKW\\d{9}$")) {
            throw new IllegalArgumentException("Reference should be a valid Ekwateur reference");
        }
        return reference;
    }

    public String getReference() {
        return reference;
    }

}
