package mediatheque.tests;

import mediatheque.metier.Adherent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

public class ScenarioStreams {

    public static void main(String[] args) throws Exception {

        //Récupération des adhérents de la base de données.
        ArrayList<Adherent> annuaire = Adherent.load();
        System.out.println( annuaire.size() + " adhérents dans la base.");


        //Afficher le nombre total d'adhérents en utilisant un stream.
        long nbTotal = annuaire.stream().count();
        System.out.println( nbTotal );

        //Afficher le nombre d'adhérents nés en 1985.
        //On a besoin d'un prédicat qui affirme qu'un adhérent est né en 1985.
        Predicate<Adherent> predicate1 = unAdherent -> unAdherent.getDateNaissance().getYear()==1985;

        long nbNes1985 = annuaire.stream().filter( predicate1 ).count();
        System.out.println( nbNes1985 + " adhérents sont nés en 1985");

        //Afficher l'adhérent le plus âgé.
        Comparator<Adherent> comparator1 = new Comparator<Adherent>() {
            @Override
            public int compare(Adherent adh1, Adherent adh2) {
                if ( adh1.getDateNaissance().isBefore( adh2.getDateNaissance())) return 1;
                if ( adh2.getDateNaissance().isBefore( adh1.getDateNaissance())) return -1;
                return 0;
            }
        };

        Optional<Adherent> optional1 = annuaire.stream().max( comparator1 );
        System.out.println("L'adhérent le plus âgé est " + optional1.get());

        //Afficher tous les adhérents nés en 1985 en les ordonnant par date de naissance.
        System.out.println("Classement...");
        annuaire.stream().filter( predicate1 ).sorted( comparator1.reversed() ).forEach( adh -> System.out.println( adh ) );

        //Afficher les 15 premiers adhérents nés en 1985 en les ordonnant par date de naissance.
        System.out.println("Voici les 15 premiers adhérents nés en 1985...");
        annuaire.stream()
                .filter( predicate1 )
                .sorted( comparator1.reversed() )
                .limit(15)
                .forEach( adh -> System.out.println( adh ) );


        //Trouver un adhérent né le 08/05/1945, s'il existe.
        System.out.println("Voici un adhérent né le 08/05/1945, s'il existe...");
        Optional<Adherent> optional1945 =  annuaire.stream()
                .filter( adh -> adh.getDateNaissance().isEqual(LocalDate.parse("1945-05-08")) )
                .findFirst();

        if (optional1945.isPresent())
        {
            System.out.println( optional1945.get() );
        }
        else
        {
            System.out.println("Aucun adhérent ne répond à cette contrainte.");
        }
    }
}
