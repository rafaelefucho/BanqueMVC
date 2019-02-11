package com.company;

public class Main {

    public static void main(String[] args) {

        BanqueModel banqueModel = new BanqueModel();
        BanqueView banqueView = new BanqueView();
        BanqueController banqueController = new BanqueController(banqueModel,banqueView);

        BanqueController.init();

	// write your code here
    }
}
