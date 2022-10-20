package mediatheque.metier;

import fixis.utils.ToolBox;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Adherent extends Personne{

    private LocalDate dateAdhesion;


    public static Adherent getAdherentAleatoire() throws Exception
    {
        LocalDate dateAleatoire = ToolBox.getRandomLocaleDate(1937,2021);
        String suffixe = dateAleatoire.toString().replace("-","");

        Adherent adh = new Actif("ACT"+suffixe,
                "Prenom"+suffixe,
                dateAleatoire.toString(),
                new Entreprise("ent1"));

        return adh;
    }

    public LocalDate getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(LocalDate dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    public Adherent(String nom, String prenom, String dateNaissance) throws Exception {
        //Appel du constructeur parent.
        //On lui passe les informations reçues: il sait comment les traiter.
        super(nom, prenom, dateNaissance);


    }


    public abstract Location louer( Ressource res );


    public static ArrayList<Adherent> load() throws Exception
    {
        ArrayList<Adherent> annuaire = new ArrayList<>();


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

            //On place le retraité dans la liste.
            annuaire.add( retraite );

        }

        //Fermeture de la connexion.
        cnx.close();

        return annuaire;
    }







}
