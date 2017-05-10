package edu.ihm.acceuil;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import edu.ihm.Main.Database;
import edu.ihm.menu.PanelMenu;
import edu.ihm.noyau_fonctionnel.Utilisateur;

/**
 * La JFrame principal de notre application
 * @author Aurelien
 *
 */
public abstract class Acceuil extends JFrame{
	
	private Utilisateur user; // L'utilisateur connecté
	private PanelMenu menu; // Le Menu de notre application
	private JScrollPane j; // Le panel contenant le JTree
	private Database db; // La base de données
	
	/**
	 * Le constructeur de notre class
	 * @param user L'utilisateur connecté
	 * @param db La database de notre application
	 */
	public Acceuil (Utilisateur user, Database db){
		this.user = user;
		this.db = db;
		this.menu = new PanelMenu(this);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(user.getNom());
		j = new JScrollPane(this.menu.getJTree());
		j.setBackground(new Color(225, 206, 154));
		j.setPreferredSize(new Dimension(180,150));
		this.add(j,BorderLayout.WEST);
		this.setVisible(true);
		Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) size.getWidth();
		int height = (int) size.getHeight();
		this.setSize(new Dimension(width, height-22));
		this.setLocationRelativeTo(null);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				dispose();
				Acceuil.this.sauvegardeBdd();
				System.exit(0);
			}
		});
	}
	
	/**
	 * Fonction permettant de sauvegardé les données de notre application
	 */
	private void sauvegardeBdd() {
		db.save();
	}

	/**
	 * Permet de récupérer l'utilisateur connecté
	 * @return L'utilisateur connecté sur l'application
	 */
	public Utilisateur getUser(){
		return this.user;
	}
	
	/**
	 * Permet de raffraichir le JTree après modification
	 */
	public void reloadTree(){
		this.remove(j);
		menu = new PanelMenu(this);
		j = new JScrollPane(menu.getJTree());
		j.setPreferredSize(new Dimension(180,150));
		this.add(j,BorderLayout.WEST);
	}

}
