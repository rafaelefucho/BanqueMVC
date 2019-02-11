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

}
