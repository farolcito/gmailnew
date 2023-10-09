package GestorCorreo.Filters;
import java.util.ArrayList;
import GestorCorreo.*;

public abstract class Filtro {
     private String nombre = "";

     protected ArrayList<Mail> buscarString(String paraBuscar, Bandeja Bandeja){
          return null;
     }
     //recibe un asunto buscar otro y una bandeja. 
     public ArrayList<Mail> filtrar(String asuntoBuscar, String buscarOtro, Bandeja Bandeja){
          
          buscarString(asuntoBuscar, Bandeja);
          buscarString(buscarOtro, Bandeja);
          return null;
     }
     //busca el string en la bandeja y lo guarda en mails y devuelve mails.
     public ArrayList<Mail> filtrar(String aBuscar, Bandeja bandeja){
          ArrayList<Mail> mails = buscarString(aBuscar, bandeja);
          return mails;
     }

     public void setNombre(String nombre){
          this.nombre = nombre;
     }

     public String getNombre(){
          return nombre;
     }
}

