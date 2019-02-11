package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BanqueModel {

    static List<Compte> comptes = new ArrayList<Compte>();
    static Map<Integer,Movements> movementsMap = new HashMap<>();


    public BanqueModel() {
    }


    public void addCompte(Compte compte) {
        comptes.add(compte);
    }

    public static List<Compte> getComptes() {
        return comptes;
    }

    public ArrayList<Integer> getNumeroComptes() {
        ArrayList<Integer> numeroComptes = new ArrayList<>();

        for(Compte temp: comptes){
            numeroComptes.add(temp.numeroCompte);
        }

        return numeroComptes;
    }

    public boolean checkCompteIfExist(int numeroCompte) {

        for(Compte temp: comptes){
            if (temp.numeroCompte == numeroCompte) return true;
        }
        return false;

    }

    public Movements getMovementsFromCompte(int numeroCompte) {
        return movementsMap.get(numeroCompte);
    }
}
