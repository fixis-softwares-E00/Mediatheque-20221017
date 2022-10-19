package mediatheque.metier;

public class Actif extends Adherent {

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
    }

    @Override
    public Location louer(Ressource res) {
        System.out.println("Location plein tarif de " + res + " par " + this);
        return null;
    }
}
