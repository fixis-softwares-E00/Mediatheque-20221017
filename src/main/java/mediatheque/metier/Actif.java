package mediatheque.metier;

import fixis.sauvegarde.Recordable;
import fixis.sauvegarde.SystemeDeSauvegarde;

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
        return true;
    }
}
