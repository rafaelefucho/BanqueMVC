package com.company;

public class Compte {

    String typeCompte;
    int numeroCompte;
    int valeurCreditee;
    int taxPlacement;

    public Compte(String typeCompte, int numeroCompte, int valeurCreditee, int taxPlacement) {
        this.typeCompte = typeCompte;
        this.numeroCompte = numeroCompte;
        this.valeurCreditee = valeurCreditee;
        this.taxPlacement = taxPlacement;
    }

    public Compte() {
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public int getValeurCreditee() {
        return valeurCreditee;
    }

    public void setValeurCreditee(int valeurCreditee) {
        this.valeurCreditee = valeurCreditee;
    }

    public int getTaxPlacement() {
        return taxPlacement;
    }

    public void setTaxPlacement(int taxPlacement) {
        this.taxPlacement = taxPlacement;
    }
}
