/*
 * Controlador para el modelo de la tabla problema en la base de datos helpdesk
 * sientese y disfrute ;)
 */
package Controlador;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Cookie
 */
public class ProblemaController {
        //Insertar correo a la BD
    public void insertarProblema(ModeloProblema modeloProblema) {
        try {
            Conexion con = new Conexion();
            Connection conexion;
            conexion = con.getConnection();
            int idProblema = AutoIncrement();
            int idSolucion = con.AutoIncrementS();
            int idAvances = con.AutoIncrementA();

            PreparedStatement ps = conexion.prepareStatement("INSERT INTO Problema(idProblema, NombreProb, DetalleProb, FechaCreacion, "
                    + "RefIdPrioridad, RefAreaProb, RefTipoProb, RefEstado, RefSolucion, RefAvances) "
                    + "VALUES(" + idProblema + ",?, ?, CURRENT_TIMESTAMP," + idPrioridad + "," + idAreaProb + "," + idTipoProb + "," + idEstado + "," + idSolucion + "," + idAvances + ")");
            ps.setString(1, modeloProblema.getSujeto());
            ps.setString(2, modeloProblema.getContenido());

            System.out.println(ps);
            
            System.out.println("\nVariable Asunto: " + modeloProblema.getSujeto());
            System.out.println("Variable Contenido: " + modeloProblema.getContenido() + "\n");
         
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error" + ex + "\n");
        }
    }
     public int AutoIncrement() {
        int id;
        try {
            ps = getConnection().prepareStatement("SELECT MAX(idProblema) FROM Problema");
            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        return id;
    }
    
}
