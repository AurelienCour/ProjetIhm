package edu.ihm.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Database
{
	
	private HashMap sauvegarde;

	public Database(){
		createDatabase();
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
			connection = DriverManager.getConnection("jdbc:sqlite:bddIHM.db");

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
									+   "MODELE               longblob not null"
									+")");


			statement.executeUpdate("create table if not exists CLASSE"
									+"("
									+   "IDCLASSE             INTEGER PRIMARY KEY AUTOINCREMENT,"
									+   "IDPROFESSEUR         INTEGER not null,"
									+	"FOREIGN KEY(IDPROFESSEUR) REFERENCES PROFESSEUR(IDPROFESSEUR)"
									+")");

			statement.executeUpdate("create table if not exists AVOIR"
									+"("
									+   "IDCLASSE             INTEGER PRIMARY KEY,"
									+   "IDEXERCICE           INTEGER PRIMARY KEY,"
									+	"FOREIGN KEY(IDCLASSE) REFERENCES CLASSE(IDCLASSE),"
									+	"FOREIGN KEY(IDEXERCICE) REFERENCES EXERCICE(IDEXERCICE)"
									+")");

			statement.executeUpdate("create table if not exists ENFANT"
									+"("
									+   "IDENFANT             INTEGER PRIMARY KEY AUTOINCREMENT,"
									+   "IDCLASSE             INTEGER not null,"
									+   "IDENTIFIANT          char(25) not null,"
									+   "MOTDEPASSE           char(25) not null,"
									+   "NOM                  char(50) not null,"
									+   "PRENOM               char(50) not null,"
									+   "PHOTO                longblob,"
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
									+   "IDENFANT             INTEGER not null,"
									+	"FOREIGN KEY(IDEXERCICE) REFERENCES EXERCICE(IDEXERCICE),"
									+	"FOREIGN KEY(IDEVALUATION) REFERENCES EVALUATION(IDEVALUATION)"
									+	"FOREIGN KEY(IDENFANT) REFERENCES ENFANT(IDENFANT)"
									+")");
			
			statement.executeUpdate("create table if not exists CONTENIR"
									+"("
									+   "IDTENTATIVE          INTEGER PRIMARY KEY,"
									+   "IDACTION             INTEGER PRIMARY KEY,"
									+	"FOREIGN KEY(IDACTION) REFERENCES ACTION(IDACTION)"
									+")");

			statement.executeUpdate("create table if not exists EVALUATION"
									+"("
									+   "IDEVALUATION         INTEGER PRIMARY KEY AUTOINCREMENT,"
									+   "IDEXERCICEREALISE    INTEGER not null,"
									+   "NOTE                 char(20) not null,"
									+   "COMMENTAIRE          text not null,"
									+	"FOREIGN KEY(IDEXERCICEREALISE) REFERENCES EXERCICEREALISEE(IDEXERCICEREALISE)"
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



	public static void main(String[] args) throws ClassNotFoundException
	{
		
		Database db = new Database();
		/*// load the sqlite-JDBC driver using the current class loader
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		try
		{
			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:bddIHM.db");

			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.


			statement.executeUpdate("DROP TABLE IF EXISTS person");
			statement.executeUpdate("CREATE TABLE person (id INTEGER, name STRING)");

			int ids [] = {1,2,3,4,5};
			String names [] = {"Peter","Pallar","William","Paul","James Bond"};

			for(int i=0;i<ids.length;i++){
				statement.executeUpdate("INSERT INTO person values(' "+ids[i]+"', '"+names[i]+"')");   
			}

			ResultSet resultSet = statement.executeQuery("SELECT * from person");
			while(resultSet.next())
			{
				// iterate & read the result set
				System.out.println("name = " + resultSet.getString("name"));
				System.out.println("id = " + resultSet.getInt("id"));
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
		}*/
	}
}