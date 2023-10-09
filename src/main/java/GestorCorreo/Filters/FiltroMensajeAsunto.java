package GestorCorreo.Filters;

import java.util.ArrayList;

import GestorCorreo.*;

public class FiltroMensajeAsunto extends Filtro {
     public FiltroMensajeAsunto(){
          super.setNombre("Filtro de Asunto y Mensaje");
     }

     @Override
     public ArrayList<Mail> filtrar(String asuntoBuscar, String mensajeBuscar, Bandeja bandeja){
          FiltroAsunto asuntoFiltro = new FiltroAsunto();
          FiltroMensaje mensajeFiltro = new FiltroMensaje();
     //filtro asunto
          ArrayList<Mail> asuntos = asuntoFiltro.filtrar(asuntoBuscar, bandeja);
     //filtro mensaje
          ArrayList<Mail> mensajes = mensajeFiltro.filtrar(mensajeBuscar, bandeja);
     //hago que los dos coincidan
     //guardo todos los asuntos en resultado
          ArrayList<Mail> resultado = new ArrayList<>(asuntos);
     //despues hago que en resultado solo queden los asuntos que coincidan con mensajes
          resultado.retainAll(mensajes);

          return resultado;
     }

}