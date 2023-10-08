package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {
    @Test
    public void CreationContact(){
        Contacto contacto = new Contacto("Oriana", "Farela", "orianafarela@gmail.com");
        assertEquals("Oriana", contacto.getNombre());
        assertEquals("Farela", contacto.getApellido());
        assertEquals("orianafarela@gmail.com", contacto.getDireccionCorreo());
    }

    @Test
    public void contactTest(){
        Contacto contacto = new Contacto("Oriana", "Farela", "orianafarela@gmail.com");
        contacto.setNombre("ori");
        contacto.setApellido("farela");
        contacto.setDireccionCorreo("orifarela@gmail.com");

        String Name = "ori";
        String Surname = "farela";
        String MailAdress = "orifarela@gmail.com";

        assertEquals(Name, contacto.getNombre());
        assertEquals(Surname, contacto.getApellido());
        assertEquals(MailAdress, contacto.getDireccionCorreo());
    }
}
