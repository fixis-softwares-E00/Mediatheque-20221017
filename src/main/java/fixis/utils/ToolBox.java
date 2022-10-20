package fixis.utils;

import java.time.DateTimeException;
import java.time.LocalDate;

public class ToolBox {

    public static int getRandomValue( int limiteBasse, int limiteHaute )
    {
        //Permutation si la limite basse est en fait la limite haute.
        if ( limiteBasse > limiteHaute )
        {
            int tampon;

            tampon = limiteBasse;
            limiteBasse = limiteHaute;
            limiteHaute = tampon;
        }

        //On évalue l'écart entre les 2 limites.
        int nbValeursPossibles = limiteHaute - limiteBasse + 1;

        //On fait un tirage aléatoire entre 0 et "nbValeursPossibles" exclue.
        int tirageAleatoire = (int)(Math.random()*nbValeursPossibles);

        //On renvoie la somme de la limite basse et de la valeur tirée.
        return limiteBasse + tirageAleatoire;
    }


    public static LocalDate getRandomLocaleDate( int anneeBasse, int anneeHaute)
    {
        //Tirer un jour entre 1 et 31
        int jour = getRandomValue(1,31);

        //Tirer un mois entre 1 et 12
        int mois = getRandomValue(1,12);

        //Tirer une année entre anneeBasse et anneeHaute
        int annee = getRandomValue(anneeBasse, anneeHaute);

        //Construction d'une date à partir de ces paramètres.
        //Si la date est erronée (une exception sera produite), reprendre à l'étape 1.
        LocalDate dateAleatoire;
        try {
            dateAleatoire = LocalDate.of(annee, mois, jour);
        }
        catch (DateTimeException dte)
        {
            //Appel récursif.
            dateAleatoire = getRandomLocaleDate(anneeBasse, anneeHaute);
        }

        return dateAleatoire;

    }

}
