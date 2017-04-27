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
		//linkDb = Database.class.getResource("/");
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
			
			/*// 4 prof
			statement.executeUpdate("INSERT INTO PROFESSEUR(IDENTIFIANT,MOTDEPASSE,NOM,PRENOM) values('prof1','prof1','Girard','Patrick')");
			statement.executeUpdate("INSERT INTO PROFESSEUR(IDENTIFIANT,MOTDEPASSE,NOM,PRENOM) values('prof2','prof2','Genniet','Annie')");
			statement.executeUpdate("INSERT INTO PROFESSEUR(IDENTIFIANT,MOTDEPASSE,NOM,PRENOM) values('prof3','prof3','Courtillat','Pascal')");
			statement.executeUpdate("INSERT INTO PROFESSEUR(IDENTIFIANT,MOTDEPASSE,NOM,PRENOM) values('prof4','prof4','Jacson','Lucien')");

			//40 Exercices
			statement.executeUpdate("INSERT INTO EXERCICE (NOMEXERCICE,TYPEEXERCICE,MODELE) VALUES ('Nolan','Lorem Consulting','Quis Lectus Corp.'),('David','Donec Felis Industries','At Limited'),('Salvador','Arcu Vestibulum Ltd','Tellus Justo Sit LLP'),('Prescott','Eu Associates','Arcu LLP'),('Xavier','Vivamus Limited','Nec Leo Morbi LLP'),('Oscar','Ut Mi Duis Institute','Vulputate Associates'),('Aquila','In Institute','Nunc Mauris Consulting'),('Leroy','Venenatis Associates','Commodo Tincidunt Nibh LLC'),('Jarrod','Mauris Ltd','Amet Massa Associates'),('Malik','Rapide','Magnis Dis Parturient Associates'),('Nolan','Eu Consulting','Velit Ltd'),('Troy','Pede Et Inc.','Vulputate Associates'),('Ali','Montes Nascetur Ltd','In Lobortis Tellus Corporation'),('Jacob','Facilisis Vitae Associates','Est Ac Facilisis Limited'),('Holmes','Couleur','Sollicitudin A Corp.'),('Bert','Mauris Erat Institute','Pulvinar Arcu Institute'),('Thomas','Donec Nibh Industries','Ante Ipsum Associates'),('Axel','Vel Associates','Adipiscing Elit Curabitur LLC'),('Wesley','Ut Molestie Associates','Viverra Incorporated'),('Denton','Diam Proin Dolor LLC','Nulla Facilisi Sed PC')");
			statement.executeUpdate("INSERT INTO EXERCICE (NOMEXERCICE,TYPEEXERCICE,MODELE) VALUES ('Clark','Aenean Industries','Lacus LLC'),('Donovan','Couleur','Luctus Curabitur LLC'),('Quamar','Phasellus Fermentum Convallis Associates','Montes Nascetur Consulting'),('Grant','Enim Industries','Mollis Nec Consulting'),('Baker','Auctor LLP','Maecenas Corporation'),('Wesley','Dolor Vitae Dolor LLC','Risus Limited'),('Hakeem','Pharetra Nibh Inc.','Enim Curabitur Institute'),('Scott','Duis At Lacus Inc.','Neque Sed Sem Limited'),('Hedley','Justo PC','Mollis Integer Tincidunt Incorporated'),('Malik','Rapide','Ornare Tortor At Incorporated'),('Ross','Ornare Tortor Limited','Porttitor Scelerisque Neque Corp.'),('Logan','Luctus Consulting','Nunc LLP'),('Asher','Non Massa Non Associates','Magna Phasellus Industries'),('Chase','Penatibus Et Magnis Industries','Fermentum Foundation'),('Graiden','Amet Incorporated','Etiam LLP'),('Graiden','Aliquam Incorporated','Erat Consulting'),('Cedric','Ultrices Iaculis Ltd','Cras PC'),('Laith','Pellentesque A LLP','At Velit Incorporated'),('Baxter','Magna Ltd','Donec Elementum Consulting'),('Barrett','Mauris Erat LLP','Tincidunt Pede Ac Corporation')");



			// 100 Eleves
			statement.executeUpdate("INSERT INTO ELEVE (IDCLASSE,IDENTIFIANT,MOTDEPASSE,NOM,PRENOM,PHOTO) VALUES (14,'ACV08YKQ1HH','HSX57DEV1NS','Grimes','Yoshio','GIW83'),(10,'RVU64MRZ6JX','TAJ84JNK1KW','Dodson','Ashely','VTM46'),(20,'TJY13ZWL3DC','UCB72LNH9KS','Powers','Taylor','NZX00'),(20,'EAO14TNU3IH','NPH84ZDJ5CP','Peterson','Raja','WGG30'),(17,'ATG27UCU8JI','OUN21XRH8LU','Reynolds','Ina','WER33'),(10,'BID26QGD5VL','CBB89FGJ0DN','Knowles','Gavin','WCT44'),(13,'RXI43NVD6RU','GBN01HSH7LD','Barton','Mohammad','GLW76'),(13,'DNJ21VUM0NO','LYZ49USP0BX','Frost','Justine','RFJ71'),(18,'UFN46NRP9RR','XNQ88QVZ1PX','Hodge','Akeem','XDD13'),(4,'BMP65GHC6FV','UWD00RAH0QL','Byrd','Ali','IGU33'),(6,'KJR35JVS3SB','ZOY04YXE6QE','Carney','Francesca','OWK40'),(7,'PEY35VLD1FF','IRM45RUT1QP','Conrad','Harriet','NPD81'),(13,'SVT96AXO6HA','ZTA13SMF2LB','Blevins','Tatiana','DBQ16'),(11,'FSO32OBE4EA','CQU07YAI5QT','Leach','Azalia','RIY22'),(18,'LGA77KVA0ZN','NDL91EFU4HJ','Byrd','Jenette','BFP60'),(14,'QDA34IOQ6NT','SJK48AOR1AB','Cline','Kieran','JXU70'),(16,'FNM14VQB2UW','VBF92VKL3PZ','Robinson','Preston','RTZ72'),(20,'WVV07JDJ5YR','PGS68QDX0EB','Walton','Rajah','DYN07'),(16,'AWT16LCY3OQ','LFY22ICZ2TV','Huffman','Nigel','BPF40'),(10,'ZGI60EFE9OY','QHJ06CEM4YF','Walton','Serena','TXO89')");
			statement.executeUpdate("INSERT INTO ELEVE (IDCLASSE,IDENTIFIANT,MOTDEPASSE,NOM,PRENOM,PHOTO) VALUES (10,'HDQ07DGP8LV','JJZ23BXE9OD','Kim','Wing','CGQ92'),(3,'HMZ75PGS0BL','KKV05OYI4VP','Roberson','Driscoll','MOH24'),(3,'YEM82MEM9BZ','TCU88YCH0JS','Singleton','Quinn','XJR03'),(14,'EPE59FKM0YB','JGZ43PKN6XP','English','Lane','DKF26'),(8,'DHT22ELA0JO','VWS44FWL7PU','Skinner','Grace','RQD34'),(5,'GTJ17UWC0YC','ACI91WRX1EI','Lott','Sonia','BOW43'),(12,'CMN72OCI2EP','IOZ38EKJ6FI','Grimes','Evangeline','OHW81'),(6,'DEN21JFZ0WQ','RUQ29ELM1OJ','Glenn','Cruz','CZT69'),(8,'BFO80QZP1NT','DDR72PBY3RX','Foster','Amery','OFH35'),(3,'ICA31WKZ0AI','IGL52MCJ4YY','Alford','Driscoll','EWR28'),(12,'DYY32TZR0CL','EUR85RDR1TG','Barron','Rebecca','TNK05'),(11,'ISR02LMG8BT','XNZ96HRS9EP','Gray','Aristotle','CJQ76'),(12,'EZY07PAP6ND','WGT89ENW6SY','Drake','Noble','LHN98'),(17,'SFI02XIR2YG','SQB57GZS0BR','Bishop','Maite','NCL29'),(12,'BBK30XHV8SR','YDR99ZPH0GZ','Ferrell','Uriel','KJG72'),(2,'UCO60PSV0EL','QCC64UHF3IK','Mooney','Karen','JND69'),(17,'PTW47CBD5KB','TVL06XKQ3YU','Little','Ethan','FCJ78'),(19,'RCV84JAW9ZS','JVS11QXZ6CY','Schneider','Lavinia','SXR55'),(3,'VXY32IWA2CC','PCB94FCQ6WI','Williamson','Shea','QUV32'),(6,'JSM71DSA6UG','LVL74YBX5BP','Blevins','Odessa','XYJ15')");
			statement.executeUpdate("INSERT INTO ELEVE (IDCLASSE,IDENTIFIANT,MOTDEPASSE,NOM,PRENOM,PHOTO) VALUES (14,'PLX48TVS2PV','NWH31PWH5YQ','Kramer','Declan','JKA44'),(16,'TJT10YRB3LD','DYO82WQA0AM','Jackson','Yvette','KWU71'),(6,'BWB62SYB9TU','AVE35KJK0YV','Gay','Rafael','UWK09'),(19,'HXE59IKV9HA','UTM51KMN8VZ','Wade','Lisandra','HOY56'),(10,'EDI71HKY6TJ','MFH88VJE3AP','Townsend','Jordan','RWP91'),(11,'VZU28KLZ4GB','RYK64UDY2VT','Hinton','Holmes','AXC60'),(12,'XZY24JEB6KM','XZN42TOL1JU','Rowland','Quail','QML72'),(8,'WKS05YAH4CV','KZF76YKN3DF','Howe','Lane','GJT97'),(6,'VOR06IAE5LA','UXJ16FBC4QU','Stone','Ila','AEM98'),(17,'OLP82RBO8ED','LGW33JFB7FI','Acevedo','Kadeem','HMN51'),(2,'JIP44OVW9NA','IMW35ZHU0NI','Moody','Yardley','GCN89'),(4,'WFT85ZBI9CJ','QJX01XWG6PS','Velasquez','Winifred','OMU28'),(8,'IIC50UBM4ZU','YOP04HXW8AA','Olson','Charity','KYZ42'),(5,'MML75RHD0KH','HIE29JRQ2RY','Rivas','Hedy','GFG90'),(12,'WXD15AUZ6MC','MRG51PRV9MQ','Wilson','Lynn','EDC64'),(16,'KNK45ZFG1VQ','GRU25DDI6CN','Cox','Allen','LCE00'),(16,'JKQ06XSG3EP','YQX11YWK4VU','Benson','Jennifer','OXY86'),(8,'FKQ84WMC5PU','WWH83AHO2TD','Singleton','Kirby','ALH49'),(19,'AIO85EPW4XA','WRQ62NUZ1AP','Hardin','Alan','ANA13'),(16,'HGC88URB7NA','LLV76XQR3JF','James','Axel','XVY00')");
			statement.executeUpdate("INSERT INTO ELEVE (IDCLASSE,IDENTIFIANT,MOTDEPASSE,NOM,PRENOM,PHOTO) VALUES (3,'VJV36YZZ1EL','XXG42RWW8MY','Vaughan','Carson','EKB58'),(20,'BLT78LVF6XU','YZD09MOD0SC','Leon','Amal','JCT12'),(7,'ZRN66EUH6LN','ZPC32NHX9RI','Mccarthy','Troy','IJS54'),(16,'LOK61LUB1LP','VKU78MGK0CY','Gray','Melyssa','SPE82'),(20,'PQI33WEJ3IH','JHH86MCC9RS','Mccray','Teagan','KPD10'),(15,'TKB18IGM0SZ','BHU98DHH0CA','Sanford','Kuame','DJB58'),(17,'BOW00YCG6QM','JYD86LPK6NX','Mullins','Vivian','CBX51'),(14,'DRJ70SAG5CZ','EVZ62MRK9BX','Alston','Guinevere','LQQ34'),(18,'XCK80OKT6AT','FRA23CCB7QL','Fields','Nell','SJP51'),(17,'DIH69XTW7TH','NWG05FTK7XQ','Blake','Wade','HMK13'),(15,'FHT06HPX8HQ','RJM50FMY9RX','Christensen','Hadassah','OZS93'),(13,'ZFV31TJL5YE','HUS37SSH1AK','Guerrero','Joel','RIF02'),(3,'YDL38FGX1OB','NBT33FFW2FR','Berger','Callie','FDM83'),(17,'LIA65PPE3OO','UHS43JCE1TV','Dawson','Heather','RCM67'),(2,'HUU96PJG2JW','WUR18WHL4CO','Jenkins','Jael','SRS37'),(15,'KFB66ELS7RA','RFQ57BTU6YT','Lloyd','Cherokee','WNG23'),(7,'EMW01VGU0LD','SQO09ZVS7XL','English','Todd','CTM48'),(7,'KEU74IRV6WU','KWA70UBJ9ZH','Hurley','Alexandra','GKF76'),(10,'FOQ38IBM8LR','BSX12SYB8UY','Bryan','Harriet','MFZ57'),(20,'WEI01VEA3GH','JCY64QOG9CB','Sandoval','Samuel','YNH02')");
			statement.executeUpdate("INSERT INTO ELEVE (IDCLASSE,IDENTIFIANT,MOTDEPASSE,NOM,PRENOM,PHOTO) VALUES (4,'OSD68ARY7JH','JTG56AVI5AB','Young','Chava','UVD85'),(2,'IKO91JPN4JH','HYD81VUL4QL','Townsend','Tad','POA33'),(13,'IPW83ANQ3GM','MFK34WZG2XR','Wagner','Jolene','EOQ13'),(2,'ZAV68GXJ4TF','WSY08MRX6UD','Arnold','Morgan','JFA55'),(20,'KVU38JRT5UA','EGJ24HHT4RS','Hood','Nigel','TQP72'),(13,'ICW88VIK3BY','ONT63IUH0ON','Cotton','Imogene','VUZ86'),(14,'UIS61MTM6OP','RRR41XJV0SC','Wallace','Jade','WTR72'),(6,'CGZ17OYE6IU','YZF21RUU4TT','Buckley','Colin','BVA43'),(6,'DUA11DON9II','RTH41CPG8AR','Stokes','Wing','JKB12'),(13,'AEH57KRF7TN','IJQ57URA3CO','Raymond','Rhoda','NYL26'),(18,'EIJ59LPQ6PD','IGW99POO1JW','Malone','Abbot','PZD01'),(15,'LBO01AKE1HW','SRG07ANH2PM','Sweeney','Kristen','XAV81'),(15,'WRH35JKC1HU','ZUQ33MPB8HB','Pickett','Adara','FFK60'),(6,'JII86ZPQ9DQ','WCD51YNK0BM','Romero','Rylee','UFB30'),(2,'QFE19ZMX1KE','LPV66AWG8SF','Snyder','Rahim','KKC92'),(12,'QKV47WXJ1YX','DAP22IRS9OQ','Sparks','Keefe','AAL01'),(6,'QYM92AZO4XD','PUR63DDN6TR','Gamble','Hayes','EAA31'),(19,'KCF36FPQ4BK','GCM79DXW0TK','Rutledge','Janna','GFD33'),(13,'OTJ02BGW7DF','ZUB56DUY4MK','Lindsay','Blossom','UCN53'),(7,'GYM40TBS7DP','YNN35WCU3HJ','Pope','Dillon','CCQ32')");

			// 20 classes
			statement.executeUpdate("INSERT INTO CLASSE (IDPROFESSEUR,NOMCLASSE) VALUES (3,'Tellus Suspendisse Sed Incorporated'),(1,'Nulla Foundation'),(2,'Sed Eu Nibh PC'),(2,'Euismod Et Commodo Consulting'),(2,'Metus Aliquam Erat Inc.'),(1,'Ultrices A Company'),(2,'Euismod Institute'),(3,'Lobortis Ultrices Institute'),(4,'Ac Incorporated'),(1,'Risus Donec LLP'),(4,'Rutrum Magna Corporation'),(2,'Felis Orci Adipiscing Corporation'),(1,'Magna Nam PC'),(3,'Vel Company'),(4,'Ut Pharetra Sed LLP'),(4,'Et Rutrum Company'),(3,'Sit Limited'),(2,'Nec Ltd'),(4,'Sit Incorporated'),(3,'Ultrices Industries')");

			// 60 relation classe exo
			statement.executeUpdate("INSERT INTO AVOIR (IDCLASSE,IDEXERCICE) VALUES (6,12),(8,30),(5,7),(8,28),(6,15),(9,33),(9,20),(11,17),(5,5),(18,22),(20,9),(8,40),(6,22),(11,29),(8,34),(7,2),(4,29),(2,33),(18,30),(11,33)");
			statement.executeUpdate("INSERT INTO AVOIR (IDCLASSE,IDEXERCICE) VALUES (6,20),(14,15),(12,20),(14,21),(10,34),(18,34),(11,32),(19,33),(6,10),(7,28),(5,30),(15,12),(17,2),(5,31),(18,19),(5,36),(3,22),(9,22),(9,24),(16,20)");
			statement.executeUpdate("INSERT INTO AVOIR (IDCLASSE,IDEXERCICE) VALUES (2,29),(9,21),(9,14),(3,4),(6,24),(14,32),(1,4),(5,29),(1,17),(7,24),(20,35),(20,10),(6,40),(16,3),(1,21),(6,23),(16,19),(3,8),(17,24),(9,16)");
			*/

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
			for(Entry<String, Object> entry : sauvegardeExerciceRealise.entrySet()) {
				String idPrimaire = entry.getKey();
				ExerciceRealise exoR = (ExerciceRealise) entry.getValue();
				if(idPrimaire != null){ // Si on a un résultat
					resultSet = statement.executeQuery("SELECT IDTENTATIVE from TENTATIVES where IDEXERCICEREALISE="
													+Integer.parseInt(idPrimaire)); // On recupère l'id des exercices liés
					while(resultSet.next())  // Tant que l'on a des résultats
					{
						for(Entry<String, Object> entry2 : sauvegardeTentative.entrySet()) {
							if(entry2.getKey().equals(Integer.toString(resultSet.getInt("IDTENTATIVE")))){
								Tentative tent = (Tentative) entry2.getValue();
								exoR.addTentative(tent);
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
							String idEx = entry.getKey();
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