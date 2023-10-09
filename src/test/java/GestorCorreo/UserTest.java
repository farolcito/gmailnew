package GestorCorreo;

import org.junit.Test;

import GestorCorreo.Filters.FiltroMensajeAsunto;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class UserTest {
    @Test
    public void createuserwithnamesurnameandmail(){
        User oriana = new User("Oriana", "Farela", "orianafarela");

        String name = oriana.getNombre();
        String surname = oriana.getApelldio();
        String mail = oriana.getDireccionCorreo();

        assertEquals("Oriana", name);
        assertEquals("Farela", surname);
        assertEquals("orianafarela@aquilita.com", mail);
    }

    @Test
    public void CreateAndCheck(){
        MailManager aplicacion = new MailManager();
        User Ori = aplicacion.crearUsuario("Oriana", "Farela", "orifarela");
        User Lau = aplicacion.crearUsuario("Lau", "Vega", "vegano");
        User Mario = aplicacion.crearUsuario("Pepe", "Gonzales", "mariogonzales");

        int createuser = aplicacion.getListaUsuarios().size();
        User usuarioOri = aplicacion.getListaUsuarios().get(0);
        
        assertEquals(3, createuser);
        assertEquals(Ori, usuarioOri);
    }
  
    @Test
    public void userTestFuntion(){
        User user = new User("Oriana", "Farela", "orianafarela@gmail.com");
        user.setNombre("ori");
        user.setApellido("farela");
        user.setDireccionCorreo("orianafarela@gmail.com");

        String MyName = "ori";
        String MySurname = "farela";
        String MyMailAdress = "orianafarela@gmail.com";

        assertEquals(MyName, user.getNombre());
        assertEquals(MySurname, user.getApelldio());
        assertEquals(MyMailAdress, user.getDireccionCorreo());
    }


    @Test
    public void userSearchContact(){
        Contacto oriana = new Contacto("Oriana", "Farela", "orianafarela@gmail.com");
        Contacto mario = new Contacto("Pepe", "Goznales", "elpepe@gmail.com");
        ArrayList<Contacto> listadecontactos23 = new ArrayList<>();
         listadecontactos23.add(oriana);
         listadecontactos23.add(mario);

    


}
}

      
          
