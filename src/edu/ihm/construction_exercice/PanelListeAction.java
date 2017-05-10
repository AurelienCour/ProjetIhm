package edu.ihm.construction_exercice;


import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import edu.ihm.noyau_fonctionnel.Action;
import edu.ihm.noyau_fonctionnel.Tentative;

/**
 * Panel permettant de visualiser la liste des actions en cours
 * @author Aurelien
 *
 */
public class PanelListeAction extends JPanel{
	
	private JLabel actionEffectue; // Le label contenant les actions
	private String lesActions; // Le string contenant la liste des actions
	private String lastAction; // La dernière action
	private String debut; // L'entête HTML du string
	private String fin; // Le fin du corps HTML
	
	/**
	 * Constructeur de la classe
	 */
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
	
	/**
	 * Constructeur de la classe pour la liste des actions d'une tentative
	 * @param tentative La tentative dont on souhaite la liste des actions
	 */
	public PanelListeAction(Tentative tentative) {
		this.setLayout(new BorderLayout());
		JPanel test = new JPanel();
		test.setLayout(new BoxLayout(test,BoxLayout.Y_AXIS));
		debut = "<html><h1>Liste des actions</h1><br>";
		lesActions = "<ul>";
		fin = "<li style=\"margin-top:10px;\">Nombres d'actions : "+tentative.getListeAction().size()+"</li></ul></html>";
		actionEffectue = new JLabel(debut+lesActions+fin);
		for (Action act : tentative.getListeAction()) {
			addAction(act.getAction());
		}
		test.add(actionEffectue);
		JScrollPane test2 = new JScrollPane(test);
		this.add(test2,BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(230, 1));
	}

	/**
	 * Permet d'ajouter une action a la liste des actions
	 * @param newAction L'action à ajouter
	 */
	public void addAction(String newAction){
		lastAction = "<li>"+newAction+"</li>";
		lesActions += lastAction;
		actionEffectue.setText(debut+lesActions+fin);
		
	}
	
	/**
	 * Fonction permettant de supprimer la dernière action en la remplacent par un string vide
	 * @param text La liste des actions
	 * @param regex Le string à supprimer
	 * @return true si l'action à correctement été remplacé
	 */
	private String deleteLast(String stringAction, String regex) {
        return stringAction.replaceFirst("(?s)(.*)" + regex, "$1" + "");
    }

	/**
	 * Permet d'effectuer les opérations nécessaire pour la suppression de la dernière action effectué
	 */
	public void removeLastAction() {
		lesActions = deleteLast(lesActions,lastAction);
		actionEffectue.setText(deleteLast(actionEffectue.getText(),lastAction));
		lastAction="";
	}

}
