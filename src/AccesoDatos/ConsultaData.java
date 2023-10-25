package AccesoDatos;

import Entidades.DetalleReserva;
import Entidades.Estado;
import Entidades.Habitacion;
import Entidades.Huesped;
import Entidades.Reserva;
import Entidades.TipoHabitacion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

public class ConsultaData {

    private Connection con;

    public ConsultaData() {
        con = Conexion.getConexion();
    }

    // Acceso a datos de Tipo de Habitación
    public List<TipoHabitacion> listarTipoHabitacion() {
        List<TipoHabitacion> tiposHabitacion = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tipohabitacion;";
            // Preparar la conexión
            PreparedStatement ps = con.prepareStatement(sql);
            // Ejecuar la query
            ResultSet rs = ps.executeQuery();
            // Recuperar los Tipo de Habitación
            while (rs.next()) {
                TipoHabitacion tipoHabitacion = new TipoHabitacion();
                tipoHabitacion.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                tipoHabitacion.setCodigo(rs.getString("codigo"));
                tipoHabitacion.setCapacidad(rs.getInt("capacidad"));
                tipoHabitacion.setCantidadCamas(rs.getInt("cantidadCamas"));
                tipoHabitacion.setTipoCamas(rs.getString("tipoCamas"));
                tipoHabitacion.setPrecioNoche(rs.getDouble("precioNoche"));
                tiposHabitacion.add(tipoHabitacion);
            }
            // Cerrar el statments
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla TiposHabitacion: " + e.getMessage());
        }
        return tiposHabitacion;
    }

    public void agregarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        try {
            String sql = "INSERT INTO tipohabitacion(codigo, capacidad, cantidadCamas, tipoCamas, precioNoche) "
                    + "VALUES (?,?,?,?,?)";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Modificar la query con los parametros recibidos
            ps.setString(1, tipoHabitacion.getCodigo());
            ps.setInt(2, tipoHabitacion.getCapacidad());
            ps.setInt(3, tipoHabitacion.getCantidadCamas());
            ps.setString(4, tipoHabitacion.getTipoCamas());
            ps.setDouble(5, tipoHabitacion.getPrecioNoche());
            //Ejecutar la query para insert, update o delete
            ps.executeUpdate();
            //Recuperar la clave primaria del insert
            ResultSet rs = ps.getGeneratedKeys();
            //Evaluar exito al insertar Tipo de Habitación
            if (rs.next()) {
                tipoHabitacion.setIdTipoHabitacion(rs.getInt("insert_id"));
                JOptionPane.showMessageDialog(null, "Tipo de Habitación añadido con éxito.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla TipoHabitacion: " + e.getMessage());
        }
    }

    public void modificarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        try {
            String sql = "UPDATE tipohabitacion "
                    + "SET codigo = ?, capacidad =?, cantidadCamas = ?, tipoCamas = ?, precioNoche = ? "
                    + "WHERE  idTipoHabitacion = ?;";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setString(1, tipoHabitacion.getCodigo());
            ps.setInt(2, tipoHabitacion.getCapacidad());
            ps.setInt(3, tipoHabitacion.getCantidadCamas());
            ps.setString(4, tipoHabitacion.getTipoCamas());
            ps.setDouble(5, tipoHabitacion.getPrecioNoche());
            ps.setInt(6, tipoHabitacion.getIdTipoHabitacion());
            //Crear variable de control de actualización
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Tipo de Habitación modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible modificar el Tipo de Habitación.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla TipoHabitacion: " + e.getMessage());
        }
    }

    public void eliminarTipoHabitacion(int tipoHabitacion) {
        try {
            String sql = "DELETE FROM tipohabitacion "
                    + "WHERE idTipoHabitacion = ?;";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setInt(1, tipoHabitacion);
            //Crear variable de control de actualización
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Tipo de Habitación eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible eliminar el Tipo de Habitación.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla TipoHabitacion: " + e.getMessage());
        }
    }

    public List<String> listaTipoHabitacion() {
        List<String> tiposHabitacion = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT codigo "
                    + "FROM tipoHabitacion;";
            // Preparar la conexión
            PreparedStatement ps = con.prepareStatement(sql);
            // Ejecuar la query
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tiposHabitacion.add(rs.getString(1));
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla TipoHabitacion: " + e.getMessage());
        }

        return tiposHabitacion;
    }

    public TipoHabitacion tipoHabitacionPorCodigo(String codigo) {
        TipoHabitacion tipoHabitacion = new TipoHabitacion();
        try {
            String sql = "SELECT * from tipohabitacion "
                    + "WHERE codigo = ?;";
            // Preparar la conexión
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setString(1, codigo);
            // Ejecuar la query
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tipoHabitacion.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                tipoHabitacion.setCodigo(rs.getString("codigo"));
                tipoHabitacion.setCapacidad(rs.getInt("capacidad"));
                tipoHabitacion.setCantidadCamas(rs.getInt("cantidadCamas"));
                tipoHabitacion.setTipoCamas(rs.getString("tipoCamas"));
                tipoHabitacion.setPrecioNoche(rs.getDouble("precioNoche"));
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla TipoHabitacion: " + e.getMessage());
        }
        return tipoHabitacion;
    }

    public TipoHabitacion tipoHabitacionPorid(int idTipoHabitacion) {
        TipoHabitacion tipoHabitacion = new TipoHabitacion();
        try {
            String sql = "SELECT * from tipohabitacion "
                    + "WHERE idTipoHabitacion = ?;";
            // Preparar la conexión
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setInt(1, idTipoHabitacion);
            // Ejecuar la query
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tipoHabitacion.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                tipoHabitacion.setCodigo(rs.getString("codigo"));
                tipoHabitacion.setCapacidad(rs.getInt("capacidad"));
                tipoHabitacion.setCantidadCamas(rs.getInt("cantidadCamas"));
                tipoHabitacion.setTipoCamas(rs.getString("tipoCamas"));
                tipoHabitacion.setPrecioNoche(rs.getDouble("precioNoche"));
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla TipoHabitacion: " + e.getMessage());
        }
        return tipoHabitacion;
    }

    public int idTipoHabitacionPorCodigo(String codigo) {
        int idTipoHabitacion = 0;
        try {
            String sql = "SELECT idTipoHabitacion "
                    + "FROM tipohabitacion "
                    + "WHERE codigo = ?;";
            // Preparar la conexión
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setString(1, codigo);
            // Ejecuar la query
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idTipoHabitacion = rs.getInt("idTipoHabitacion");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla TipoHabitacion: " + e.getMessage());
        }
        return idTipoHabitacion;
    }

    // Acceso a datos de Habitación
    public List<Habitacion> listarHabitaciones() {
        List<Habitacion> habitaciones = new ArrayList<>();
        try {
            String sql = "SELECT * FROM habitacion, tipoHabitacion "
                    + "WHERE habitacion.tipoHabitacion = tipoHabitacion.idTipoHabitacion "
                    + "ORDER BY habitacion.numero;";
            //Preparar la conexión
            PreparedStatement ps = con.prepareStatement(sql);
            //Ejecutar la query
            ResultSet rs = ps.executeQuery();
            //Recuperar Habitaciones
            while (rs.next()) {
                //Recuperar estado
                Estado estadoHabitacion = Estado.Libre;
                for (Estado estado : Estado.values()) {
                    if (estado.toString().equalsIgnoreCase(rs.getString("estado"))) {
                        estadoHabitacion = estado;
                    }
                };
                // Variables de recuperación
                Habitacion habitacion = new Habitacion();
                TipoHabitacion tipoHabitacion = new TipoHabitacion();
                // Recuperar habitaciones de la BD
                habitacion.setIdHabitacion(rs.getInt("idHabitacion"));
                habitacion.setNumero(rs.getInt("numero"));
                habitacion.setPiso(rs.getInt("piso"));
                habitacion.setEstado(estadoHabitacion);
                // Recuperar Tipo de Habitación
                tipoHabitacion.setIdTipoHabitacion(rs.getInt("idHabitacion"));
                tipoHabitacion.setCodigo(rs.getString("codigo"));
                tipoHabitacion.setCapacidad(rs.getInt("capacidad"));
                tipoHabitacion.setCantidadCamas(rs.getInt("cantidadCamas"));
                tipoHabitacion.setTipoCamas(rs.getString("tipoCamas"));
                tipoHabitacion.setPrecioNoche(rs.getDouble("precioNoche"));
                // Continua recuperación de Habitación
                habitacion.setTipoHabitacion(tipoHabitacion);
                // Agregar habitación a la lista
                habitaciones.add(habitacion);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitacion: " + e.getMessage());
        }
        return habitaciones;
    }

    public void agregarHabitacion(Habitacion habitacion) {
        try {
            String sql = "INSERT INTO habitacion(numero, piso, estado, tipoHabitacion) "
                    + "VALUES (?, ?, ?, ?);";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Modificar la query con los parametros recibidos
            ps.setInt(1, habitacion.getNumero());
            ps.setInt(2, habitacion.getPiso());
            ps.setString(3, habitacion.getEstado().toString());
            ps.setInt(4, habitacion.getTipoHabitacion().getIdTipoHabitacion());
            //Ejecutar la query para insert, update o delete
            ps.executeUpdate();
            //Recuperar la clave primaria del insert
            ResultSet rs = ps.getGeneratedKeys();
            //Evaluar exito al insertar Tipo de Habitación
            if (rs.next()) {
                habitacion.setIdHabitacion(rs.getInt("insert_id"));
                JOptionPane.showMessageDialog(null, "Habitación añadida con éxito.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitacion: " + e.getMessage());
        }
    }

    public void modificarHabitacion(Habitacion habitacion) {
        try {
            String sql = "UPDATE habitacion "
                    + "SET numero = ?, piso = ?, estado = ?, tipoHabitacion = ? "
                    + "WHERE idHabitacion = ?;";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setInt(1, habitacion.getNumero());
            ps.setInt(2, habitacion.getPiso());
            ps.setString(3, habitacion.getEstado().toString());
            ps.setInt(4, habitacion.getTipoHabitacion().getIdTipoHabitacion());
            ps.setInt(5, habitacion.getIdHabitacion());
            //Crear variable de control de actualización
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Habitación modificada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible modificar la Habitación.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitacion: " + e.getMessage());
        }
    }

    public void eliminarHabitacion(int habitacion) {
        try {
            String sql = "DELETE FROM habitacion "
                    + "WHERE idHabitacion = ?;";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setInt(1, habitacion);
            //Crear variable de control de actualización
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Habitación eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible eliminar la Habitación.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitacion: " + e.getMessage());
        }
    }

    public List<Integer> pisosActivos() {
        List<Integer> pisos = new ArrayList<>();
        String sql = "SELECT DISTINCT piso "
                + "FROM Habitacion;";
        try {
            //Preparar la conexión
            PreparedStatement ps = con.prepareStatement(sql);
            //Ejecutar la query
            ResultSet rs = ps.executeQuery();
            //Recuperar Habitaciones
            while (rs.next()) {
                pisos.add(rs.getInt(1));
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitacion: " + e.getMessage());
        }
        return pisos;
    }

    public int idHabitacionPorNumeroYPiso(int numero, int piso) {
        int idHabitacion = 0;
        try {
            String sql = "SELECT idHabitacion "
                    + "FROM habitacion "
                    + "WHERE numero = ? AND piso = ?;";
            //Preparar la conexión
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setInt(1, numero);
            ps.setInt(2, piso);
            //Ejecutar la query
            ResultSet rs = ps.executeQuery();
            //Recuperar ID de Habitacion
            while (rs.next()) {
                idHabitacion = rs.getInt("idHabitacion");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitacion: " + e.getMessage());
        }
        return idHabitacion;
    }

    public Habitacion habitacionPorNumero(int numeroHabitacion) {
        Habitacion habitacion = new Habitacion();
        ConsultaData consulta = new ConsultaData();
        try {
            String sql = "SELECT * "
                    + "FROM habitacion "
                    + "WHERE numero = ?;";
            //Preparar la conexión
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setInt(1, numeroHabitacion);
            //Ejecutar la query
            ResultSet rs = ps.executeQuery();
            //Recuperar ID de Habitacion
            while (rs.next()) {
                habitacion.setIdHabitacion(rs.getInt("idHabitacion"));
                habitacion.setNumero(rs.getInt("numero"));
                habitacion.setPiso(rs.getInt("piso"));
                //Recuperar estado
                Estado estadoHabitacion = Estado.Libre;
                for (Estado estado : Estado.values()) {
                    if (estado.toString().equalsIgnoreCase(rs.getString("estado"))) {
                        estadoHabitacion = estado;
                        break;
                    }
                };
                habitacion.setEstado(estadoHabitacion);
                habitacion.setTipoHabitacion(consulta.tipoHabitacionPorid(rs.getInt("tipoHabitacion")));
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitacion: " + e.getMessage());
        }
        return habitacion;
    }

    // Acceso a datos de Huesped
    public List<Huesped> listarHuespedes() {
        List<Huesped> huespedes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM huesped;";
            // Preparar la conexión
            PreparedStatement ps = con.prepareStatement(sql);
            // Ejecutar la query
            ResultSet rs = ps.executeQuery();
            // Recuperar huespedes de la BD
            while (rs.next()) {
                Huesped huesped = new Huesped();
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setApellido(rs.getString("apellido"));
                huesped.setDni(rs.getString("dni"));
                huesped.setTelefono(rs.getString("telefono"));
                huesped.setEmail(rs.getString("email"));
                // Agregar huesped
                huespedes.add(huesped);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Huesped: " + e.getMessage());
        }
        return huespedes;
    }

    public void agregarHuesped(Huesped huesped) {
        try {
            String sql = "INSERT INTO huesped (nombre, apellido, dni, telefono, email) "
                    + "VALUES (?, ?, ?, ?, ?);";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Modificar la query con los parametros recibidos
            ps.setString(1, huesped.getNombre());
            ps.setString(2, huesped.getApellido());
            ps.setString(3, huesped.getDni());
            ps.setString(4, huesped.getTelefono());
            ps.setString(5, huesped.getEmail());
            //Ejecutar la query para insert, update o delete
            ps.executeUpdate();
            //Recuperar la clave primaria del insert
            ResultSet rs = ps.getGeneratedKeys();
            //Evaluar exito al insertar Tipo de Habitación
            if (rs.next()) {
                huesped.setIdHuesped(rs.getInt("insert_id"));
                JOptionPane.showMessageDialog(null, "Huesped añadido con éxito.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Huesped: " + e.getMessage());
        }
    }

    public void modificarHuesped(Huesped huesped) {
        try {
            String sql = "UPDATE huesped "
                    + "SET nombre = ?, apellido = ?, dni = ?, telefono = ?, email = ? "
                    + "WHERE idHuesped = ?;";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setString(1, huesped.getNombre());
            ps.setString(2, huesped.getApellido());
            ps.setString(3, huesped.getDni());
            ps.setString(4, huesped.getTelefono());
            ps.setString(5, huesped.getEmail());
            ps.setInt(6, huesped.getIdHuesped());
            //Crear variable de control de actualización
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Huesped modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible modificar el Huesped.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Huesped: " + e.getMessage());
        }
    }

    public void eliminarHuesped(int idHuesped) {
        try {
            String sql = "DELETE FROM huesped "
                    + "WHERE idHuesped = ?;";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setInt(1, idHuesped);
            //Crear variable de control de actualización
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Huesped eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible eliminar el Huesped.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Huesped: " + e.getMessage());
        }
    }

    public int idHuespedPorDni(String dni) {
        int idHuesped = 0;
        try {
            String sql = "SELECT idHuesped "
                    + "FROM huesped "
                    + "WHERE dni = ?;";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setString(1, dni);
            // Ejecutar la query
            ResultSet rs = ps.executeQuery();
            // Recuperar huespedes de la BD
            while (rs.next()) {
                idHuesped = rs.getInt(1);
            }
            // Cerrar statement
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Huesped: " + e.getMessage());
        }
        return idHuesped;
    }

    public Huesped huespedPorDni(String dni) {
        Huesped huesped = new Huesped();
        try {
            String sql = "SELECT * "
                    + "FROM huesped "
                    + "WHERE dni = ?;";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setString(1, dni);
            // Ejecutar la query
            ResultSet rs = ps.executeQuery();
            // Recuperar huespedes de la BD
            while (rs.next()) {
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setApellido(rs.getString("apellido"));
                huesped.setDni(rs.getString("dni"));
                huesped.setTelefono(rs.getString("telefono"));
                huesped.setEmail(rs.getString("email"));
            }
            // Cerrar statement
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Huesped: " + e.getMessage());
        }
        return huesped;
    }

    // Acceso a datos de Reserva
    public List<Reserva> listarReservas() {
        List<Reserva> reservas = new ArrayList<>();
        try {
            String sql = "SELECT * "
                    + "FROM reserva, huesped "
                    + "WHERE reserva.idHuesped = huesped.idHuesped;";
            //Preparar conexión
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //Recuperar estado
                Estado estadoReserva = Estado.Activa;
                for (Estado estado : Estado.values()) {
                    if (estado.toString().equalsIgnoreCase(rs.getString("estado"))) {
                        estadoReserva = estado;
                    }
                };
                // Variables de recuperación
                Reserva reserva = new Reserva();
                Huesped huesped = new Huesped();
                // Recuperar Reserva de la BD
                reserva.setIdReserva(rs.getInt("idReserva"));
                reserva.setFechaEntrada(rs.getDate("fechaEntrada").toLocalDate());
                reserva.setFechaSalida(rs.getDate("fechaSalida").toLocalDate());
                reserva.setCantidadDias(rs.getInt("cantidadDias"));
                reserva.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                reserva.setMontoEstadia(rs.getDouble("montoEstadia"));
                reserva.setEstado(estadoReserva);
                // Recuperar Huesped de la Reserva
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setApellido(rs.getString("apellido"));
                huesped.setDni(rs.getString("dni"));
                huesped.setTelefono(rs.getString("telefono"));
                huesped.setEmail(rs.getString("email"));
                // Continua recuperación de Reserva
                reserva.setHuesped(huesped);
                if (rs.getDate("checkIn") != null) {
                    reserva.setCheckIn(rs.getDate("checkIn").toLocalDate());
                }
                if (rs.getDate("checkOut") != null) {
                    reserva.setCheckOut(rs.getDate("checkOut").toLocalDate());
                }
                // Agregar Reserva a la lista
                reservas.add(reserva);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva: " + e.getMessage());
        }
        return reservas;
    }

    public void agregarReserva(Reserva reserva, List<DetalleReserva> listaReserva) {
        int controlDetalle = 0;
        int controlReserva = 0;
        Double montoReserva = 0.00;
        Double valorDia = 0.00;
        int dias = reserva.getCantidadDias();
        for (DetalleReserva detalle : listaReserva) {
            valorDia += detalle.getHabitacion().getTipoHabitacion().getPrecioNoche();
            controlDetalle += 1;
        }
        montoReserva = valorDia * dias;
        reserva.setMontoEstadia(montoReserva);
        reserva.setEstado(Estado.Activa);

        try {
            String sql = "INSERT INTO reserva(fechaEntrada, fechaSalida, cantidadDias, cantidadPersonas, montoEstadia, estado, idHuesped) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?);";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Modificar la query con los parametros recibidos
            ps.setDate(1, Date.valueOf(reserva.getFechaEntrada()));
            ps.setDate(2, Date.valueOf(reserva.getFechaSalida()));
            ps.setInt(3, reserva.getCantidadDias());
            ps.setInt(4, reserva.getCantidadPersonas());
            ps.setDouble(5, reserva.getMontoEstadia());
            ps.setString(6, reserva.getEstado().toString());
            ps.setInt(7, reserva.getHuesped().getIdHuesped());
            //Ejecutar la query para insert, update o delete
            ps.executeUpdate();
            //Recuperar la clave primaria del insert
            ResultSet rs = ps.getGeneratedKeys();
            //Evaluar exito al insertar Tipo de Habitación
            if (rs.next()) {
                reserva.setIdReserva(rs.getInt("insert_id"));
                controlReserva += 1;
            }
            // Preparar Detalle de Reserva
            for (DetalleReserva detalle : listaReserva) {
                sql = "INSERT INTO detallereserva(idReserva, idHabitacion) "
                        + "VALUES (?, ?);";
                //Preparar la conexión con la query
                ps = con.prepareStatement(sql);
                //Modificar la query con los parametros recibidos
                ps.setInt(1, reserva.getIdReserva());
                ps.setInt(2, detalle.getHabitacion().getIdHabitacion());
                ps.executeUpdate();
                controlDetalle -= 1;
            }
            if (controlReserva == 1 && controlDetalle == 0) {
                JOptionPane.showMessageDialog(null, "Reserva añadida con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al añadir Reserva.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva: " + e.getMessage());
        }
    }

    public void eliminarReserva(int reserva) {
        try {
            // Eliminar Detalle Reserva asociado a la Reserva
            String sql = "UPDATE reserva "
                    + "SET estado = 'Inactiva' "
                    + "WHERE idReserva = ?;";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setInt(1, reserva);
            //Crear variable de control de exito
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Reserva anulada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible eliminar la Reserva.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva: " + e.getMessage());
        }
    }

    public void modificarReserva(Reserva reserva) {

        try {
            String sql = "UPDATE reserva "
                    + "SET fechaEntrada = ?, fechaSalida = ?, cantidadDias = ?, cantidadPersonas = ?, montoEstadia = ?, estado = ?, idHuesped = ?, checkIn =?, checkOut = ? "
                    + "WHERE idReserva = ?;";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setDate(1, Date.valueOf(reserva.getFechaEntrada()));
            ps.setDate(2, Date.valueOf(reserva.getFechaSalida()));
            ps.setInt(3, reserva.getCantidadDias());
            ps.setInt(4, reserva.getCantidadPersonas());
            ps.setDouble(5, reserva.getMontoEstadia());
            ps.setString(6, reserva.getEstado().toString());
            ps.setInt(7, reserva.getHuesped().getIdHuesped());
            if(reserva.getCheckIn() != null){
                ps.setDate(8, Date.valueOf(reserva.getCheckIn()));
            } else {
                ps.setNull(8, 0);
            }
            if(reserva.getCheckOut() != null){
                ps.setDate(9, Date.valueOf(reserva.getCheckOut()));
            } else {
                ps.setNull(9, 0);
            }
            ps.setInt(10, reserva.getIdReserva());
            //Crear variable de control de exito
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Reserva modificada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible modificar la Reserva.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva: " + e.getMessage());
        }
    }

    public Reserva reservaPorIdReserva(int idReserva) {
        Reserva reserva = new Reserva();
        try {
            String sql = "SELECT * "
                    + "FROM reserva, huesped "
                    + "WHERE reserva.idHuesped = huesped.idHuesped "
                    + "AND idReserva = ?;";
            //Preparar conexión
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idReserva);
            // Ejecutar la query
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Recuperar estado
                Estado estadoReserva = Estado.Activa;
                for (Estado estado : Estado.values()) {
                    if (estado.toString().equalsIgnoreCase(rs.getString("estado"))) {
                        estadoReserva = estado;
                    }
                };
                // Crear variable Huesped
                Huesped huesped = new Huesped();
                // Recuperar Reserva de la BD
                reserva.setIdReserva(rs.getInt("idReserva"));
                reserva.setFechaEntrada(rs.getDate("fechaEntrada").toLocalDate());
                reserva.setFechaSalida(rs.getDate("fechaSalida").toLocalDate());
                reserva.setCantidadDias(rs.getInt("cantidadDias"));
                reserva.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                reserva.setMontoEstadia(rs.getDouble("montoEstadia"));
                reserva.setEstado(estadoReserva);
                // Recuperar Huesped de la Reserva
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setApellido(rs.getString("apellido"));
                huesped.setDni(rs.getString("dni"));
                huesped.setTelefono(rs.getString("telefono"));
                huesped.setEmail(rs.getString("email"));
                // Continua recuperación de Reserva
                reserva.setHuesped(huesped);
            }
            // Cerrar statements
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva: " + e.getMessage());
        }
        return reserva;
    }

    // Acceso a datos de Detalle Reserva
    public List<DetalleReserva> listarDetalleReserva() {
        List<DetalleReserva> detallesReservas = new ArrayList<>();
        try {
            String sql = "SELECT d.idDetalleReserva, d.idReserva, d.idHabitacion, "
                    + "r.idReserva, r.fechaEntrada, r.fechaSalida, r.cantidadDias, r.cantidadPersonas, r.montoEstadia, r.estado AS estadoReserva, r.idHuesped, "
                    + "h.idHuesped, h.nombre, h.apellido, h.dni, h.telefono, h.email, "
                    + "a.idHabitacion, a.numero, a.piso, a.estado AS estadoHabitacion, a.tipoHabitacion, "
                    + "t.idTipoHabitacion, t.codigo, t.capacidad, t.cantidadCamas, t.tipoCamas, t.precioNoche, r.checkIn, r.checkOut "
                    + "FROM detallereserva d, reserva r, huesped h, habitacion a, tipohabitacion t "
                    + "WHERE d.idHabitacion = a.idHabitacion "
                    + "AND d.idReserva = r.idReserva "
                    + "AND r.idHuesped = h.idHuesped "
                    + "AND a.tipoHabitacion = t.idTipoHabitacion;";
            //Preparar conexión
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Recuperar Detalles Reservas
            while (rs.next()) {
                //Recuperar estados Reserva y Habitación
                Estado estadoReserva = Estado.Activa;
                for (Estado estado : Estado.values()) {
                    if (estado.toString().equalsIgnoreCase(rs.getString("estadoReserva"))) {
                        estadoReserva = estado;
                    }
                };
                Estado estadoHabitacion = Estado.Activa;
                for (Estado estado : Estado.values()) {
                    if (estado.toString().equalsIgnoreCase(rs.getString("estadoHabitacion"))) {
                        estadoReserva = estado;
                    }
                };

                // Variables de recuperación
                DetalleReserva detalleReserva = new DetalleReserva();
                Reserva reserva = new Reserva();
                Huesped huesped = new Huesped();
                Habitacion habitacion = new Habitacion();
                TipoHabitacion tipoHabitacion = new TipoHabitacion();

                // Recuperar Detalle Reserva de la BD
                detalleReserva.setIdDetalleReserva(rs.getInt("idDetalleReserva"));
                // Recuperar Reserva de la BD
                reserva.setIdReserva(rs.getInt("idReserva"));
                reserva.setFechaEntrada(rs.getDate("fechaEntrada").toLocalDate());
                reserva.setFechaSalida(rs.getDate("fechaSalida").toLocalDate());
                reserva.setCantidadDias(rs.getInt("cantidadDias"));
                reserva.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                reserva.setMontoEstadia(rs.getDouble("montoEstadia"));
                reserva.setEstado(estadoReserva);
                // Recuperar Huesped de la Reserva
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setApellido(rs.getString("apellido"));
                huesped.setDni(rs.getString("dni"));
                huesped.setTelefono(rs.getString("telefono"));
                huesped.setEmail(rs.getString("email"));
                // Continuar recuperación de Reserva
                reserva.setHuesped(huesped);
                if (rs.getDate("checkIn") != null) {
                    reserva.setCheckIn(rs.getDate("checkIn").toLocalDate());
                }
                if (rs.getDate("checkOut") != null) {
                    reserva.setCheckOut(rs.getDate("checkOut").toLocalDate());
                }
                // Continuar recuperacion de Detalle Reserva
                detalleReserva.setReserva(reserva);
                //Recuperar Habitacion de la BD
                habitacion.setIdHabitacion(rs.getInt("idHabitacion"));
                habitacion.setNumero(rs.getInt("numero"));
                habitacion.setPiso(rs.getInt("piso"));
                habitacion.setEstado(estadoHabitacion);
                // Recuperar Tipo de Habitación
                tipoHabitacion.setIdTipoHabitacion(rs.getInt("idHabitacion"));
                tipoHabitacion.setCodigo(rs.getString("codigo"));
                tipoHabitacion.setCapacidad(rs.getInt("capacidad"));
                tipoHabitacion.setCantidadCamas(rs.getInt("cantidadCamas"));
                tipoHabitacion.setTipoCamas(rs.getString("tipoCamas"));
                tipoHabitacion.setPrecioNoche(rs.getDouble("precioNoche"));
                // Continua recuperación de Habitación
                habitacion.setTipoHabitacion(tipoHabitacion);
                // Continuar recuperacion de Detalle Reserva
                detalleReserva.setHabitacion(habitacion);
                // Agregar Detalle Reserva a la lista
                detallesReservas.add(detalleReserva);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva: " + e.getMessage());
        }
        return detallesReservas;
    }

    public List<Habitacion> listarDisponibilidad(LocalDate desde, LocalDate hasta) {
        List<Habitacion> habitaciones = new ArrayList<>();
        ConsultaData consulta = new ConsultaData();
        try {
            String sql = "SELECT h.numero, h.piso, th.codigo, th.capacidad, th.cantidadCamas, th.tipoCamas, th.precioNoche "
                    + "FROM Habitacion h "
                    + "INNER JOIN TipoHabitacion th "
                    + "ON h.tipoHabitacion = th.idTipoHabitacion "
                    + "WHERE h.idHabitacion NOT IN (SELECT dr.idHabitacion "
                    + "FROM Reserva r "
                    + "INNER JOIN DetalleReserva dr "
                    + "ON r.idReserva = dr.idReserva "
                    + "WHERE r.estado = 'Activa' "
                    + "AND ((r.fechaEntrada <= ? "
                    + "AND r.fechaSalida >= ?) "
                    + "OR (r.fechaEntrada <= ? "
                    + "AND r.fechaSalida >= ?) "
                    + "OR (r.fechaEntrada >= ? "
                    + "AND r.fechaSalida <= ?)))"
                    + "ORDER BY h.numero;";
            //Preparar conexión
            PreparedStatement ps = con.prepareStatement(sql);
            // Insertar parametros de fechas
            ps.setDate(1, Date.valueOf(desde));
            ps.setDate(2, Date.valueOf(desde));
            ps.setDate(3, Date.valueOf(hasta));
            ps.setDate(4, Date.valueOf(hasta));
            ps.setDate(5, Date.valueOf(desde));
            ps.setDate(6, Date.valueOf(hasta));
            ResultSet rs = ps.executeQuery();
            // Reconstruir Habitaciones de la BD
            while (rs.next()) {
                // Variables de recuperación
                Habitacion habitacion = new Habitacion();
                TipoHabitacion tipoHabitacion = new TipoHabitacion();
                // Inicio de recuperación
                habitacion.setIdHabitacion(consulta.idHabitacionPorNumeroYPiso(rs.getInt("numero"), rs.getInt("piso")));
                habitacion.setNumero(rs.getInt("numero"));
                habitacion.setPiso(rs.getInt("piso"));
                habitacion.setEstado(Estado.Libre);
                // Recuperar Tipo de Habitación
                tipoHabitacion.setIdTipoHabitacion(consulta.idTipoHabitacionPorCodigo(rs.getString("codigo")));
                tipoHabitacion.setCodigo(rs.getString("codigo"));
                tipoHabitacion.setCapacidad(rs.getInt("capacidad"));
                tipoHabitacion.setCantidadCamas(rs.getInt("cantidadCamas"));
                tipoHabitacion.setTipoCamas(rs.getString("tipoCamas"));
                tipoHabitacion.setPrecioNoche(rs.getDouble("precioNoche"));
                // Continua recuperación de Habitación
                habitacion.setTipoHabitacion(tipoHabitacion);
                // Agregar habitación a la lista
                habitaciones.add(habitacion);
            }
            // Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva/Detalle: " + e.getMessage());
        }
        return habitaciones;
    }
}
