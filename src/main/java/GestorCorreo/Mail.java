package GestorCorreo;

import java.util.ArrayList;

public class Mail {
 //atributos de la clase privadas para que no puedan acceder
    private String asunto;
    private String mensaje;
    private String remitente;
// guarda en una lista de Strings los correos. 
    private ArrayList<String> para = new ArrayList<>();
    
//Constructor que recive nuestros atributos y da un espacio de memorias a las clases.(instancia las clases)
    public Mail(String asunto, String mensaje,  String remitente, ArrayList<String> para){
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.remitente = remitente;
        this.para = para;
    }
//mediante el uso del Set y Get podremos acceder a las clases
//Set es para setear un valor, con eso podemos poner un valor
//con get obtenemos un valor    
    public String getAsunto() {
        return asunto;
    }

    public ArrayList<String> getPara() {
        return para;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getRemitente(){
        return remitente;
    }
}