package mediatheque.metier;

import java.time.LocalDate;

public class Personne {

    //Propriétés
    private String nom;


    private String prenom;
    private LocalDate dateNaissance;

    //Méthodes
    public Personne(String nom, String prenom)
    {
        setNom(nom);
        setPrenom(prenom);
    }

    public Personne(String nom, String prenom, String dateNaissance)
    {
        setNom(nom);
        setPrenom(prenom);
        setDateNaissance( LocalDate.parse(dateNaissance) );
    }


    public boolean marcher()
    {
        System.out.println(getPrenom() + " " + getNom() + " marche.");
        return true;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNom() {
        return nom.toUpperCase();
    }

    public void setNom(String propositionNom) {

        //On accepte uniquement les propositions de noms qui contiennent au moins 3 caractères.
        if ( propositionNom.length() >= 3) {
            nom = propositionNom;
        }
        else {
            System.out.println("La proposition " + propositionNom + " est invalide.");
        }
    }

}
