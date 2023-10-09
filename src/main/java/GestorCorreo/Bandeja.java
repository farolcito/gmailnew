package GestorCorreo;

import java.util.ArrayList;

public class Bandeja {
    //crea un mails arraylist de mails 
    private ArrayList<Mail> mails = new ArrayList<>();
    //devuelve el tamaño de mails
    public int tamano(){
        return mails.size();
    }
    //añade el mail en mails
    public void anadir(Mail mail) {
        mails.add(mail);
    }
    //returna el mails que quieras para eso vas cambiando el index
    public Mail traer(int index){
        return mails.get(index);
    }
    //returna todos los mails
    public ArrayList<Mail> traerTodo(){
        return mails;
    }
}
