package GestorCorreo;

import GestorCorreo.Filters.*;


import java.util.ArrayList;

public class User {

    private ArrayList<Contacto> listaContactos = new ArrayList<>();

    private Bandeja entrada = new Bandeja();
    private Bandeja salida = new Bandeja();

    private String nombre;
    private String apellido;
    private String direccionCorreo;

    public User(String nombre, String apellido, String direccionCorreo){
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDireccionCorreo(direccionCorreo);
    }

    public Contacto anadirContacto(String nombre, String apellido, String direccionCorreo){
        Contacto nuevoContacto = new Contacto(nombre, apellido, direccionCorreo);
        listaContactos.add(nuevoContacto);
        return nuevoContacto;
    }

    public ArrayList<Contacto> getListaContactos(){
        return listaContactos;
    }

    public ArrayList<String> getTodosLosMailsDeContactos(){
        ArrayList<String> mails = new ArrayList<>();

        for(Contacto contact : listaContactos){
            mails.add(contact.getDireccionCorreo());
        }

        return mails;
    }

    public void crearMensaje(MailManager aplicacion, String asunto, String mensaje, String para) {
        ArrayList<String> listPara = new ArrayList<>();
        listPara.add(para);

        crearMensaje(aplicacion, asunto, mensaje, listPara);
    }
    public void crearMensaje(MailManager aplicacion, String asunto, String mensaje, ArrayList<String> para) {
        Mail mail = new Mail(asunto, mensaje, this.getDireccionCorreo(), para);
        aplicacion.mandarMensaje(this, mail);
    }

    public ArrayList<Mail> filtrarSalida(String toSearch, Filtro filterType){
        ArrayList<Mail> finded = filterType.filtrar(toSearch, salida);
        return finded;
    }
    public ArrayList<Mail> filtrarSalida(String searchTitle, String searchOther, Filtro filterType){
        ArrayList<Mail> finded = filterType.filtrar(searchTitle, searchOther, salida);
        return finded;
    }
    public ArrayList<Mail> filtrarEntrada(String toSearch, Filtro filterType){
        ArrayList<Mail> finded = filterType.filtrar(toSearch, entrada);
        return finded;
    }
    public ArrayList<Mail> filtrarEntrada(String searchTitle, String searchOther, Filtro filterType){
        ArrayList<Mail> finded = filterType.filtrar(searchTitle, searchOther, entrada);
        return finded;
    }

    public void anadirMailEntrada(Mail mail){
        Mail newMail = new Mail(mail.getAsunto(), mail.getMensaje(), mail.getRemitente(), mail.getPara());
        entrada.anadir(newMail);
    }

    public void anadirMailSalida(Mail mail){
        salida.anadir(mail);
    }

    public void setDireccionCorreo(String direccionCorreo) {
        if(direccionCorreo.contains("@")){
            this.direccionCorreo = direccionCorreo;
        } else {
            this.direccionCorreo = direccionCorreo + "@aquilita.com";
        }
    }

    public String getDireccionCorreo() {
        return direccionCorreo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
       this.apellido = apellido;
    }

    public String getApelldio() {
        return apellido;
    }

    public Bandeja getSalida() {
        return salida;
    }
    
    public Bandeja getEntrada() {
        return entrada;
    }
}
