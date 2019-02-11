package com.company;

import java.util.Date;

public class LigneComptable {

    int numeroDeCompte;
    double sommeCrediter;
    Date dateOperation;
    String motifAchat;
    String modeDePaiment;

    public LigneComptable(int numeroDeCompte, double sommeCrediter, Date dateOperation, String motifAchat, String modeDePaiment) {
        this.numeroDeCompte = numeroDeCompte;
        this.sommeCrediter = sommeCrediter;
        this.dateOperation = dateOperation;
        this.motifAchat = motifAchat;
        this.modeDePaiment = modeDePaiment;
    }

    public int getNumeroDeCompte() {
        return numeroDeCompte;
    }

    public double getSommeCrediter() {
        return sommeCrediter;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public String getMotifAchat() {
        return motifAchat;
    }

    public String getModeDePaiment() {
        return modeDePaiment;
    }
}
