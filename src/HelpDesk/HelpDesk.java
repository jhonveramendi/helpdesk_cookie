package HelpDesk;

import Controlador.RecibirEmail;
import Controlador.ControladorProblema;
import Controlador.PersonaController;
import Controlador.ProblemaController;
import Modelo.ConsultasProblema;
import Modelo.ModeloAvances;
import Modelo.ModeloCorreo;
import Modelo.ModeloPersona;
import Modelo.ModeloProblema;
import Modelo.ModeloSolucion;
import Vista.AñadirProblema;
import Vista.VistaTicket;
import Vista.VerProblema;
import Vista.VistaAvances;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

public class HelpDesk {

    public static void main(String[] args) throws SQLException, IOException, MessagingException {



            PersonaController personaController = new PersonaController();
            RecibirEmail recibeEmail = new RecibirEmail();
            personaController.findPersonaByCorreo("jhongj@veramendi.com");
            AñadirProblema vistaAñadirProblema = new AñadirProblema();
            vistaAñadirProblema.setVisible(true);
            System.out.println("Finaliza");
    }
}
