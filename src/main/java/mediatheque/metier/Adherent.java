package mediatheque.metier;

import java.time.LocalDate;

public abstract class Adherent extends Personne{

    private LocalDate dateAdhesion;

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

}
