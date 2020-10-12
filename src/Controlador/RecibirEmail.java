package Controlador;

import Modelo.ModeloCorreo;
import Modelo.ModeloPersona;
import Modelo.ModeloProblema;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

public class RecibirEmail {
/**
 * Este metodo mapea los correos del email, y los agrega en una lista
 * de ModelosCorreo
 * @return modelo correo
 * @throws MessagingException
 * @throws IOException
 * @throws SQLException 
 */
    public ArrayList<ModeloCorreo> RecibirEmail() throws MessagingException, IOException, SQLException {

       
        ArrayList listaCorreos = new ArrayList();
        Properties p = new Properties();
        p.setProperty("mail.store.protocol", "imaps");

        //Instanciamos la clase Session de JavaMail
        Session sesion = Session.getInstance(p);
        sesion.setDebug(false);

        //Es hora de obtener el Store y el Folder de Inbox (Carpeta de entrada y servidor de correo)
        Store store = sesion.getStore();
        store.connect("imap.gmail.com", "soacrenovado@gmail.com", "Wannabebolso2020");
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        //Obtener los mensajes
        Message[] mensajes = folder.getMessages();

        for (Message m : mensajes) {
            ModeloCorreo modeloCorreo = new ModeloCorreo();
            Address[] in = m.getFrom();
            for (Address address : in) {
                modeloCorreo.setCorreo(address.toString());
                /*                System.out.println("TIENES EL SIGUIENTE MENSAJE:");
                System.out.println("DE: " + modeloCorreo.getCorreo() + "");*/
            }
            Multipart mp = (Multipart) m.getContent();
            modeloCorreo.setMp(mp);
            BodyPart bp = mp.getBodyPart(0);
            modeloCorreo.setBp(bp);
            modeloCorreo.setSujeto(m.getSubject());
            modeloCorreo.setContenido(bp.getContent().toString());
            listaCorreos.add(modeloCorreo);
            /*            System.out.println(listaCorreos);
            System.out.println("FECHA DE ENVIO: " + m.getSentDate());
            System.out.println("ASUNTO: " + modeloCorreo.getSujeto());
            System.out.println("CONTENIDO: " + modeloCorreo.getContenido());*/
        }
        return listaCorreos;
    }
    public ModeloProblema mapeaCorreoAProblema(ModeloCorreo mc){
        ModeloProblema modeloProblema = new ModeloProblema();
        modeloProblema.setNombreProb(mc.getSujeto());
        modeloProblema.setDetalleProb(mc.getContenido());
        return modeloProblema;
    }
    public ModeloPersona mapeaCorreoAPersona(ModeloCorreo mc){
        ModeloPersona modeloPersona = new ModeloPersona();
        modeloPersona.setCorreoPersona(mc.getCorreo());
        return modeloPersona;
    }
}
