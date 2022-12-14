package mediatheque.tests;

import fixis.sauvegarde.SystemeDeSauvegarde;
import fixis.utils.ToolBox;
import mediatheque.metier.*;
import org.omg.Messaging.SyncScopeHelper;

import java.time.format.TextStyle;
import java.util.Locale;

public class ScenarioAdherent {

    public static void main(String[] args) {

        try {
            //Création d'un adhérent.
            Adherent adh1 = new Etudiant("nomadh1", "prenomAdh1", "1977-07-31", new Universite("Universite1"));

            //Lui demander l'identifiant de sa carte.
            if (adh1.getCarte() != null) {
                System.out.println(adh1.getCarte().getIdentifiant());
            }

            try {
                //On supprime la date de naissance de adh1.
               // adh1.setDateNaissance(null);

                //Lui demander le nom du jour de sa naissance.
                System.out.println(adh1.getDateNaissance()
                        .getDayOfWeek()
                        .getDisplayName(TextStyle.FULL, Locale.getDefault()));
            } catch (NullPointerException npe) {
                System.out.println("L'adhérent devrait disposer d'une date de naissance.");
            }

            //Lui demander de louer "Harry Potter"
            adh1.louer(new Ressource("Harry Potter"));

            //Création d'un actif et d'un étudiant.
            Entreprise ent1 = new Entreprise("NomEntreprise1");
            Universite campus1 = new Universite("campus1");
            Actif act1 =
                    new Actif("NomAct1", "PrénomAct1", "1983-06-20", ent1);
            Etudiant etu1 =
                    new Etudiant("nometu1", "prenomEtu1", "1999-04-20", campus1);

            //Leur demander de louer une ressource.
            etu1.louer(new Ressource("Livre1"));
            act1.louer(new Ressource("Disque1"));

            //Afficher l'identifiant de la carte de etu1.
            System.out.println(etu1.getCarte().getIdentifiant());


            System.out.println(adh1);

            //Gestion d'un tableau d'adhérents.
            Adherent[] annuaire = new Adherent[10];
            annuaire[0] = adh1;
            annuaire[1] = act1;
            annuaire[2] = etu1;

            //On demande au tableau de nous fournir l'un des éléments.
            Adherent adherentRang2 = annuaire[2];
            adherentRang2.louer(null);

            // adherentRang2 = etu1 ?
            System.out.println(adherentRang2.equals(etu1));


            if (adherentRang2.getClass().getName().equals("Etudiant")) {
                Etudiant etudiantRang2 = (Etudiant) adherentRang2;
                System.out.println(etudiantRang2.getCampus());
            }

            Object[] elements = new Object[10];
            elements[0] = adh1;
            elements[1] = act1.getEmployeur();
            elements[2] = etu1;
            elements[3] = etu1.getCarte();

            if (elements[2] instanceof Personne) {
                Personne pers1 = (Personne) elements[2];
                System.out.println(pers1.getNom() + " " + pers1.getPrenom());
            }

            //On a toujours le droit de regarder un objet comme s'il était issu
            // d'une de ses classes parentes.
            Personne obj1 = new Actif("nomact2", "prenomact2", "1982-06-30", ent1);

            Etudiant etu2 = etu1;
            Adherent adh4 = etu2;
            Object obj2 = etu1;


            //Transformer un actif en entreprise via un transformateur.
            TransformateurActifEntreprise transfo1 = new TransformateurActifEntreprise();
            Entreprise entreprise = transfo1.transformer( act1) ;
            System.out.println( entreprise.getRaisonSociale() );

            //Récupération d'un adhérent aléatoire.
            Adherent adhAleatoire = Adherent.getAdherentAleatoire();
            System.out.println( "Adhérent aléatoire: " + adhAleatoire);

            //SystemeDeSauvegarde.getInstance().sauvegarder();

            //Objectif: enregistrer 10000 adhérents.
            //On va créer un objet Runnable en utilisant une classe anonyme.
            Runnable runnable1 = new Runnable() {
                @Override
                public void run() {
                    for (int i=1; i<10000;i++)
                    {
                        try {
                            Actif act = (Actif) Adherent.getAdherentAleatoire();
                            act.save();
                        }
                        catch ( Exception exc)
                        {
                            System.out.println( exc.getMessage() );
                        }
                    }
                }
            };

            Thread thread1 = new Thread( runnable1 );
            thread1.start();

            //Création d'un adhérent spécifique pour Noël 2022: promo: quart du tarif.
            Adherent adhNoel2022 = new Adherent("abcd","def","1999-04-20") {
                @Override
                public Location louer(Ressource res) {
                    System.out.println("Quart du tarif pour "+ this);
                    return null;
                }
            };

            adhNoel2022.louer( null );

            System.out.println("Programme terminé ");
        }
        catch ( Exception exc)
        {
            System.out.println(exc.getMessage());
        }
    }
}
