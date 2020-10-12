package Controlador;

import Conexion.Conexion;
import Modelo.ModeloPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class PersonaController {

    public void insertPersona(ModeloPersona persona) throws SQLException {
        Conexion con = new Conexion();
        Connection conexion;
        conexion = con.getConnection();
        int idPersona = AutoIncrementP();

        PreparedStatement ps = conexion.prepareStatement("INSERT INTO persona(idPersona, CorreoPersona) "
                + "VALUES(" + persona.getIdPersona() + "," + persona.getCorreoPersona() + ")");
        ps.execute();
    }

    public ModeloPersona findPersonaByCorreo(String correo) throws SQLException {
        
        Conexion con = new Conexion();
        Connection conexion;
        try {
            conexion = con.getConnection();
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM persona WHERE correoPersona = ?");
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            ModeloPersona modeloPersona = new ModeloPersona();
            while (rs.next()) {
                modeloPersona.setIdPersona(rs.getInt("idpersona"));
                modeloPersona.setCorreoPersona(rs.getString("correopersona"));
            }
            System.out.println("el id es" + modeloPersona.getIdPersona());
            System.out.println("el correo es" + modeloPersona);
            return modeloPersona;

        } catch (SQLException ex) {
            Logger.getLogger(PersonaController.class.getName()).log(Level.SEVERE, null, ex);
            
        }return null;
    }

    public void deletePersona(int id) {

    }

    public void updatePersona(int id) {

    }

    public ModeloPersona obtenerPersonaXId(int id) {
        Conexion con = new Conexion();
        Connection conexion;
        try {
            conexion = con.getConnection();
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM persona WHERE idpersona = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ModeloPersona modeloPersona = new ModeloPersona();
            while (rs.next()) {
                modeloPersona.setIdPersona(rs.getInt("idpersona"));
                modeloPersona.setCorreoPersona(rs.getString("correopersona"));
            }
            System.out.println("el id es" + modeloPersona.getIdPersona());
            System.out.println("el correo es" + modeloPersona);
            return modeloPersona;

        } catch (SQLException ex) {
            Logger.getLogger(PersonaController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<ModeloPersona> obtenerPersonas() {
        return null;
    }

    public int AutoIncrementP() {
        int id = 1;
        try {
            Conexion con = new Conexion();
            PreparedStatement ps = con.getConnection().prepareStatement("SELECT MAX(idPersona) FROM Persona");
            ps.close();
            ResultSet rs = ps.executeQuery();
            rs.close();
            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }

        return id;
    }

}
