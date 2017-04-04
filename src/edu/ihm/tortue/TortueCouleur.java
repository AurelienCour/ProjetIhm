package edu.ihm.tortue; 
/**
 * Tortue LOGO capable d'�crire en couleur
 * Seules les couleurs suivantes sont autoris�es :
 *  "black", "red", "blue", "green", "yellow" , "magenta"
 *  Si la couleur demand�e est diff�rente, la tortue �crit en noir
 *  
 * @author Patrick Girard 
 * @version f�vrier 2017
 */


public class TortueCouleur extends TortueG {

    // Couleurs
    private static final String lesCouleurs[] = { "black", "red", "blue", "green", "yellow" , "magenta" };
    
    /**
     * Constructeur par d�faut, la tortue �crit en noir
     *
     */
    public TortueCouleur() {
        super();
    }

    
    /**
     * Constructeur permettant de sp�cifier la couleur
     *
     * @param coul la couleur demand�e
     */
    public TortueCouleur(String coul) {
        super();
        couleurTrace = rendCouleur(coul);
    }
    
    /**
     * M�thode setCouleur : change la couleur de la tortue
     *
     * @param coul la couleur demand�e
     */
    public void setCouleur(String coul){
        couleurTrace = rendCouleur(coul);
    }
    
    /**
     * Accesseur de la couleur
     *
     * @return la couleur de la tortue
     */
    public String getCouleur() {
        return couleurTrace;
    }
    
    /**
     * M�thode rendCouleur : permet de v�rifier que la couleur demand�e est correcte
     * rend "black" sinon
     *
     * @param coul la couleur demand�e
     * @return la couleur v�rifi�e
     */
    private String rendCouleur(String coul) {
        for (int i=0; i<lesCouleurs.length; i++)
            if (coul.equalsIgnoreCase(lesCouleurs[i]))
              return coul.toLowerCase();
        return "black";
    }

}