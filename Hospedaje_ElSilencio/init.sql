-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS basereserva
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT CHARSET=utf8mb4;

-- Seleccionar la base de datos
USE basereserva;

-- --------------------------------------------------------
-- Tabla: persona
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS persona (
  idpersona INT(11) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20) NOT NULL,
  apaterno VARCHAR(20) NOT NULL,
  amaterno VARCHAR(20) NOT NULL,
  tipo_documento VARCHAR(15) NOT NULL,
  num_documento VARCHAR(8) NOT NULL,
  genero VARCHAR(15) DEFAULT NULL,
  direccion VARCHAR(100) DEFAULT NULL,
  telefono VARCHAR(8) DEFAULT NULL,
  email VARCHAR(25) DEFAULT NULL,
  PRIMARY KEY (idpersona),
  UNIQUE KEY email_UNIQUE (email),
  UNIQUE KEY telefono_UNIQUE (telefono)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- INSERT INTO persona (idpersona, nombre, apaterno, amaterno, tipo_documento, num_documento, direccion, telefono, email) VALUES
-- (1, 'Juan Carlos', 'Arcila', 'Diaz', 'DNI', '47715777', NULL, NULL, NULL),
-- (2, 'Ana', 'Diaz', 'Mundaca', 'DNI', '48596879', 'Chiclayo - Ca. Angamos 34', '98745698', '');

-- --------------------------------------------------------
-- Tabla: cliente
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS cliente (
  idpersona INT(11) NOT NULL,
  codigo_cliente VARCHAR(10) NOT NULL,
  PRIMARY KEY (idpersona),
  UNIQUE KEY codigo_cliente_UNIQUE (codigo_cliente),
  CONSTRAINT fk_persona_cliente FOREIGN KEY (idpersona)
    REFERENCES persona (idpersona)
    ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- INSERT INTO cliente (idpersona, codigo_cliente) VALUES
-- (2, '1');

-- --------------------------------------------------------
-- Tabla: trabajador
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS trabajador (
  idpersona INT(11) NOT NULL,
  sueldo DECIMAL(7,2) NOT NULL,
  acceso VARCHAR(15) NOT NULL,
  login VARCHAR(15) NOT NULL,
  password VARCHAR(100) NOT NULL,
  estado VARCHAR(35) NOT NULL,
  PRIMARY KEY (idpersona),
  UNIQUE KEY login_UNIQUE (login),
  CONSTRAINT fk_persona_trabajador FOREIGN KEY (idpersona)
    REFERENCES persona (idpersona)
    ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- INSERT INTO trabajador (idpersona, sueldo, acceso, login, password, estado) VALUES
-- (1, '5000.00', 'Administrador', 'admin', 'admin', 'A');

-- --------------------------------------------------------
-- Tabla: habitacion
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS habitacion (
  idhabitacion INT(11) NOT NULL AUTO_INCREMENT,
  numero VARCHAR(4) NOT NULL,
  piso VARCHAR(2) NOT NULL,
  descripcion VARCHAR(255) DEFAULT NULL,
  caracteristicas VARCHAR(512) DEFAULT NULL,
  precio_diario DECIMAL(7,2) NOT NULL,
  estado VARCHAR(15) NOT NULL,
  tipo_habitacion VARCHAR(20) NOT NULL,
  PRIMARY KEY (idhabitacion)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- INSERT INTO habitacion (idhabitacion, numero, piso, descripcion, caracteristicas, precio_diario, estado, tipo_habitacion) VALUES
-- (1, '101', '1', 'Habitación Matrimonial', 'Dos camas, baño propio, bar.', '50.00', 'Disponible', 'Individual');

-- --------------------------------------------------------
-- Tabla: producto
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS producto (
  idproducto INT(11) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  descripcion VARCHAR(255) DEFAULT NULL,
  unidad_medida VARCHAR(20) NOT NULL,
  precio_venta DECIMAL(7,2) NOT NULL,
  PRIMARY KEY (idproducto)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- INSERT INTO producto (idproducto, nombre, descripcion, unidad_medida, precio_venta) VALUES
-- (1, 'Agua Mineral', 'Agua de mesa.', 'UND', '3.00'),
-- (2, 'Galleta Choco', 'Galletas', 'UND', '1.00');

-- --------------------------------------------------------
-- Tabla: reserva
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS reserva (
  idreserva INT(11) NOT NULL AUTO_INCREMENT,
  idhabitacion INT(11) NOT NULL,
  idcliente INT(11) NOT NULL,
  idtrabajador INT(11) NOT NULL,
  tipo_reserva VARCHAR(20) NOT NULL,
  fecha_reserva DATE NOT NULL,
  fecha_ingresa DATE NOT NULL,
  fecha_salida DATE NOT NULL,
  costo_alojamiento DECIMAL(7,2) NOT NULL,
  estado VARCHAR(15) NOT NULL,
  PRIMARY KEY (idreserva),
  KEY fk_reserva_habitacion_idx (idhabitacion),
  KEY fk_reserva_cliente_idx (idcliente),
  KEY fk_reserva_trabajador_idx (idtrabajador),
  CONSTRAINT fk_reserva_habitacion FOREIGN KEY (idhabitacion) REFERENCES habitacion (idhabitacion),
  CONSTRAINT fk_reserva_cliente FOREIGN KEY (idcliente) REFERENCES cliente (idpersona),
  CONSTRAINT fk_reserva_trabajador FOREIGN KEY (idtrabajador) REFERENCES trabajador (idpersona)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- INSERT INTO reserva (idreserva, idhabitacion, idcliente, idtrabajador, tipo_reserva, fecha_reserva, fecha_ingresa, fecha_salida, costo_alojamiento, estado) VALUES
-- (1, 1, 2, 1, 'Alquiler', '2016-02-15', '2016-02-15', '2016-02-16', '100.00', 'Pagada'),
-- (2, 1, 2, 1, 'Reserva', '2016-02-15', '2016-02-15', '2016-02-16', '100.00', 'Pagada');

-- --------------------------------------------------------
-- Tabla: consumo
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS consumo (
  idconsumo INT(11) NOT NULL AUTO_INCREMENT,
  idreserva INT(11) NOT NULL,
  idproducto INT(11) NOT NULL,
  cantidad DECIMAL(7,2) NOT NULL,
  precio_venta DECIMAL(7,2) NOT NULL,
  estado VARCHAR(15) NOT NULL,
  PRIMARY KEY (idconsumo),
  KEY fk_consumo_producto_idx (idproducto),
  KEY fk_consumo_reserva_idx (idreserva),
  CONSTRAINT fk_consumo_producto FOREIGN KEY (idproducto) REFERENCES producto (idproducto),
  CONSTRAINT fk_consumo_reserva FOREIGN KEY (idreserva) REFERENCES reserva (idreserva)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- INSERT INTO consumo (idconsumo, idreserva, idproducto, cantidad, precio_venta, estado) VALUES
-- (3, 2, 2, '3.00', '1.00', 'Aceptado'),
-- (4, 2, 1, '2.00', '3.00', 'Aceptado');

-- --------------------------------------------------------
-- Tabla: pago
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS pago (
  idpago INT(11) NOT NULL AUTO_INCREMENT,
  idreserva INT(11) NOT NULL,
  tipo_comprobante VARCHAR(20) NOT NULL,
  num_comprobante VARCHAR(20) NOT NULL,
  igv DECIMAL(4,2) NOT NULL,
  total_pago DECIMAL(7,2) NOT NULL,
  fecha_emision DATE NOT NULL,
  fecha_pago DATE NOT NULL,
  PRIMARY KEY (idpago),
  KEY fk_pago_reserva_idx (idreserva),
  CONSTRAINT fk_pago_reserva FOREIGN KEY (idreserva) REFERENCES reserva (idreserva)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- INSERT INTO pago (idpago, idreserva, tipo_comprobante, num_comprobante, igv, total_pago, fecha_emision, fecha_pago) VALUES
-- (1, 1, 'Factura', '0001-00001', '18.00', '100.00', '2016-02-16', '2016-02-16'),
-- (2, 2, 'Factura', '0001-0002', '18.00', '109.00', '2016-02-16', '2016-02-16');
