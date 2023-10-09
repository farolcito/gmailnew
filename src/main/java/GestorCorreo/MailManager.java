package GestorCorreo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MailManager {
    private ArrayList<User> listaUsuarios = new ArrayList<>();
    
    //recibe un remitente y un mail(dos objetos) el remitente es el usuario que manda y el mail va a ser el mail que se va amandar
    public void mandarMensaje(User remitente, Mail mail){
    //Lista de strings direccionesdemail donde guardamos los mails(el para)
        ArrayList<String> direccionesDeMail = mail.getPara();
        List<User> usuariosEncontrados = encontrarUsuarioConMail(direccionesDeMail);
    //añadimos el mail a la bandeja de salida del remitente
        remitente.anadirMailSalida(mail);
    //añadimos en la bandeja de entra el mail que recibe 
        for (User user : usuariosEncontrados){
            user.anadirMailEntrada(mail);
        }
    }

    //la lista de usuariosencontrados guarda dirreciones de mails.encontrarusuarioconmail es una 
    //funcion que va por todos los usuarios de la lista de usuarios cual coinside con los gmails/correos.
    private List<User> encontrarUsuarioConMail(ArrayList<String> mails) {
        List<User> usuariosEncontrados = listaUsuarios.stream()
    //filter recorre la lista de usuarios, luego la lista de mails lo pasa a .stream
    //.anymatch comparamos todos los mails con todos los usuarios y los que coniciden me devuelve
                .filter(usuario -> mails.stream()
                        .anyMatch(mail -> usuario.getDireccionCorreo().equals(mail)))
                .collect(Collectors.toList());

        return usuariosEncontrados;
    }
    //añaidmos los usuarios nuevos a la lista de usuarios
    public void anadirUsuarioALista(User usuarioNuevo) {
        listaUsuarios.add(usuarioNuevo);
    }
    //crea y nos deuvelve usuario
    public User crearUsuario(String nombre, String apellido, String direcCorreo){
        User usuario = new User(nombre, apellido, direcCorreo);
        anadirUsuarioALista(usuario);
        return usuario;
    }

    //Test purpose
    public ArrayList<User> getListaUsuarios() {
        return listaUsuarios;
    }
}
