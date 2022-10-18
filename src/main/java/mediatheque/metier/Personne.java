package mediatheque.metier;

import java.time.LocalDate;
import java.time.Period;

public class Personne {

    //Propriétés
    private String nom;


    private String prenom;
    private LocalDate dateNaissance;

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    private Carte carte;

    //Méthodes
    public Personne(String nom, String prenom)
    {
        setNom(nom);
        setPrenom(prenom);
        //Création d'une carte et placement de celle-ci dans la poche de la personne
        Carte c1 = new Carte( this );
        setCarte( c1 );
    }

    public Personne(String nom, String prenom, String dateNaissance)
    {
        this(nom,prenom);
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

    @Override
    public String toString() {
        //Le comportement de toString() dans Object ne convient pas pour les personnes.
        //On souhaite récupérer le nom et le prénom.
        return getPrenom()+" "+getNom();
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

    public static int getNbAnnees(LocalDate date1, LocalDate date2)
    {
        Period periode = Period.between( date1, date2 );
        return periode.getYears();
    }

    public int getAge()
    {
        //return Period.between( getDateNaissance(), LocalDate.now() ).getYears();
        return getNbAnnees( getDateNaissance(), LocalDate.now() );
    }
}
