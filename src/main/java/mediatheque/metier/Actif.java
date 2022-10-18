package mediatheque.metier;

public class Actif extends Adherent {

    private Entreprise employeur;

    public Entreprise getEmployeur() {
        return employeur;
    }

    public void setEmployeur(Entreprise employeur) {
        this.employeur = employeur;
    }

    public Actif(String nom, String prenom, String dateNaissance, Entreprise emp) {
        super(nom, prenom, dateNaissance);

        setEmployeur(emp);
    }
}
