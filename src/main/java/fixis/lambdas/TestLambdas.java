package fixis.lambdas;

import fixis.sauvegarde.Recordable;
import fixis.sauvegarde.SystemeDeSauvegarde;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TestLambdas {

    public static void main(String[] args) throws Exception {


        //Création d'un Runnable sous forme de classe anonyme.
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(LocalTime.now().format(DateTimeFormatter.ISO_TIME));
            }
        };

        //Le même Runnable sous forme de lambda.
        Runnable runnable2 = () -> System.out.println(LocalTime.now().format(DateTimeFormatter.ISO_TIME));

        Thread thread2 = new Thread( runnable2 );
        thread2.start();

        //Créer un Recordable sous forme de classe anonyme, puis traduction en lambda.
        Recordable recordable1 = new Recordable() {
            @Override
            public boolean save() throws Exception {
                System.out.println("Sauvegarde spécifique");
                SystemeDeSauvegarde.getInstance().addRecordable( this);
                return true;
            }
        };

        Recordable recordable2 = () -> {
                System.out.println("Sauvegarde spécifique");

                return true;

        };


        recordable2.save();


        //Création d'un gestionnaire de clic sur un bouton.
        ActionListener gestionnaire1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Hello world");
            }
        };

        ActionListener gestionnaire2 = event -> System.out.println("Hello world");

        //Création d'une ihm exposant un bouton.
        //Une fenêtre...
        JFrame fenetre = new JFrame();
        fenetre.setTitle("Essai de gestionnaire de clic");
        fenetre.setSize(600,200);
        fenetre.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        //On associe un gestionnaire d'affichage à la fenêtre.
        fenetre.setLayout( new FlowLayout( FlowLayout.CENTER ) );

        //Un bouton...
        JButton bouton = new JButton("Cliquer ici");
        fenetre.add( bouton );

        //Abonnement d'un gestionnaire de clic aux services rendus par le bouton.
        bouton.addActionListener( gestionnaire2 );

        fenetre.setVisible( true );

    }

}
