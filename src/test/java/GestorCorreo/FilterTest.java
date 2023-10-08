package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.*;
import GestorCorreo.Filters.*;

import java.util.ArrayList;


public class FilterTest {
     MailManager app = new MailManager();
     User oriana= app.crearUsuario("Oriana", "Farela", "orianafarela");
     User lau = app.crearUsuario("Lautaro", "Vega", "vegano@gmail.com");
     User mario = app.crearUsuario("Mario", "Gonzales", "mariogonzales");
     

     @Test
     public void filter_from_title(){
          oriana.anadirContacto("Pepe", "Gozanles Facu", "mariogonzales@aquilita.com");
          oriana.anadirContacto("Lautaro", "vegano", "vegano@gmail.com");

          oriana.crearMensaje(app, "Si", "mensaje", oriana.getTodosLosMailsDeContactos());
          oriana.crearMensaje(app, "No", "mjito", "vegano@gmail.com");
          oriana.crearMensaje(app, "Si", "mensaje", "mariogonzales@aquilita.com");

          FiltroAsunto filtro = new FiltroAsunto();
          ArrayList<Mail> resultado = oriana.filtrarSalida("Si", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void filter_from_message(){
          oriana.crearMensaje(app, "buen dia", "hola pepe", "mariogonzales@aquilita.com");
          oriana.crearMensaje(app, "buenas tardes", " jugamos", "mariogonzales@aquilita.com");
     
          FiltroMensaje filtro = new FiltroMensaje();
          ArrayList<Mail> resultado = mario.filtrarEntrada("hola", filtro);
          assertEquals(1, resultado.size());
     }

     @Test
     public void filter_from_from(){
          oriana.crearMensaje(app, "hola", "jugamos", "vegano@gmail.com");
          oriana.crearMensaje(app, "chau", "no jugamos", "vegano@gmail.com");
          mario.crearMensaje(app, "Buen dia", "como estas", "vegano@gmail.com");

          FiltroRemitente filtro = new FiltroRemitente();
          ArrayList<Mail> resultado = lau.filtrarEntrada("oriana", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void filter_from_title_and_from(){
          oriana.crearMensaje(app, "buenas", "jugamos", "vegano@gmail.com");
          oriana.crearMensaje(app, "hola ", "jugamos", "vegano@gmail.com");
          oriana.crearMensaje(app, "chau", "gracias", "vegano@gmail.com");
          mario.crearMensaje(app, "hola", "como estas?", "vegano@gmail.com");

          FiltroRemitenteAsunto filtro = new FiltroRemitenteAsunto();
          ArrayList<Mail> resultado = lau.filtrarEntrada("hola", "oriana", filtro);
          assertEquals(1, resultado.size());
     }

     @Test
     public void filter_from_title_and_message(){
          felix.crearMensaje(app, "hola", "mi hermano", "rodrigo@gmail.com");
          felix.crearMensaje(app, "este no", "mi hermano", "rodrigo@gmail.com");
          felix.crearMensaje(app, "chau", "este no busco", "rodrigo@gmail.com");
          grace.crearMensaje(app, "hola", "hermano, como estas?", "rodrigo@gmail.com");

          FiltroMensajeAsunto filtro = new FiltroMensajeAsunto();
          ArrayList<Mail> resultado = rodrigo.filtrarEntrada("hola", "hermano", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void name_of_filters(){
          FiltroRemitente filtroRemitente = new FiltroRemitente();
          FiltroMensaje filtroMensaje = new FiltroMensaje();
          FiltroAsunto filtroAsunto = new FiltroAsunto();

          String nombreFiltroRemitente = filtroRemitente.getNombre();
          String nombreFiltroMensaje = filtroMensaje.getNombre();
          String nombreFiltroAsunto = filtroAsunto.getNombre();

          assertEquals("Filtro de Remitente", nombreFiltroRemitente);
          assertEquals("Filtro de Mensaje", nombreFiltroMensaje);
          assertEquals("Filtro de Asunto", nombreFiltroAsunto);

     }
}
