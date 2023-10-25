-- Insertar Tipos de Habitación
INSERT INTO TipoHabitacion (codigo, capacidad, cantidadCamas, tipoCamas, precioNoche)
VALUES
    ('EstSimple', 1, 1, 'Cama Simple', 100.00),
    ('EstDoble', 2, 1, 'Cama Queen', 150.00),
    ('EstTriple', 3, 2, '1 Queen 1 Simple', 200.00),
    ('SuiteLujo', 2, 1, 'Cama King Size', 250.00),
    ('Familiar', 4, 3, '1 Queen 2 Simple', 300.00),
    ('Económica', 1, 1, 'Cama Simple', 80.00),
    ('DobleQueen', 2, 1, '2 Camas Queen', 180.00),
    ('Deluxe', 4, 2, '1 King Size 1 Queen', 220.00),
    ('FamiliarSuite', 4, 3, '1 King Size y 2 Camas Simples', 320.00),
    ('EstándarTwin', 2, 2, '2 Camas Simples', 140.00);

-- Generar 10 habitaciones por piso en un edificio de 4 pisos
DELIMITER //
CREATE PROCEDURE GenerarHabitaciones()
BEGIN
    DECLARE piso INT;
    DECLARE habitacion INT;
    DECLARE tipoHabitacion INT;
    
    SET piso = 1;
    
    WHILE piso <= 4 DO
        SET habitacion = 1;
        
        WHILE habitacion <= 10 DO
            -- Asignar un tipo de habitación de manera aleatoria (del 1 al 10)
            SET tipoHabitacion = FLOOR(1 + (RAND() * 10));
            
            INSERT INTO Habitacion (numero, piso, tipoHabitacion)
            VALUES (CONCAT(piso, LPAD(habitacion, 2, '0')), piso, tipoHabitacion);
            
            SET habitacion = habitacion + 1;
        END WHILE;
        
        SET piso = piso + 1;
    END WHILE;
END //
DELIMITER ;

-- Llamar al procedimiento para generar las habitaciones
CALL GenerarHabitaciones();

-- Agregar 10 clientes
INSERT INTO Huesped (nombre, apellido, dni, telefono, email)
VALUES
    ('Juan', 'Perez', '12345678', '123-456-7890', 'juan.perez@example.com'),
    ('Maria', 'Gomez', '23456789', '234-567-8901', 'maria.gomez@example.com'),
    ('Carlos', 'Lopez', '34567890', '345-678-9012', 'carlos.lopez@example.com'),
    ('Laura', 'Rodriguez', '45678901', '456-789-0123', 'laura.rodriguez@example.com'),
    ('Diego', 'Fernandez', '56789012', '567-890-1234', 'diego.fernandez@example.com'),
    ('Ana', 'Gonzalez', '67890123', '678-901-2345', 'ana.gonzalez@example.com'),
    ('Pedro', 'Torres', '78901234', '789-012-3456', 'pedro.torres@example.com'),
    ('Sofia', 'Diaz', '89012345', '890-123-4567', 'sofia.diaz@example.com'),
    ('Lucas', 'Martinez', '90123456', '901-234-5678', 'lucas.martinez@example.com'),
    ('Camila', 'Sanchez', '12340123', '123-401-2345', 'camila.sanchez@example.com');