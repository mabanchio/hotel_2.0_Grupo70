
package Entidades;

public class DetalleReserva {
    private int idDetalleReserva;
    private Reserva reserva;
    private Habitacion habitacion;

    public DetalleReserva() {
    }

    public DetalleReserva(int idDetalleReserva, Reserva reserva, Habitacion habitacion) {
        this.idDetalleReserva = idDetalleReserva;
        this.reserva = reserva;
        this.habitacion = habitacion;
    }

    public int getIdDetalleReserva() {
        return idDetalleReserva;
    }

    public void setIdDetalleReserva(int idDetalleReserva) {
        this.idDetalleReserva = idDetalleReserva;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public String toString() {
        return "DetalleReserva{" + "idDetalleReserva=" + idDetalleReserva + ", reserva=" + reserva + ", habitacion=" + habitacion + '}';
    }
    
}
