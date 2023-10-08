package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class SendMailsTest {
@Test
    public void crateUserandMail(){
    MailManager app = new MailManager();
    User gonza= app.crearUsuario("Gonzalo", "Chaco", "gonzachaco");
    User oriana = app.crearUsuario("Oriana", "Farela", "orianafarela");
    User mario = app.crearUsuario("Mario", "Gonzales", "mariogonzales@gmail.com");
    User valen = app.crearUsuario("Valentina", "Salmon", "valensalmon@gmail.com");

    ArrayList<String> para = new ArrayList<>();
    para.add("orianafarela@aquilita.com");
    para.add("mariogonzales@gmail.com");
    para.add("valensalmon@gmail.com");    

    gonza.crearMensaje(app, "Buen dia", "Hola queres jugar", para);
    assertEquals(1, gonza.getSalida().tamano());
    assertEquals(1, oriana.getEntrada().tamano());
    assertEquals(1, mario.getEntrada().tamano());
    assertEquals(1, valen.getEntrada().tamano());
}

}
