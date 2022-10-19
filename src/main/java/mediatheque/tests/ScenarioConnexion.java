package mediatheque.tests;

import mediatheque.metier.Retraite;

import java.sql.*;
import java.time.LocalDate;

public class ScenarioConnexion {

    public static void main(String[] args) throws Exception {

        //Charger le pilote du SGBD en mémoire vive.
        Class.forName("com.mysql.cj.jdbc.Driver");
        Class.forName("org.postgresql.Driver");

        //Obtenir une connexion à partir de l'url JDBC et des paramètres d'authentification.
        String urlJDBC = "jdbc:mysql://localhost:3306/dbmediatheque";
        String url="jdbc:mysql://localhost:5432/dbmediatheque";
        String user="root";
        String pwd = "";

        Connection cnx = DriverManager.getConnection( urlJDBC , user, pwd);

        //Création d'un Statement (objet technique utilisé pour lancer des requêtes)
       Statement st = cnx.createStatement();

        //Exécution d'une requête en lecture
        String requete = "select * from adherent;";
        ResultSet jeu = st.executeQuery( requete );

        //Traitement des données
        while ( jeu.next() )
        {
            String nom = jeu.getString("nom");
            String prenom = jeu.getString("prenom");
            Date dateNaissanceBDD = jeu.getDate("dateNaissance");

            LocalDate dateNaissance = dateNaissanceBDD.toLocalDate();

            Retraite retraite = new Retraite(nom, prenom, dateNaissance.toString());
            System.out.println( retraite );

        }

        //Fermeture de la connexion.
        cnx.close();
    }
}
