package com.company;

public class Main {

    public static void main(String[] args) {

        BanqueModel banqueModel = new BanqueModel();
        BanqueView banqueView = new BanqueView();
        ViewBanqueI viewBanqueI = new ViewBanqueI();
        BanqueController banqueController = new BanqueController(banqueModel,banqueView,viewBanqueI);
        viewBanqueI.setControler(banqueController);

        BanqueController.init();

	// write your code here
    }
}
