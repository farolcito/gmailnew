package GestorCorreo;

import java.util.ArrayList;

public class Mail {

    private String asunto;
    private String mensaje;
    private String remitente;
    private ArrayList<String> para = new ArrayList<>();
    

    public Mail(String asunto, String mensaje,  String remitente, ArrayList<String> para){
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.remitente = remitente;
        this.para = para;
    }

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
