package fixis.sauvegarde;

import java.util.ArrayList;

public class SystemeDeSauvegarde {

    private ArrayList<Recordable> liste;
    private static SystemeDeSauvegarde instance;

    private SystemeDeSauvegarde() {

        //Initialisation de la liste.
        liste = new ArrayList<>();
    }

    public boolean sauvegarder() throws Exception
    {
        //On parcourt la liste des éléments enregistrables.
        //On invoque la méthode "save()" sur chacun d'eux.
        for ( Recordable rec : liste )
        {
            rec.save();
        }

        return true;
    }


    /**
     * Méthode d'abonnement.
     *
     * @param recordable
     * @return
     */
    public boolean addRecordable( Recordable recordable )
    {
        return liste.add(recordable);
    }


    public static SystemeDeSauvegarde getInstance()
    {
        //On crée le système de sauvegarde s'il n'a pas déjà été créé.
        //Sinon on renvoie l'instance créée précédemment.
        if ( instance == null )
        {
            instance = new SystemeDeSauvegarde();
        }

        return instance;
    }

}
