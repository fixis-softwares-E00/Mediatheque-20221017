package mediatheque.metier;

public class Retraite extends Adherent {
    public Retraite(String nom, String prenom, String dateNaissance) throws Exception {
        super(nom, prenom, dateNaissance);
    }

    @Override
    public Location louer(Ressource res) {
        System.out.println("Location demi-tarif de "+ res + " par "+this);
        return null;
    }
}
