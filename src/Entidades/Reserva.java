
package Entidades;

import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private int cantidadDias;
    private int cantidadPersonas;
    private Double montoEstadia;
    private Estado estado;
    private Huesped huesped;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reserva() {
    }

    public Reserva(int idReserva, LocalDate fechaEntrada, LocalDate fechaSalida, int cantidadDias, int cantidadPersonas, Double montoEstadia, Estado estado, Huesped huesped) {
        this.idReserva = idReserva;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cantidadDias = cantidadDias;
        this.cantidadPersonas = cantidadPersonas;
        this.montoEstadia = montoEstadia;
        this.estado = estado;
        this.huesped = huesped;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public Double getMontoEstadia() {
        return montoEstadia;
    }

    public void setMontoEstadia(Double montoEstadia) {
        this.montoEstadia = montoEstadia;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", cantidadDias=" + cantidadDias + ", cantidadPersonas=" + cantidadPersonas + ", montoEstadia=" + montoEstadia + ", estado=" + estado + ", huesped=" + huesped + ", checkIn=" + checkIn + ", checkOut=" + checkOut + '}';
    }

    
    
}
