package com.company;

public class BanqueController {


    static BanqueModel banqueModel;
    static BanqueView banqueView;

    public BanqueController(BanqueModel banqueModel, BanqueView banqueView) {
        this.banqueModel = banqueModel;
        this.banqueView = banqueView;
    }

    public static void init() {


        banqueModel.loadData();


        int choix;
        do {
            choix = banqueView.showMenu();

            switch (choix) {
                case 1:
                    Compte compte = banqueView.getInfoCompte();
                    banqueModel.addCompte(compte);
                    break;

                case 2:
//                    aficherCompte();
                    if(!banqueModel.getNumeroComptes().isEmpty()){

                        banqueView.showNumeroComptes(banqueModel.getNumeroComptes());
                        int numeroCompte = banqueView.getNumeroCompte();
                        boolean answer = banqueModel.checkCompteIfExist(numeroCompte);
                        if (answer){
                            Movements movements = banqueModel.getMovementsFromCompte(numeroCompte);
                            banqueView.showMovementsOfCompte(movements);
                        }
                        else {
                            banqueView.showComptePasValide();
                        }

                    }
                    else {
                        banqueView.showOptionPasComptes();
                    }
                    break;

                case 3:
                    LigneComptable ligneComptable = banqueView.getInfoLigneComptable();
                    boolean answer = banqueModel.checkCompteIfExist(ligneComptable.getNumeroDeCompte());
                    if (answer){
                        banqueModel.addLigneComptable(ligneComptable);
                    }
                    else banqueView.showComptePasValide();


//                    banqueView.showOptionPasDispo();
                    break;

                case 4:
                    banqueModel.closeConnection();
                    break;

                case 5:
                    banqueView.showOptionPasDispo();
                    break;


                case 10:
//                    for (int i = 0; i < 10; i++) {
//                        comptes.add(new Compte());
//                    }
//                    addCompteToBD(comptes);
                    break;

                case 11:
//                    eraseComptesDB();
//                    comptes.clear();
                    break;

                case 12:
//                    getDataFromDB();
                    break;


                default:
                    banqueView.showOptionPasValid();

            }


        } while (choix != 4);


    }
}
