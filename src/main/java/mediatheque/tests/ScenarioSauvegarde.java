package mediatheque.tests;

import fixis.sauvegarde.SystemeDeSauvegarde;
import mediatheque.metier.Actif;
import mediatheque.metier.Entreprise;
import mediatheque.metier.Livre;

import java.time.LocalDate;

public class ScenarioSauvegarde {

    public static void main(String[] args) throws Exception {

        //Créer 5 actifs
        LocalDate dateDepart = LocalDate.parse("1983-06-20");
        for (int i=1;i<=5;i++)
        {
            dateDepart = dateDepart.plusMonths(1);
            String dateNaissance = dateDepart.toString();
            Actif actif = new Actif(
                    "NomAct" +i,
                    "PrenomAct"+i,
                    dateNaissance,
                    new Entreprise("ENT1"));


        }

        //Créer 5 livres
        for (int i=1;i<=5;i++)
        {
            Livre livre = new Livre("TitreLivre"+i);


        }


        //Lancer la sauvegarde.
        //SystemeDeSauvegarde sys = SystemeDeSauvegarde.getInstance();
        SystemeDeSauvegarde.getInstance().sauvegarder();
    }
}
