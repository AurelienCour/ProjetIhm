package edu.ihm.acceuil;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import edu.ihm.menu.PanelMenu;
import edu.ihm.noyau_fonctionnel.Utilisateur;

public abstract class Acceuil extends JFrame{
	
	private Utilisateur user;
	
	public Acceuil (Utilisateur user){
		this.user = user;
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(user.getNom());
		JScrollPane j = new JScrollPane(new PanelMenu(this).getJTree());
		this.add(j,BorderLayout.WEST);
		this.setVisible(true);
		this.setSize(new Dimension(500,500));
	}
	
	public Utilisateur getUser(){
		return this.user;
	}

}
