package com.company;

public class BanqueController {


    static BanqueModel banqueModel;
    static BanqueView banqueView;
    static ViewBanqueI viewBanqueI;

    public BanqueController(BanqueModel banqueModel, BanqueView banqueView, ViewBanqueI viewBanqueI) {
        this.banqueModel = banqueModel;
        this.banqueView = banqueView;
        this.viewBanqueI = viewBanqueI;
    }

    public static void init() {


        banqueModel.loadData();
        viewBanqueI.initWindow();

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

    public static boolean numeroCompteValid(int numeroCompte) {
        return banqueModel.checkCompteIfExist(numeroCompte);

    }

    public static Movements getMovements(int numeroCompte) {
        return banqueModel.getMovementsFromCompte(numeroCompte);
    }

    public static void addLigneComptable(LigneComptable ligneComptable) {
        banqueModel.addLigneComptable(ligneComptable);
    }

    public boolean addCompte(Compte compte) {

        if(!banqueModel.checkCompteIfExist(compte.getNumeroCompte())){
            banqueModel.addCompte(compte);
            return true;
        }
        return false;


    }
}
