package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

public class BanqueView {


    public BanqueView() {
    }

    public static int showMenu() {

        System.out.flush();
        System.out.println("1. Creer un compte");
        System.out.println("2. Afficher un compte");
        System.out.println("3. Creer une ligne comptable");
        System.out.println("4. Sortir");
        System.out.println("5. De l'aide");
        System.out.println(" ");
        System.out.print("Votre choix: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int choix = Integer.parseInt(br.readLine());
            return choix;

        } catch (IOException e) {
            e.printStackTrace();
            return -1;

        }
    }

    public void showOptionPasDispo() {
        System.out.println("\n \n");
        System.out.println("singes hautement qualifiés travaillent actuellement dans ce probleme en ce moment.");
        System.out.println("La fonction n'est pas disponible.. \n \n ");
    }

    public void showOptionPasValid() {
        System.out.println("\n \n");
        System.out.println("Réessayez avec un option valid \n \n ");
    }

    public Compte getInfoCompte() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.flush();

            System.out.print("Le type du compte [Types possibles: Compte courant, joint, epargne] :");
            String typeCompte = br.readLine();

            System.out.print("Le numero du compte: ");
            int numeroCompte = Integer.parseInt(br.readLine());

            System.out.print("La premiere valeur creditee: ");
            int valuerCreditee = Integer.parseInt(br.readLine());


            System.out.print("Le taux de placement dans le cas d'un compte epargne: ");
            int taxPlacement = Integer.parseInt(br.readLine());

            Compte compte = new Compte(typeCompte, numeroCompte, valuerCreditee, taxPlacement);

            System.out.println("\n  Compte numero " + numeroCompte + " added to the system \n");

            return compte;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public void showNumeroComptes(ArrayList<Integer> numeroComptes) {


        System.out.println(String.format("|%-10s|", "Compte"));

        for (int temp:numeroComptes){
            String line = String.format("|%-10s|",temp);
            System.out.println(line);
        }

    }

    public void showOptionPasComptes() {
        System.out.println("\n \n");
        System.out.println("There are no registered accounts \n \n ");

    }

    public int getNumeroCompte() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Le numero du compte: ");
        try {
            int numeroCompte = Integer.parseInt(br.readLine());
            return numeroCompte;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public void showComptePasValide() {

        System.out.println("\n \n");
        System.out.println("Le numero de compte n'existe pas \n \n ");
    }

    public void showMovementsOfCompte(Movements movements) {



        System.out.println(String.format("|%-10s|%10-s|%-10s|%-10s|%-10s|",
                "Numero de Compte",
                "Somme a crediter",
                "Date Operation",
                "Motif Achat",
                "Mode de Paiement"));


        for (LigneComptable temp:movements.movements){

            int numeroDeCompte = temp.getNumeroDeCompte();
            double sommeCrediter = temp.getNumeroDeCompte();
            Date dateOperation = temp.getDateOperation();
            String motifAchat = temp.getMotifAchat();
            String modeDePaiment = temp.getModeDePaiment();


            String line = String.format("|%-10s|%10-s|%-10s|%-10s|%-10s|",numeroDeCompte,sommeCrediter,dateOperation,motifAchat,modeDePaiment);
            System.out.println(line);
        }
    }
}

