package com.company;


import java.sql.Date;

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

    public LigneComptable() {
    }

    public void setNumeroDeCompte(int numeroDeCompte) {
        this.numeroDeCompte = numeroDeCompte;
    }

    public void setSommeCrediter(double sommeCrediter) {
        this.sommeCrediter = sommeCrediter;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public void setMotifAchat(String motifAchat) {
        this.motifAchat = motifAchat;
    }

    public void setModeDePaiment(String modeDePaiment) {
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
