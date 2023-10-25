
package Entidades;

public class Habitacion {
    private int idHabitacion;
    private int numero;
    private int piso;
    private Estado estado;
    private TipoHabitacion tipoHabitacion;

    public Habitacion() {
    }

    public Habitacion(int idHabitacion, int numero, int piso, Estado estado, TipoHabitacion tipoHabitacion) {
        this.idHabitacion = idHabitacion;
        this.numero = numero;
        this.piso = piso;
        this.estado = estado;
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "idHabitacion=" + idHabitacion + ", numero=" + numero + ", piso=" + piso + ", estado=" + estado + ", tipoHabitacion=" + tipoHabitacion + '}';
    }
    
}
