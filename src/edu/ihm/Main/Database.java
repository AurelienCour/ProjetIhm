package edu.ihm.Main;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import edu.ihm.noyau_fonctionnel.Action;
import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Evaluation;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;
import edu.ihm.noyau_fonctionnel.Professeur;
import edu.ihm.noyau_fonctionnel.Tentative;

public class Database
{
	
	private Map<String,Object> sauvegardeProfesseur;
	private Map<String,Object> sauvegardeExercice;
	private Map<String,Object> sauvegardeEleve;
	private Map<String,Object> sauvegardeClasse;
	
	private Map<String,Object> sauvegardeAction;
	private Map<String,Object> sauvegardeEvaluation;
	private Map<String,Object> sauvegardeExerciceRealise;
	private Map<String,Object> sauvegardeTentative;
	private URL linkDb;

	public Database(){
		linkDb = Database.class.getResource("/");
		createDatabase();
		sauvegardeProfesseur = new HashMap<String,Object>();
		sauvegardeExercice = new HashMap<String,Object>();
		sauvegardeEleve = new HashMap<String,Object>();
		sauvegardeClasse = new HashMap<String,Object>();
		
		sauvegardeAction = new HashMap<String,Object>();
		sauvegardeEvaluation = new HashMap<String,Object>();
		sauvegardeExerciceRealise = new HashMap<String,Object>();
		sauvegardeTentative = new HashMap<String,Object>();
	}

	public void createDatabase(){
		// load the sqlite-JDBC driver using the current class loader
		try
		{
			Class.forName("org.sqlite.JDBC");
		}
		catch(ClassNotFoundException e){
			System.out.println("Impossible de charger le driver");
		}

		Connection connection = null;
		try
		{
			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:"+linkDb+"BddIhm.db");

			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.

			statement.executeUpdate("create table if not exists ACTION"
									+"("
									+"   IDACTION             INTEGER PRIMARY KEY AUTOINCREMENT,"
									+"   ACTIONFAITE          char(25) not null"
									+")");

			statement.executeUpdate("create table if not exists PROFESSEUR"
									+"("
									+   "IDPROFESSEUR         INTEGER PRIMARY KEY AUTOINCREMENT,"
									+   "IDENTIFIANT          char(25) not null,"
									+   "MOTDEPASSE           char(25) not null,"
									+   "NOM                  char(50) not null,"
									+   "PRENOM               char(50) not null"
									+")");

			statement.executeUpdate("create table if not exists EXERCICE"
									+"("
									+   "IDEXERCICE           INTEGER PRIMARY KEY AUTOINCREMENT,"
									+   "NOMEXERCICE          char(50) not null,"
									+   "TYPEEXERCICE         char(10) not null,"
									+   "MODELE               char(50) not null"
									+")");


			statement.executeUpdate("create table if not exists CLASSE"
									+"("
									+   "IDCLASSE             INTEGER PRIMARY KEY AUTOINCREMENT,"
									+   "IDPROFESSEUR         INTEGER not null,"
									+ 	"NOMCLASSE			  char(50) not null,"
									+	"FOREIGN KEY(IDPROFESSEUR) REFERENCES PROFESSEUR(IDPROFESSEUR)"
									+")");

			statement.executeUpdate("create table if not exists AVOIR"
									+"("
									+   "IDCLASSE             INTEGER,"
									+   "IDEXERCICE           INTEGER,"
									+	"FOREIGN KEY(IDCLASSE) REFERENCES CLASSE(IDCLASSE),"
									+	"FOREIGN KEY(IDEXERCICE) REFERENCES EXERCICE(IDEXERCICE)"
									+")");

			statement.executeUpdate("create table if not exists ELEVE"
									+"("
									+   "IDELEVE             INTEGER PRIMARY KEY AUTOINCREMENT,"
									+   "IDCLASSE             INTEGER not null,"
									+   "IDENTIFIANT          char(25) not null,"
									+   "MOTDEPASSE           char(25) not null,"
									+   "NOM                  char(50) not null,"
									+   "PRENOM               char(50) not null,"
									+   "PHOTO                char(50),"
									+	"FOREIGN KEY(IDCLASSE) REFERENCES CLASSE(IDCLASSE)"
									+")");

			statement.executeUpdate("create table if not exists EVALUATION"
									+"("
									+   "IDEVALUATION         INTEGER PRIMARY KEY AUTOINCREMENT,"
									+   "IDEXERCICEREALISE    INTEGER not null,"
									+   "NOTE                 char(20) not null,"
									+   "COMMENTAIRE          text not null,"
									+	"FOREIGN KEY(IDEXERCICEREALISE) REFERENCES EXERCICEREALISEE(IDEXERCICEREALISE)"
									+")");
			
			statement.executeUpdate("create table if not exists EXERCICEREALISEE"
									+"("
									+   "IDEXERCICEREALISE    INTEGER PRIMARY KEY AUTOINCREMENT,"
									+   "IDEXERCICE           INTEGER not null,"
									+   "IDEVALUATION         INTEGER,"
									+   "IDELEVE              INTEGER not null,"
									+	"FOREIGN KEY(IDEXERCICE) REFERENCES EXERCICE(IDEXERCICE),"
									+	"FOREIGN KEY(IDEVALUATION) REFERENCES EVALUATION(IDEVALUATION)"
									+	"FOREIGN KEY(IDELEVE) REFERENCES ENFANT(IDELEVE)"
									+")");
			
			statement.executeUpdate("create table if not exists CONTENIR"
									+"("
									+   "IDTENTATIVE          INTEGER,"
									+   "IDACTION             INTEGER,"
									+	"FOREIGN KEY(IDACTION) REFERENCES ACTION(IDACTION),"
									+	"FOREIGN KEY(IDTENTATIVE) REFERENCES TENTATIVES(IDTENTATIVE)"
									+")");
			
			statement.executeUpdate("create table if not exists TENTATIVES"
									+"("
									+   "IDTENTATIVE          INTEGER PRIMARY KEY AUTOINCREMENT,"
									+   "IDEXERCICEREALISE    INTEGER not null,"
									+	"FOREIGN KEY(IDEXERCICEREALISE) REFERENCES EXERCICEREALISEE(IDEXERCICEREALISE)"
									+")");

		}

		catch(SQLException e){  System.err.println(e.getMessage()); }       
		finally {         
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) {  // Use SQLException class instead.          
				System.err.println(e); 
			}
		}
	}

	public void peuplement(){
		// load the sqlite-JDBC driver using the current class loader
		try
		{
			Class.forName("org.sqlite.JDBC");
		}
		catch(ClassNotFoundException e){
			System.out.println("Impossible de charger le driver");
		}

		Connection connection = null;
		try
		{
			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:"+linkDb+"BddIhm.db");

			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.

			statement.executeUpdate("INSERT INTO PROFESSEUR(IDENTIFIANT,MOTDEPASSE,NOM,PRENOM) values('Girard','pg','Girard','Patrick'),('Genniet','ag','Genniet','Annie')");
			
			statement.executeUpdate("INSERT INTO CLASSE (IDPROFESSEUR,NOMCLASSE) VALUES (1,'Master1'),(2,'Licence3')");
			
			statement.executeUpdate("INSERT INTO ELEVE (IDCLASSE,IDENTIFIANT,MOTDEPASSE,NOM,PRENOM,PHOTO) values (1,'aurelien','Acourtillat','Courtillat','Aurelien','Aurelien.jpg'),(1,'mathias','Mantunes','Antunes','Mathias','Mathias.jpg')");
			statement.executeUpdate("INSERT INTO ELEVE (IDCLASSE,IDENTIFIANT,MOTDEPASSE,NOM,PRENOM,PHOTO) values (2,'audrey','Amartin','Martin','Audrey','Audrey.jpg'),(2,'marin','Mconrady','Conrady','Marin','Marin.jpg')");
		}
		catch(SQLException e){  System.err.println(e.getMessage()); }       
		finally {         
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) {  // Use SQLException class instead.          
				System.err.println(e); 
			}
		}
	}
	
	public void chargementDonnees(){
		// load the sqlite-JDBC driver using the current class loader
		try
		{
			Class.forName("org.sqlite.JDBC");
		}
		catch(ClassNotFoundException e){
			System.out.println("Impossible de charger le driver");
		}

		Connection connection = null;
		try
		{
			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:"+linkDb+"BddIhm.db");

			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.
			
			
			//PROFESSEUR
			ResultSet resultSet = statement.executeQuery("SELECT * from PROFESSEUR");
			while(resultSet.next())
			{
				Professeur prof = new Professeur(resultSet.getString("IDENTIFIANT"),
									resultSet.getString("MOTDEPASSE"),
									resultSet.getString("NOM"),
									resultSet.getString("PRENOM")); 
				sauvegardeProfesseur.put(Integer.toString(resultSet.getInt("IDPROFESSEUR")),prof);
			}
			
			
			//EXERCICE
			resultSet = statement.executeQuery("SELECT * from EXERCICE");
			while(resultSet.next())
			{
				Exercice exo = new Exercice(resultSet.getString("NOMEXERCICE"),
									resultSet.getString("TYPEEXERCICE"),
									resultSet.getString("MODELE"));
				sauvegardeExercice.put(Integer.toString(resultSet.getInt("IDEXERCICE")),exo);
			}
			

			//ELEVE
			resultSet = statement.executeQuery("SELECT * from ELEVE");
			while(resultSet.next())
			{
				Eleve eleve = new Eleve(resultSet.getString("IDENTIFIANT"),
							resultSet.getString("MOTDEPASSE"),
							resultSet.getString("NOM"),
							resultSet.getString("PRENOM"),
							null,
							resultSet.getString("PHOTO"));
				sauvegardeEleve.put(Integer.toString(resultSet.getInt("IDELEVE")), eleve);
			}

			//CLASSE
			resultSet = statement.executeQuery("SELECT * from CLASSE");
			while(resultSet.next())
			{
				Classes cla = new Classes(resultSet.getString("NOMCLASSE"));
				sauvegardeClasse.put(Integer.toString(resultSet.getInt("IDCLASSE")),cla);
			}
			
			//ACTION
			resultSet = statement.executeQuery("SELECT * from ACTION");
			while(resultSet.next())
			{
				Action action = new Action(resultSet.getString("ACTIONFAITE"));
				sauvegardeAction.put(Integer.toString(resultSet.getInt("IDACTION")),action);
			}
			
			//EVALUATION
			resultSet = statement.executeQuery("SELECT * from EVALUATION");
			while(resultSet.next())
			{
				Evaluation eval = new Evaluation(resultSet.getString("NOTE"), resultSet.getString("COMMENTAIRE"));
				sauvegardeEvaluation.put(Integer.toString(resultSet.getInt("IDEVALUATION")),eval);
			}
			
			//EXERCICEREALISEE
			resultSet = statement.executeQuery("SELECT * from EXERCICEREALISEE");
			while(resultSet.next())
			{
				for(Entry<String, Object> entry2 : sauvegardeExercice.entrySet()) {
					if(entry2.getKey().equals(Integer.toString(resultSet.getInt("IDEXERCICE")))){
						Exercice exo = (Exercice) entry2.getValue();
						ExerciceRealise exoR = new ExerciceRealise(exo);
						sauvegardeExerciceRealise.put(Integer.toString(resultSet.getInt("IDEXERCICEREALISE")),exoR);
					}
				}
			}
			
			//TENTATIVES
			resultSet = statement.executeQuery("SELECT * from TENTATIVES");
			while(resultSet.next())
			{
				Tentative tent = new Tentative();
				sauvegardeTentative.put(Integer.toString(resultSet.getInt("IDTENTATIVE")),tent);
			}
			
			
			// On fait les liaison des objets
			
			// On ajoute les classes aux professeurs
			for(Entry<String, Object> entry : sauvegardeProfesseur.entrySet()) {
				String idPrimaire = entry.getKey();
				Professeur prof = (Professeur) entry.getValue();
				if(idPrimaire != null){ // Si on a un résultat
					resultSet = statement.executeQuery("SELECT IDCLASSE from CLASSE where IDPROFESSEUR="
													+Integer.parseInt(idPrimaire)); // On recupère l'id des exercices liés
					while(resultSet.next())  // Tant que l'on a des résultats
					{
						for(Entry<String, Object> entry2 : sauvegardeClasse.entrySet()) {
							if(entry2.getKey().equals(Integer.toString(resultSet.getInt("IDCLASSE")))){
								prof.addClasses((Classes) entry2.getValue());
							}
						}
					}
				}
			}
			
			// On ajoute les Exercices aux classes
			for(Entry<String, Object> entry : sauvegardeClasse.entrySet()) {
				String idPrimaire = entry.getKey();
				Classes cl = (Classes) entry.getValue();
				
				if(idPrimaire != null){ // Si on a un résultat
					resultSet = statement.executeQuery("SELECT IDEXERCICE from AVOIR where IDCLASSE="
													+Integer.parseInt(idPrimaire)); // On recupère l'id des exercices liés
					while(resultSet.next())  // Tant que l'on a des résultats
					{
						for(Entry<String, Object> entry2 : sauvegardeExercice.entrySet()) {
							if(entry2.getKey().equals(Integer.toString(resultSet.getInt("IDEXERCICE")))){
								Exercice test = (Exercice) entry2.getValue();
								cl.addExercice((Exercice) entry2.getValue()); 
							}
						}
					}
				}
			}

			// On ajoute les Eleve aux classes et la classe aux eleve
			for(Entry<String, Object> entry : sauvegardeClasse.entrySet()) {
				String idPrimaire = entry.getKey();
				Classes cl = (Classes) entry.getValue();
				if(idPrimaire != null){ // Si on a un résultat
					resultSet = statement.executeQuery("SELECT IDELEVE from ELEVE where IDCLASSE="
													+Integer.parseInt(idPrimaire)); // On recupère l'id des exercices liés
					while(resultSet.next())  // Tant que l'on a des résultats
					{
						for(Entry<String, Object> entry2 : sauvegardeEleve.entrySet()) {
							if(entry2.getKey().equals(Integer.toString(resultSet.getInt("IDELEVE")))){
								Eleve eleve = (Eleve) entry2.getValue();
								cl.addEleve(eleve);
								eleve.setClasse(cl);
							}
						}
					}
				}
			}
			
			// On ajoute les Exercice Real aux eleve
			for(Entry<String, Object> entry : sauvegardeEleve.entrySet()) {
				String idPrimaire = entry.getKey();
				Eleve eleve = (Eleve) entry.getValue();
				if(idPrimaire != null){ // Si on a un résultat
					resultSet = statement.executeQuery("SELECT IDEXERCICEREALISE from EXERCICEREALISEE where IDELEVE="
													+Integer.parseInt(idPrimaire)); // On recupère l'id des exercices liés
					while(resultSet.next())  // Tant que l'on a des résultats
					{
						for(Entry<String, Object> entry2 : sauvegardeExerciceRealise.entrySet()) {
							if(entry2.getKey().equals(Integer.toString(resultSet.getInt("IDEXERCICEREALISE")))){
								ExerciceRealise exoR = (ExerciceRealise) entry2.getValue();
								eleve.addExerciceRealise(exoR);
							}
						}
					}
				}
			}
			
			// On assigne l'Exercice a l'exercice realise ainsi que les tentatives ainsi que l'évaluation
			for(Entry<String, Object> entry : sauvegardeExerciceRealise.entrySet()) {
				String idPrimaire = entry.getKey();
				ExerciceRealise exo = (ExerciceRealise) entry.getValue();
				if(idPrimaire != null){ // Si on a un résultat
					resultSet = statement.executeQuery("SELECT IDEVALUATION from EVALUATION where IDEXERCICEREALISE="
													+Integer.parseInt(idPrimaire));
					while(resultSet.next())  // Tant que l'on a des résultats
					{
						for(Entry<String, Object> entry2 : sauvegardeEvaluation.entrySet()) {
							if(entry2.getKey().equals(Integer.toString(resultSet.getInt("IDEVALUATION")))){
								Evaluation eval = (Evaluation) entry2.getValue();
								exo.corriger(eval);
							}
						}
					}
					
					resultSet = statement.executeQuery("SELECT IDTENTATIVE from TENTATIVES where IDEXERCICEREALISE="
							+Integer.parseInt(idPrimaire));
					while(resultSet.next())  // Tant que l'on a des résultats
					{
						for(Entry<String, Object> entry2 : sauvegardeTentative.entrySet()) {
							if(entry2.getKey().equals(Integer.toString(resultSet.getInt("IDTENTATIVE")))){
								
								Tentative tent = (Tentative) entry2.getValue();
								exo.addTentative(tent);
							}
						}
					}
				}
			}
			
			// On assigne les actions aux tentatives
			for(Entry<String, Object> entry : sauvegardeTentative.entrySet()) {
				String idPrimaire = entry.getKey();
				Tentative tenta = (Tentative) entry.getValue();
				if(idPrimaire != null){ // Si on a un résultat
					resultSet = statement.executeQuery("SELECT IDACTION from CONTENIR where IDTENTATIVE="
													+Integer.parseInt(idPrimaire)); // On recupère l'id des exercices liés
					while(resultSet.next())  // Tant que l'on a des résultats
					{
						for(Entry<String, Object> entry2 : sauvegardeAction.entrySet()) {
							if(entry2.getKey().equals(Integer.toString(resultSet.getInt("IDACTION")))){
								Action act = (Action) entry2.getValue();
								tenta.addAction(act);
							}
						}
					}
				}
			}
			
			
		}
		catch(SQLException e){  System.err.println(e.getMessage()); }       
		finally {         
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) {  // Use SQLException class instead.          
				System.err.println(e); 
			}
		}
	}
	
	public Map<String,Object> getProfesseur(){
		return sauvegardeProfesseur;
	}
	
	public Map<String,Object> getEleves(){
		return sauvegardeEleve;
	}

	public void save() {
		// load the sqlite-JDBC driver using the current class loader
		try
		{
			Class.forName("org.sqlite.JDBC");
		}
		catch(ClassNotFoundException e){
			System.out.println("Impossible de charger le driver");
		}

		Connection connection = null;
		try
		{
			File fichier = new File(linkDb.getPath()+"BddIhm.db");
			if(fichier.delete()){
				connection = DriverManager.getConnection("jdbc:sqlite:"+linkDb+"BddIhm.db");
				Statement statement = connection.createStatement();
				statement.setQueryTimeout(30);  // set timeout to 30 sec.
				
				statement.executeUpdate("create table if not exists ACTION"
						+"("
						+"   IDACTION             INTEGER PRIMARY KEY AUTOINCREMENT,"
						+"   ACTIONFAITE          char(25) not null"
						+")");
	
				statement.executeUpdate("create table if not exists PROFESSEUR"
								+"("
								+   "IDPROFESSEUR         INTEGER PRIMARY KEY AUTOINCREMENT,"
								+   "IDENTIFIANT          char(25) not null,"
								+   "MOTDEPASSE           char(25) not null,"
								+   "NOM                  char(50) not null,"
								+   "PRENOM               char(50) not null"
								+")");
				
				statement.executeUpdate("create table if not exists EXERCICE"
								+"("
								+   "IDEXERCICE           INTEGER PRIMARY KEY AUTOINCREMENT,"
								+   "NOMEXERCICE          char(50) not null,"
								+   "TYPEEXERCICE         char(10) not null,"
								+   "MODELE               char(50) not null"
								+")");
				
				
				statement.executeUpdate("create table if not exists CLASSE"
								+"("
								+   "IDCLASSE             INTEGER PRIMARY KEY AUTOINCREMENT,"
								+   "IDPROFESSEUR         INTEGER not null,"
								+ 	"NOMCLASSE			  char(50) not null,"
								+	"FOREIGN KEY(IDPROFESSEUR) REFERENCES PROFESSEUR(IDPROFESSEUR)"
								+")");
				
				statement.executeUpdate("create table if not exists AVOIR"
								+"("
								+   "IDCLASSE             INTEGER,"
								+   "IDEXERCICE           INTEGER,"
								+	"FOREIGN KEY(IDCLASSE) REFERENCES CLASSE(IDCLASSE),"
								+	"FOREIGN KEY(IDEXERCICE) REFERENCES EXERCICE(IDEXERCICE)"
								+")");
				
				statement.executeUpdate("create table if not exists ELEVE"
								+"("
								+   "IDELEVE             INTEGER PRIMARY KEY AUTOINCREMENT,"
								+   "IDCLASSE             INTEGER not null,"
								+   "IDENTIFIANT          char(25) not null,"
								+   "MOTDEPASSE           char(25) not null,"
								+   "NOM                  char(50) not null,"
								+   "PRENOM               char(50) not null,"
								+   "PHOTO                char(50),"
								+	"FOREIGN KEY(IDCLASSE) REFERENCES CLASSE(IDCLASSE)"
								+")");
				
				statement.executeUpdate("create table if not exists EVALUATION"
								+"("
								+   "IDEVALUATION         INTEGER PRIMARY KEY AUTOINCREMENT,"
								+   "IDEXERCICEREALISE    INTEGER not null,"
								+   "NOTE                 char(20) not null,"
								+   "COMMENTAIRE          text not null,"
								+	"FOREIGN KEY(IDEXERCICEREALISE) REFERENCES EXERCICEREALISEE(IDEXERCICEREALISE)"
								+")");
				
				statement.executeUpdate("create table if not exists EXERCICEREALISEE"
								+"("
								+   "IDEXERCICEREALISE    INTEGER PRIMARY KEY AUTOINCREMENT,"
								+   "IDEXERCICE           INTEGER not null,"
								+   "IDEVALUATION         INTEGER,"
								+   "IDELEVE              INTEGER not null,"
								+	"FOREIGN KEY(IDEXERCICE) REFERENCES EXERCICE(IDEXERCICE),"
								+	"FOREIGN KEY(IDEVALUATION) REFERENCES EVALUATION(IDEVALUATION)"
								+	"FOREIGN KEY(IDELEVE) REFERENCES ENFANT(IDELEVE)"
								+")");
				
				statement.executeUpdate("create table if not exists CONTENIR"
								+"("
								+   "IDTENTATIVE          INTEGER,"
								+   "IDACTION             INTEGER,"
								+	"FOREIGN KEY(IDACTION) REFERENCES ACTION(IDACTION),"
								+	"FOREIGN KEY(IDTENTATIVE) REFERENCES TENTATIVES(IDTENTATIVE)"
								+")");
				
				statement.executeUpdate("create table if not exists TENTATIVES"
								+"("
								+   "IDTENTATIVE          INTEGER PRIMARY KEY AUTOINCREMENT,"
								+   "IDEXERCICEREALISE    INTEGER not null,"
								+	"FOREIGN KEY(IDEXERCICEREALISE) REFERENCES EXERCICEREALISEE(IDEXERCICEREALISE)"
								+")");
				
				HashMap<String,Object> sauvegardeProfesseur2 = new HashMap<String,Object>();
				HashMap<String,Object> sauvegardeExercice2 = new HashMap<String,Object>();
				HashMap<String,Object> sauvegardeEleve2 = new HashMap<String,Object>();
				HashMap<String,Object> sauvegardeClasse2 = new HashMap<String,Object>();
				HashMap<String,Object> sauvegardeExerciceRealise2 = new HashMap<String,Object>();
				HashMap<String,Object> sauvegardeTentative2 = new HashMap<String,Object>();
				
				int idClasse = 1;
				int idProf = 1;
				int idExercice = 1;
				int idEleve = 1;
				for(Entry<String, Object> entry2 : getProfesseur().entrySet()) {
	    			Professeur prof = (Professeur) entry2.getValue();
	    			statement.executeUpdate("INSERT INTO PROFESSEUR values"
	    					+ "("+idProf+""
	    					+ ",'"+prof.getIdentifiant()+"'"
							+ ",'"+prof.getMotDePasse()+"'"
							+ ",'"+prof.getNom()+"'"
							+ ",'"+prof.getPrenom()+"')");
	    			sauvegardeProfesseur2.put(Integer.toString(idProf), prof);
	    			for (Classes cl : prof.getClasses()) {
	    				statement.executeUpdate("INSERT INTO CLASSE VALUES ("+idClasse+","+idProf+",'"+cl.getNomClasse()+"')");
	    				sauvegardeClasse2.put(Integer.toString(idClasse), cl);
	    				for (Eleve el : cl.getEleves()) {
	    					statement.executeUpdate("INSERT INTO ELEVE values"
	    					+ "("+idEleve+""
							+ ","+idClasse+""
	    					+ ",'"+el.getIdentifiant()+"'"
							+ ",'"+el.getMotDePasse()+"'"
							+ ",'"+el.getNom()+"'"
							+ ",'"+el.getPrenom()+"'"
							+ ",'"+el.getNomPhoto()+"')");
	    					sauvegardeEleve2.put(Integer.toString(idEleve), el);
	    					idEleve++;
						}
	    				for(Exercice ex : cl.getExercices()){
	    					boolean exist = false;
	    					for(Entry<String, Object> entry : sauvegardeExercice2.entrySet()) {
	    						String idPrimaire = entry.getKey();
	    						Exercice exer = (Exercice) entry.getValue();
	    						if(exer.equals(ex)){
	    							exist = true;
	    							statement.executeUpdate("INSERT INTO AVOIR VALUES ("+idClasse+","+Integer.parseInt(idPrimaire)+")");
	    						}
	    					}
	    					if(!exist){
	    						statement.executeUpdate("INSERT INTO EXERCICE VALUES ("+idExercice+",'"+ex.getNomEx()+"'"
	        							+ ",'"+ex.getTypeEx()+"'"
	    								+ ",'"+ex.getNomImage()+"')");
	        					statement.executeUpdate("INSERT INTO AVOIR VALUES ("+idClasse+","+idExercice+")");
	        					sauvegardeExercice2.put(Integer.toString(idExercice), ex);
	        					idExercice++;
	    					}
	    				}
	    				idClasse++;
					}
	    			idProf ++;
	    		}
				
				int idExoR = 1;
				for(Entry<String, Object> entry : sauvegardeEleve2.entrySet()) {
					String idEl = entry.getKey();
					Eleve elev = (Eleve) entry.getValue();
					for (ExerciceRealise exoR : elev.getExerciceRealise()) {
						for(Entry<String, Object> entry2 : sauvegardeExercice2.entrySet()) {
							String idEx = entry2.getKey();
							Exercice exo = (Exercice) entry2.getValue();
							if(exo.equals(exoR.getExerciceFait())){
								statement.executeUpdate("INSERT INTO EXERCICEREALISEE values"
								+ "("+idExoR+""
								+ ","+Integer.parseInt(idEx)+""
								+ ",null"
								+ ","+Integer.parseInt(idEl)+")");
								sauvegardeExerciceRealise2.put(Integer.toString(idExoR), exoR);
								idExoR++;
							}
						}
					}
				}
				
				int idEvaluation = 1;
				for(Entry<String, Object> entry : sauvegardeExerciceRealise2.entrySet()) {
					String idExR = entry.getKey();
					ExerciceRealise exoR = (ExerciceRealise) entry.getValue();
					if(exoR.isCorrect()){
						statement.executeUpdate("INSERT INTO EVALUATION values"
						+ "("+idEvaluation+""
						+ ","+Integer.parseInt(idExR)+""
						+ ",'"+exoR.getResultat().getNote()+"'"
						+ ",'"+exoR.getResultat().getCommentaire()+"')");
						statement.executeUpdate("UPDATE EXERCICEREALISEE SET IDEVALUATION="+idEvaluation+" WHERE IDEXERCICEREALISE="+Integer.parseInt(idExR)+"");
						idEvaluation++;
					}
				}
				
				// Création des tentatives en fonction des ExerciceRealise
				int idTentative = 1;
				for(Entry<String, Object> entry : sauvegardeExerciceRealise2.entrySet()) {
					String idExR = entry.getKey();
					ExerciceRealise exoR = (ExerciceRealise) entry.getValue();
					for (Tentative tent : exoR.getListeTentatives()) {
						statement.executeUpdate("INSERT INTO TENTATIVES values"
						+ "("+idTentative+""
						+ ","+Integer.parseInt(idExR)+")");
						sauvegardeTentative2.put(Integer.toString(idTentative), tent);
						idTentative++;
					}
				}
				
				// Création des actions
				int idAction = 1;
				for(Entry<String, Object> entry : sauvegardeTentative2.entrySet()) {
					String idTent = entry.getKey();
					Tentative tent = (Tentative) entry.getValue();
					for (Action act : tent.getListeAction()) {
						statement.executeUpdate("INSERT INTO ACTION values"
						+ "("+idAction+""
						+ ",'"+act.getAction()+"')");
						
						statement.executeUpdate("INSERT INTO CONTENIR values"
						+ "("+Integer.parseInt(idTent)+""
						+ ","+idAction+")");
						idAction++;
					}
				}
			}
		}
		catch(SQLException e){  System.err.println(e.getMessage()); }       
		finally {         
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) {  // Use SQLException class instead.          
				System.err.println(e); 
			}
		}
	}
}