package Entidades;

public class TipoHabitacion {

    private int idTipoHabitacion;
    private String codigo;
    private int capacidad;
    private int cantidadCamas;
    private String tipoCamas;
    private double precioNoche;

    public TipoHabitacion() {
    }
    
    public TipoHabitacion(int idTipoHabitacion, String codigo, int capacidad, int cantidadCamas, String tipoCamas, double precioNoche) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.cantidadCamas = cantidadCamas;
        this.tipoCamas = tipoCamas;
        this.precioNoche = precioNoche;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }

    public String getTipoCamas() {
        return tipoCamas;
    }

    public void setTipoCamas(String tipoCamas) {
        this.tipoCamas = tipoCamas;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    @Override
    public String toString() {
        return "TipoHabitacion{" + "idTipoHabitacion=" + idTipoHabitacion + ", codigo=" + codigo + ", capacidad=" + capacidad + ", cantidadCamas=" + cantidadCamas + ", tipoCamas=" + tipoCamas + ", precioNoche=" + precioNoche + '}';
    }

}
