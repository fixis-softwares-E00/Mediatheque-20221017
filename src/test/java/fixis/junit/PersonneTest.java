package fixis.junit;

import junit.framework.TestCase;
import mediatheque.metier.Personne;

import java.time.format.DateTimeParseException;

import static org.junit.Assert.assertThrows;

public class PersonneTest extends TestCase {

    public void testPresenceCarte()
    {
        Personne p1=new Personne("abcd","def");
        assertNotNull(p1.getCarte());

    }

    public void testConstructeur2A()
    {
        //On vérifie que la création d'une personne provoque une exception lorsque le format de date n'est pas respecté.
        assertThrows(DateTimeParseException.class,() -> new Personne("NOM1", "Prenom1","abcd"));

    }

}
