package com.company;

import datechooser.beans.DateChooserCombo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ViewBanqueI {

    BanqueController banqueController;

    private JPanel Window;
    private JPanel Menu;
    private JPanel p_creerCompte;
    private JButton b_creerCompte;
    private JButton creerLigne;
    private JButton sortir;
    private JButton b_afficherCompte;
    private JButton Aide;
    private JComboBox jComboBox_typeCompte;
    private JTextArea bienvenueSurLeLogicielTextArea;
    private JTextField textField_numeroCompte;
    private JTextField textField_valeurCreditee;
    private JTextField textField_tauxP;
    private JButton b_addCompte;
    private JPanel mainPage;
    private JPanel p_aide;
    private JTable table_movementsCompte;
    private JTextField textField_numeroCompteAfficher;
    private JButton b_afficher_compte_selectione;
    private JPanel p_afficherCompte;
    private JPanel p_createLigneComptable;
    private JTextField textField_numeroCompteLigne;
    private JComboBox JComboBox_motifAchat;
    private JTextField textField_sommeAcrediter;
    private JButton b_creerLigneComptable;
    private JComboBox JComboBox_modePaiment;
    private JSpinner spinnerDate;
    private JPanel Action;
    private JButton creerComte;

    public ViewBanqueI(){

        b_creerCompte.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                setAllInvisible();
                p_creerCompte.setVisible(true);


            }
        });
        b_addCompte.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                Compte compte = new Compte();
                compte.setTypeCompte((String.valueOf(jComboBox_typeCompte.getSelectedItem())));
                compte.setNumeroCompte(Integer.parseInt(textField_numeroCompte.getText()));
                compte.setValeurCreditee(Integer.parseInt(textField_valeurCreditee.getText()));
                compte.setTaxPlacement(Integer.parseInt(textField_tauxP.getText()));


                if(banqueController.addCompte(compte)){
                    JOptionPane.showMessageDialog(b_addCompte,"Compte added", "Logiciel",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(b_addCompte,"Numero Compte deja exist", "Logiciel",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        Aide.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                setAllInvisible();
                p_aide.setVisible(true);




            }
        });
        b_afficherCompte.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                setAllInvisible();
                p_afficherCompte.setVisible(true);
                table_movementsCompte.setVisible(false);

            }
        });
        b_afficher_compte_selectione.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                int numeroCompte = Integer.parseInt(textField_numeroCompteAfficher.getText());

                if (BanqueController.numeroCompteValid(numeroCompte)){
                    Movements movements = BanqueController.getMovements(numeroCompte);

                    String[] columnNames = {"Date", "Mode de Paiment", "Motif Achat","Somme a Crediter"};

                    ArrayList<LigneComptable> movementsList = movements.movements;

                    Object[][] data = new Object[movementsList.size()][4];

                    int index = 0;
                    for(LigneComptable temp : movementsList) {
                        data[index][0] = temp.getDateOperation();
                        data[index][1] = temp.getModeDePaiment();
                        data[index][2] = temp.getMotifAchat();
                        data[index][3] = temp.getSommeCrediter();
                        index++;
                    }

                    DefaultTableModel model = new DefaultTableModel(data, columnNames);
                    table_movementsCompte.setModel(model);
                    table_movementsCompte.setVisible(true);


                }
                else {
                    JOptionPane.showMessageDialog(b_afficher_compte_selectione,"Numero Compte  n'exist pas", "Logiciel",JOptionPane.ERROR_MESSAGE);
                }


            }
        });
        creerLigne.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                setAllInvisible();
                p_createLigneComptable.setVisible(true);

            }
        });
        b_creerLigneComptable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                int numeroCompte = Integer.parseInt(textField_numeroCompteLigne.getText());

                if (BanqueController.numeroCompteValid(numeroCompte)){

                    LigneComptable ligneComptable = new LigneComptable();
                    ligneComptable.setNumeroDeCompte(numeroCompte);
                    ligneComptable.setSommeCrediter(Double.parseDouble(textField_sommeAcrediter.getText()));

                    Date asdf = (Date) spinnerDate.getValue();
                    ligneComptable.setDateOperation(new java.sql.Date(asdf.getTime()));
                    ligneComptable.setMotifAchat(JComboBox_motifAchat.getSelectedItem().toString());
                    ligneComptable.setModeDePaiment(JComboBox_modePaiment.getSelectedItem().toString());

                    BanqueController.addLigneComptable(ligneComptable);

                }
                else {
                    JOptionPane.showMessageDialog(b_creerLigneComptable,"Numero Compte  n'exist pas", "Logiciel",JOptionPane.ERROR_MESSAGE);

                }

            }
        });
        sortir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.exit(0);
            }
        });
    }

    public void initWindow(){

        JFrame window = new JFrame("Banque");
        window.setContentPane(Window);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
        window.setSize(1024,640);


        setAllInvisible();
        bienvenueSurLeLogicielTextArea.setVisible(true);
        setupSpinnersAndModels();


    }

    private void setAllInvisible() {
        p_aide.setVisible(false);
        p_afficherCompte.setVisible(false);
        p_creerCompte.setVisible(false);
        bienvenueSurLeLogicielTextArea.setVisible(false);
        p_createLigneComptable.setVisible(false);
    }

    private void setupSpinnersAndModels() {

        String[] typeComptes = new String[]{"Courant", "Joint","Epargne"};

        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(typeComptes);

        jComboBox_typeCompte.setModel(defaultComboBoxModel);

        spinnerDate.setModel(new SpinnerDateModel(new Date(),null,null,Calendar.SHORT_FORMAT));
        spinnerDate.setEditor(new JSpinner.DateEditor(spinnerDate,"yyyy/MM/dd"));



        String [] motifAchats = new String[]{"Salaire", "Loyer", "Alimentation", "Divers" };
        defaultComboBoxModel = new DefaultComboBoxModel(motifAchats);
        JComboBox_motifAchat.setModel(defaultComboBoxModel);


        String [] modePaiment = new String[]{"CB", "Cheque", "Virement"};
        defaultComboBoxModel = new DefaultComboBoxModel(modePaiment);
        JComboBox_modePaiment.setModel(defaultComboBoxModel);



    }

    public void setControler(BanqueController banqueController) {
        this.banqueController = banqueController;
    }
}
