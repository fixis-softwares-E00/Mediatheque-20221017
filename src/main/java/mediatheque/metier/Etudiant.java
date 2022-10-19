package mediatheque.metier;

public class Etudiant extends Adherent {

    private Universite campus;

    public Universite getCampus() {
        return campus;
    }

    public void setCampus(Universite campus) {
        this.campus = campus;
    }

    @Override
    public Location louer(Ressource res) {
        System.out.println("Location gratuite de " + res + " par " + this);
        return null;
    }

    public Etudiant(String nom, String prenom, String dateNaissance, Universite camp) throws Exception {
        super(nom, prenom, dateNaissance);

        setCampus( camp );
    }

    public String toString()
    {
        return super.toString() +" (" +getAge()+" ans) "+getCampus();
    }
}
