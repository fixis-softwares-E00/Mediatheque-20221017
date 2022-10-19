package mediatheque.metier;

import fixis.sauvegarde.Recordable;
import fixis.sauvegarde.SystemeDeSauvegarde;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Livre extends Ressource implements Recordable {

    public Livre(String titre) {
        super(titre);

        //Autoabonnement
        SystemeDeSauvegarde.getInstance().addRecordable( this );
    }

    @Override
    public boolean save() throws Exception {
        System.out.println("Sauvegarde du livre "+ this + " dans le fichier livres.csv");

        //Définir le fichier cible.
        File fichier = new File("c://tmp//20221019//livres.csv");


        //Création un outil d'écriture.
        FileWriter writer = new FileWriter( fichier,true );
        BufferedWriter bw = new BufferedWriter( writer );

        //Ecrire la chaine à placer dans le fichier.
        String chaine = getTitre();
        bw.write( chaine );
        bw.newLine();

        //Fermer l'accès au fichier.
        bw.close();

        return true;
    }
}
