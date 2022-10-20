package mediatheque.metier;

import fixis.utils.ToolBox;

import java.time.LocalDate;

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

}
