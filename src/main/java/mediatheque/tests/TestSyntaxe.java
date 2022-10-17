package mediatheque.tests;

import org.omg.Messaging.SyncScopeHelper;

import java.time.Year;

public class TestSyntaxe {

    public static void main(String[] args) {

        //Déclaration et valorisation d'une variable.
        int compteur;
        compteur = 20;

        System.out.println("Le compteur vaut: " + compteur );

        //Déclaration et valorisation d'une constante.
        final boolean SUCCES = true;

        //Réalisation d'un test.
        //Utilisation d'opérateurs de comparaison: >, >=, <, <=, ==, !=, !
        //Opérateurs logiques: && (ET logique) et || (OU logique)
        if ( compteur >= 100 && SUCCES==true )
        {
            System.out.println("Le compteur a une valeur importante.");
        }
        else
        {
            System.out.println("Le compteur est faible.");
        }

        //Traitement itératif.
        //1. On connait à l'avance le nombre d'itérations.
        //Exemple: afficher une table de multiplication.
        for ( int i=1  ; i<=10  ; i++ ) {

            //On ignore le traitement de la valeur 5 en passant directement à l'itération suivante.
            if ( i == 5) continue;

            System.out.println( i + " x 7 = " + i*7 );
        }

        //2. On ne connait pas à l'avance le nombre d'itérations.
        //Afficher les 4 premières années bissextiles après 1857.
        Year annee = Year.of( 1857 );
        int nbAnneesBissextilesTrouvees = 0;

        while ( nbAnneesBissextilesTrouvees < 4 )
        {
            if ( annee.isLeap() )
            {
                System.out.println( annee );
                nbAnneesBissextilesTrouvees++;


            }

            //On passe à l'année suivante.
            annee = annee.plusYears(1);
        }


        //3. On ne connait pas à l'avance le nombre d'itérations.
        //On passera au moins 1 fois dans la boucle.
        double valeur = 1234567;

        do {
            System.out.println( valeur );
            valeur = valeur / Math.PI;
        }
        while ( valeur >= 3 );


        //Traitement au cas par cas.
        //Afficher le nombre de jours d'un mois précis.
        int moisCourant = 10;

        switch ( moisCourant )
        {
            case 1:
                System.out.println("31 jours");
                break;
            case 4:
                System.out.println("30 jours");
                break;
            case 10:
                System.out.println("31 jours");
                break;
            default:
                System.out.println("Nombre de jours inconnu.");
        }


        //Tableaux
        String joursDeLaSemaine[] = {"Lundi","Mardi","Mercredi"};
        System.out.println( joursDeLaSemaine[1] );

        String[] codesPostaux = new String[ 40000 ];

        for ( int i = 0; i<40000 ; i++)
        {
            codesPostaux[ i ] = String.valueOf( i+10000 );
        }

        System.out.println( codesPostaux[ 1 ]);


        //Tableaux à double entrée (matrice)
        String[][] annuaire = new String[21][4];
        annuaire[ 1 ][ 3 ] = "2001-01-02";
        annuaire[20][0]="N21";

        System.out.println( annuaire[1][2]);






    }


}
