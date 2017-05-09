package edu.ihm.acceuil;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import edu.ihm.Main.Database;
import edu.ihm.menu.PanelMenu;
import edu.ihm.noyau_fonctionnel.Utilisateur;

public abstract class Acceuil extends JFrame{
	
	private Utilisateur user;
	private PanelMenu menu;
	private JScrollPane j;
	private Database db;
	/*private Map<String, Object> professeurs;
	private Map<String, Object> eleves;*/
	
	public Acceuil (Utilisateur user, Database db){
		this.user = user;
		this.db = db;
		this.menu = new PanelMenu(this);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(user.getNom());
		j = new JScrollPane(this.menu.getJTree());
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
	
	private void sauvegardeBdd() {
		db.save();
	}

	public Utilisateur getUser(){
		return this.user;
	}
	
	public void reloadTree(){
		this.remove(j);
		menu = new PanelMenu(this);
		j = new JScrollPane(menu.getJTree());
		j.setPreferredSize(new Dimension(180,150));
		this.add(j,BorderLayout.WEST);
	}

}
