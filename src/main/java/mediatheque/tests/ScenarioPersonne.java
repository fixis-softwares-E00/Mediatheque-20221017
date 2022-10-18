package mediatheque.tests;

import mediatheque.metier.Personne;

import java.time.LocalDate;

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
    }
}
