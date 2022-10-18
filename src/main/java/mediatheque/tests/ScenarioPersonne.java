package mediatheque.tests;

import mediatheque.metier.Carte;
import mediatheque.metier.Personne;
import mediatheque.metier.Ressource;

import java.time.LocalDate;
import java.time.format.TextStyle;

public class ScenarioPersonne {

    public static void main(String[] args) {
        //Déclaration et instanciation d'une personne.
        Personne p1 = new Personne("durand","paul");

        p1.marcher();

        //Attribution d'une identité à la personne.
        p1.setNom("dupond");
        p1.setPrenom("marie");
        p1.setDateNaissance(LocalDate.parse("1985-12-25"));

        p1.marcher();


        //Création d'une autre personne.
        Personne p2 = new Personne("martin", "jacques", "1980-06-18");
        System.out.println("L'année de naissance de p2 est "+ p2.getDateNaissance().getYear());

        //Création d'une ressource.
        Ressource res1 = new Ressource("Tintin au Tibet");
        System.out.println( res1.getTitre() );

        //Calcul du nombre d'années entre 2 dates.
        LocalDate dateArmistice1918 = LocalDate.parse("1918-11-11");
        LocalDate dateDuJour = LocalDate.now();
        System.out.println( Personne.getNbAnnees(dateArmistice1918, dateDuJour) );

        //On demande l'âge de p1 et p2.
        System.out.println( p1.getAge() + " ans");
        System.out.println( p2.getAge() + " ans");

        //Création d'une carte.
        Carte carte1 = new Carte( p1 );

        //On met la carte dans la poche de p1.
        //p1.setCarte( carte1 );

        //Afficher le mois de naissance du propriétaire de la carte.
        System.out.println( carte1.getProprietaire().getDateNaissance().getMonth() );

        //Affichage de l'identifiant de la carte.
        System.out.println( carte1.getIdentifiant() );

        //Création de 100 cartes.
        for (int i=1;i<=100;i++)
        {
            Carte c = new Carte( p1 );
            System.out.println( c.getIdentifiant() );
        }
    }
}
