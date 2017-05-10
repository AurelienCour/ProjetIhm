package edu.ihm.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import edu.ihm.Main.Database;
import edu.ihm.acceuil.AcceuilEleve;
import edu.ihm.acceuil.AcceuilProf;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Professeur;

/**
 * Classe permettant de gérer la connexion
 * @author Aurelien
 *
 */
public class LoginDialog extends JDialog {
	 
    private JTextField tfUsername; // Le field contenant l'ID
    private JPasswordField pfPassword; // La field contenant le password
    private JLabel lbUsername; // Label d'affichage
    private JLabel lbPassword; // Label d'affichage
    private JButton btnLogin; // Le bouton de connexion
    private JButton btnCancel; // Le bouton cancel
    private boolean succeeded; // Booleen permettant de savoir si la connexion est réussi
 
    /**
     * Constructeur de la classe
     * @param db Database contenant les différents utilisateurs
     */
    public LoginDialog(Database db) {
    	this.setUndecorated(true);
    	this.setTitle("Login");
    	JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        lbUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);
 
        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);
 
        lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);
 
        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));
 
        btnLogin = new JButton("Login");
 
        btnLogin.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
            	for(Entry<String, Object> entry2 : db.getProfesseur().entrySet()) {
        			Professeur prof = (Professeur) entry2.getValue();
        			if(prof.getIdentifiant().equals(getUsername()) && prof.getMotDePasse().equals(getPassword())){
        				succeeded = true;
        				dispose();
        				AcceuilProf a = new AcceuilProf(prof,db);
        			}
        		}
            	for(Entry<String, Object> entry2 : db.getEleves().entrySet()) {
    				Eleve eleve = (Eleve) entry2.getValue();
    				if(eleve.getIdentifiant().equals(getUsername()) && eleve.getMotDePasse().equals(getPassword())){
        				succeeded = true;
        				dispose();
        				AcceuilEleve a = new AcceuilEleve(eleve,db);
        			}
        		}
            	if(!succeeded){
            		JOptionPane.showMessageDialog(LoginDialog.this,
                            "Invalid username or password",
                            "Login",
                            JOptionPane.ERROR_MESSAGE);
                    // reset username and password
                    tfUsername.setText("");
                    pfPassword.setText("");
                    succeeded = false;
            	}
            }
        });
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JPanel bp = new JPanel();
        bp.add(btnLogin);
        bp.add(btnCancel);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
        pack();
        setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
	}

    /**
     * Permet de récupérer l'identifiant
     * @return L'identifiant saisie
     */
	public String getUsername() {
        return tfUsername.getText().trim();
    }
 
	/**
     * Permet de récupérer le mot de passe
     * @return Le password saisie
     */
    public String getPassword() {
        return new String(pfPassword.getPassword());
    }
}