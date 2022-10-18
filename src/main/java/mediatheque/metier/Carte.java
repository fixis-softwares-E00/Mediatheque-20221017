package mediatheque.metier;

public class Carte {

    private Personne proprietaire;
    private String identifiant;

    private static int compteur;

    public Carte( Personne p )
    {
        setProprietaire( p );

        //La carte en cours de création est mise immédiatement dans la poche de son propriétaire.
        getProprietaire().setCarte( this );

        //Autogénération de l'identifiant de la carte.
        compteur++;
        setIdentifiant("CART" + compteur);
    }

    public Personne getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    private void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
}
