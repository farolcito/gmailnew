package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class SendMailsTest {
@Test
    public void crateUserandMail(){
    MailManager aplicacion = new MailManager();
    User gonza= aplicacion.crearUsuario("Gonzalo", "Chaco", "gonzachaco");
    User oriana = aplicacion.crearUsuario("Oriana", "Farela", "orianafarela");
    User mario = aplicacion.crearUsuario("Mario", "Gonzales", "mariogonzales@gmail.com");
    ArrayList<String> para = new ArrayList<>();
    para.add("orianafarela@aquilita.com");
    para.add("mariogonzales@gmail.com");

    gonza.crearMensaje(aplicacion, "Buen dia", "Hola queres jugar", para);
    assertEquals(1, gonza.getSalida().tamano());
    assertEquals(1, oriana.getEntrada().tamano());
    assertEquals(1, mario.getEntrada().tamano());
}

}
