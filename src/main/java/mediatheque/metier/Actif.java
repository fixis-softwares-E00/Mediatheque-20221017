package mediatheque.metier;

import fixis.sauvegarde.Recordable;
import fixis.sauvegarde.SystemeDeSauvegarde;

import java.sql.*;
import java.time.LocalDate;

public class Actif extends Adherent implements Recordable {

    private Entreprise employeur;

    public Entreprise getEmployeur() {
        return employeur;
    }

    public void setEmployeur(Entreprise employeur) {
        this.employeur = employeur;
    }

    public Actif(String nom, String prenom, String dateNaissance, Entreprise emp) throws Exception {
        super(nom, prenom, dateNaissance);

        setEmployeur(emp);

        //Autoabonnement
        SystemeDeSauvegarde.getInstance().addRecordable( this );
    }

    @Override
    public Location louer(Ressource res) {
        System.out.println("Location plein tarif de " + res + " par " + this);
        return null;
    }

    @Override
    public boolean save() throws Exception {
        System.out.println("Sauvegarde de l'actif " + this + " dans la base de données.");

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
        String requete = "insert into adherent (nom, prenom, dateNaissance,type) " +
                "values" +
                " ('"+getNom()+"','"+getPrenom()+"','"+getDateNaissance().toString()+"',1);";

        st.execute( requete );


        //Fermeture de la connexion.
        cnx.close();

        return true;
    }
}
