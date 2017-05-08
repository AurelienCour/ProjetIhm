package edu.ihm.construction_exercice;


import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import edu.ihm.noyau_fonctionnel.Action;
import edu.ihm.noyau_fonctionnel.Tentative;

/**
 * Panel permettant de visualiser la liste des actions en cours
 * Va utiliser un objet de type tentatives
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelListeAction extends JPanel{
	
	private JLabel actionEffectue;
	private String lesActions;
	private String lastAction;
	private String debut;
	private String fin;
	
	public PanelListeAction(){
		this.setLayout(new BorderLayout());
		JPanel test = new JPanel();
		test.setLayout(new BoxLayout(test,BoxLayout.Y_AXIS));
		debut = "<html><h1>Liste des actions</h1><br>";
		lesActions = "<ul>";
		fin = "</ul></html>";
		actionEffectue = new JLabel(debut+lesActions+fin);
		test.add(actionEffectue);
		JScrollPane test2 = new JScrollPane(test);
		this.add(test2,BorderLayout.CENTER);
	}
	
	public PanelListeAction(Tentative tentative) {
		this.setLayout(new BorderLayout());
		JPanel test = new JPanel();
		test.setLayout(new BoxLayout(test,BoxLayout.Y_AXIS));
		debut = "<html><h1>Liste des actions</h1><br>";
		lesActions = "<ul>";
		fin = "</ul></html>";
		actionEffectue = new JLabel(debut+lesActions+fin);
		for (Action act : tentative.getListeAction()) {
			addAction(act.getAction());
		}
		test.add(actionEffectue);
		JScrollPane test2 = new JScrollPane(test);
		this.add(test2,BorderLayout.CENTER);
	}

	public void addAction(String newAction){
		lastAction = "<li>"+newAction+"</li>";
		lesActions += lastAction;
		actionEffectue.setText(debut+lesActions+fin);
		
	}
	
	private String deleteLast(String text, String regex) {
        return text.replaceFirst("(?s)(.*)" + regex, "$1" + "");
    }

}
