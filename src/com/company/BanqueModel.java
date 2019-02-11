package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BanqueModel {

    static final String DB_URL = "jdbc:mysql://localhost:3306";

    static final String USER = "root";
    static final String PASS = "";
    static Connection conn = null;


    static List<Compte> comptes = new ArrayList<Compte>();
    static Map<Integer, Movements> movementsMap = new HashMap<>();


    public BanqueModel() {
    }


    public void addCompte(Compte compte) {
        comptes.add(compte);
        addCompteToDataBase(compte);
    }

    private void addCompteToDataBase(Compte compte) {

        Statement stmt = null;

        try {
            stmt = conn.createStatement();

            String sql;
            sql = "USE BanqueComptes;";

            stmt.executeQuery(sql);

            sql = "INSERT INTO Comptes (numeroCompte,typeCompte,valeurCreditee,taxPlacement) VALUES (?,?,?,?)";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1,compte.getNumeroCompte());
            preparedStmt.setString(2,compte.getTypeCompte());
            preparedStmt.setInt(3,compte.getValeurCreditee());
            preparedStmt.setInt(4,compte.getTaxPlacement());

            preparedStmt.execute();
            //System.out.println("Compte added to the DataBase");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Compte> getComptes() {
        return comptes;
    }

    public ArrayList<Integer> getNumeroComptes() {
        ArrayList<Integer> numeroComptes = new ArrayList<>();

        for (Compte temp : comptes) {
            numeroComptes.add(temp.numeroCompte);
        }

        return numeroComptes;
    }

    public boolean checkCompteIfExist(int numeroCompte) {

        for (Compte temp : comptes) {
            if (temp.numeroCompte == numeroCompte) return true;
        }
        return false;

    }

    public Movements getMovementsFromCompte(int numeroCompte) {


        Statement stmt = null;

        try {
            stmt = conn.createStatement();

            String sql;
            sql = "USE BanqueComptes;";

            stmt.executeQuery(sql);

            sql = "SELECT * FROM Movements WHERE numeroCompte = " + numeroCompte + " ORDER BY dateOperation DESC LIMIT 10;";

            ResultSet rs = stmt.executeQuery(sql);

            Movements movements = new Movements();

            while (rs.next()) {
                //Retrieve by column name

                LigneComptable ligneComptable = new LigneComptable();
                ligneComptable.setNumeroDeCompte(rs.getInt("numeroCompte"));
                ligneComptable.setSommeCrediter(rs.getDouble("sommeCrediter"));
                ligneComptable.setDateOperation(rs.getDate("dateOperation"));
                ligneComptable.setMotifAchat(rs.getString("motifAchat"));
                ligneComptable.setModeDePaiment(rs.getString("modeDePaiment"));


                movements.movements.add(ligneComptable);

            }
            System.out.println("Loading of Movements Done");

            return movements;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    public void loadData() {
        connectToDataBase();

        Statement stmt = null;

        try {
            stmt = conn.createStatement();

            String sql;
            sql = "USE BanqueComptes;";

            stmt.executeQuery(sql);

            sql = "SELECT * FROM Comptes;";

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {
                //Retrieve by column name
                Compte compteTemp = new Compte();
                compteTemp.setNumeroCompte(rs.getInt("numeroCompte"));
                compteTemp.setTaxPlacement(rs.getInt("taxPlacement"));
                compteTemp.setValeurCreditee(rs.getInt("valeurCreditee"));
                compteTemp.setTypeCompte(rs.getString("typeCompte"));

                //Display values
                comptes.add(compteTemp);
                //System.out.println(compteTemp);
            }
            System.out.println("Loading of DataBase Done");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void connectToDataBase() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("org.gjt.mm.mysql.Driver");
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");

        try {

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addLigneComptable(LigneComptable ligneComptable) {
        addLigneComptableToDataBase(ligneComptable);
    }

    private void addLigneComptableToDataBase(LigneComptable ligneComptable) {

        Statement stmt = null;

        try {
            stmt = conn.createStatement();

            String sql;
            sql = "USE BanqueComptes;";

            stmt.executeQuery(sql);

            sql = "INSERT INTO Movements (numeroCompte,sommeCrediter,dateOperation,motifAchat,modeDePaiment) VALUES  (?,?,?,?,?)";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1,ligneComptable.getNumeroDeCompte());
            preparedStmt.setDouble(2,ligneComptable.getSommeCrediter());
            preparedStmt.setDate(3, (java.sql.Date) ligneComptable.getDateOperation());
            preparedStmt.setString(4,ligneComptable.getMotifAchat());
            preparedStmt.setString(5,ligneComptable.getModeDePaiment());

            preparedStmt.execute();
            System.out.println("Ligne comptable added to the DataBase");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
