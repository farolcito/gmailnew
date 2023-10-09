package GestorCorreo;

import GestorCorreo.Filters.*;


import java.util.ArrayList;

public class User {
    //atributos de la clase
    //tenemos un arraylist que recibe la clase contactos
    private ArrayList<Contacto> listaContactos = new ArrayList<>();
    //creamos dos bandejas
    private Bandeja entrada = new Bandeja();
    private Bandeja salida = new Bandeja();
    //atributos
    private String nombre;
    private String apellido;
    private String direccionCorreo;
    //instanciamos los atributos y igualamos 
    public User(String nombre, String apellido, String direccionCorreo){
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDireccionCorreo(direccionCorreo);
    }
    //recibe nombre, apellido, dirrecccion de correo
    public Contacto anadirContacto(String nombre, String apellido, String direccionCorreo){
    //crea un objeto nuevocontacto de la clase contacto
        Contacto nuevoContacto = new Contacto(nombre, apellido, direccionCorreo);
    //en lista contacto que es un arraylist que recibe contactos
    //añade los nuevos contactos
        listaContactos.add(nuevoContacto);
    //devuelve los nuevos contactos
        return nuevoContacto;
    }
    //me muestra la lista de contactos
    public ArrayList<Contacto> getListaContactos(){
        return listaContactos;
    }

    //Crea un array de strings que se llama mails donde recorremos toda la lista y vamos añadiendo 
    //todas las direcciones de correos a nuestra lista mails y retornamos mails
    public ArrayList<String> getTodosLosMailsDeContactos(){
        ArrayList<String> mails = new ArrayList<>();

        for(Contacto contact : listaContactos){
            mails.add(contact.getDireccionCorreo());
        }

        return mails;
    }

    //el metodo crear mensaje recibe aplicacion, asunto, mensaje y para
    //
    public void crearMensaje(MailManager aplicacion, String asunto, String mensaje, String para) {
        ArrayList<String> listPara = new ArrayList<>();
        listPara.add(para);

        crearMensaje(aplicacion, asunto, mensaje, listPara);
    }

    //el metodo crear mensaje recibe aplicacion, asunto, mensaje y para
    //creamos un objeto mail recibe asunto, mensaje, this.getdireccionCorreo(aca va ir la direccion de correo del remitente)
    //mandamos el mensaje a la persona que elegimos 
    public void crearMensaje(MailManager aplicacion, String asunto, String mensaje, ArrayList<String> para) {
        Mail mail = new Mail(asunto, mensaje, this.getDireccionCorreo(), para);
        aplicacion.mandarMensaje(this, mail);
    }
    //recibimos un string a buscar y un filtro
    public ArrayList<Mail> filtrarSalida(String toSearch, Filtro filterType){
    //hace un arraylist de mails porque queremos filtrar los mails
    //aca guardamos los mails filtrados. recibimos la cadena de texto a buscar y filtertype es para saber en donde lo va a buscar en mensaje o asunto o ect.
        ArrayList<Mail> finded = filterType.filtrar(toSearch, salida);
        return finded;
    }
    //recibimos un string que buscar y el tipo de filtro
    public ArrayList<Mail> filtrarSalida(String searchTitle, String searchOther, Filtro filterType){
    //filtertype.filtrar le pasamos el titulo y otra cosa el remitente o el mensaje  y aca buscamos en la bandeja de salida
        ArrayList<Mail> finded = filterType.filtrar(searchTitle, searchOther, salida);
        return finded;
    }
    public ArrayList<Mail> filtrarEntrada(String toSearch, Filtro filterType){
    //filtertype.filtrar le pasamos el titulo y otra cosa el remitente o el mensaje  y aca buscamos en la bandeja de entrada

        ArrayList<Mail> finded = filterType.filtrar(toSearch, entrada);
        return finded;
    }

    public ArrayList<Mail> filtrarEntrada(String searchTitle, String searchOther, Filtro filterType){
        ArrayList<Mail> finded = filterType.filtrar(searchTitle, searchOther, entrada);
        //filtertype.filtrar le pasamos el titulo y otra cosa el remitente o el mensaje  y aca buscamos en la bandeja dee salida
        return finded;
    }

    //añado a Mail sus caracteristicas  y creando un clon de mail llamado newmail le damos los valores de mail. 
    //no lo pongo con el mismo objeto añado un clon porque sino se puede modificar
    //hacemos esto antes de hacer un get y un set
    //añadimos un mail a la bandeja de entrada
    public void anadirMailEntrada(Mail mail){
        Mail newMail = new Mail(mail.getAsunto(), mail.getMensaje(), mail.getRemitente(), mail.getPara());
        entrada.anadir(newMail);
    }

    //añadimos un mail a la bandeja de salida
    public void anadirMailSalida(Mail mail){
        salida.anadir(mail);
    }
    //recibe la dirreccion de correo y si direccion de correo contien un @ guarda la direccion
    //sino a direccion de correo le agrega @Pepe.com y ahi lo guarda.
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
