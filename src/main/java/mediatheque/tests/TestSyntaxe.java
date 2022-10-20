package mediatheque.tests;

import fixis.utils.ToolBox;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

public class TestSyntaxe {

    /**
     * Méthode destinée à faire une salutation simple.
     * Elle affiche également l'heure courante.
     */
    public static void saluer()
    {
        System.out.println("Bonjour Monsieur");
        System.out.println("Il est actuellement " + LocalTime.now() );
    }

    public static double calculerPerimetreCercle( double rayon)
    {
        return 2 * Math.PI * rayon;
    }

    //Créer une autre méthode "saluer" qui prend en compte un nom de personne et un genre (1=Monsieur, 2=Madame).
    //Exemple d'affichage: Bonjour Monsieur DUPOND

    /**
     * Cette méthode affiche une salutation personnalisée.
     *
     * @param nom
     * C'est le nom de famille de la personne qui est saluée.
     *
     * @param genre
     * Valeur égale à 1 ou 2.
     */
    public static void saluer( String nom, int genre)
    {
        switch ( genre )
        {
            case 1:
                System.out.println("Bonjour Monsieur "+nom);
                break;
            case 2:
                System.out.println("Bonjour Madame "+nom);
                break;
            default:
                System.out.println("Bonjour "+nom);

        }
    }



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
        String[] joursDeLaSemaine = {"Lundi","Mardi","Mercredi"};
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


        //Affichage de tous les jours de la semaine.
        for (  String unJour  : joursDeLaSemaine )
        {
            System.out.println( unJour );
        }

        //Invocation de la méthode "saluer".
        saluer();

        //Invocation de la méthode "calculerPerimetreCercle"
        double perimetre = calculerPerimetreCercle(12);
        System.out.println( "Périmètre du cercle: " + perimetre );

        saluer("DUPOND",1);

        //Tirer une valeur comprise entre 64 et 227.
        int tirage = ToolBox.getRandomValue(1,1);
        System.out.println( "Valeur aléatoire: " + tirage );

        for (int i=1;i<=10000;i++) {
            LocalDate dateAleatoire = ToolBox.getRandomLocaleDate(1937, 2022);
            System.out.println(dateAleatoire);
        }
    }


}
