package Modelo;

public class ModeloSolucion {

    public ModeloSolucion() {
    }

    public ModeloSolucion(int idSolucion, String Solucion) {
        this.idSolucion = idSolucion;
        this.Solucion = Solucion;
    }
    
    private int idSolucion;
    private String Solucion;

    public int getIdSolucion() {
        return idSolucion;
    }

    public void setIdSolucion(int idSolucion) {
        this.idSolucion = idSolucion;
    }

    public String getSolucion() {
        return Solucion;
    }

    public void setSolucion(String Solucion) {
        this.Solucion = Solucion;
    }

}
