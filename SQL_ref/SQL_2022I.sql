CREATE DATABASE tiendas_DataBase;

CREATE TABLE cliente (
	id_cliente NUMERIC (4) PRIMARY KEY,
	codigo CHAR (8),
	nombre VARCHAR (100),
	ciudad VARCHAR (50),
	dni CHAR (8),
	fecha_nacimiento CHAR (10)
);

CREATE TABLE producto (
	id_producto NUMERIC (4) PRIMARY KEY,
	codigo CHAR (8),
	descripcion VARCHAR (100),
	color VARCHAR (30),
	flg_activo NUMERIC (1)
);

CREATE TABLE empleado (
	id_empleado NUMERIC (4) PRIMARY KEY,
	dni CHAR (8),
	nombre VARCHAR (100),
	direccion VARCHAR (100),
	telefono CHAR (8),
	cod_empleado CHAR (8),
	flg_activo NUMERIC (1)
);

CREATE TABLE sucursal (
	id_sucursal NUMERIC (4) PRIMARY KEY,
	numero NUMERIC (4),
	domicilio VARCHAR (100),
	ciudad VARCHAR (50)
);

CREATE TABLE sucursal_empleado (
	id_sucursal_empl NUMERIC (4) PRIMARY KEY,
	id_sucursal NUMERIC (4),
	id_empleado NUMERIC (4),
	dia_inicio VARCHAR (20),
	dia_fin VARCHAR (20),
	hora_inicio CHAR (5),
	hora_fin CHAR (5),
	flg_activo NUMERIC (1),
	FOREIGN KEY (id_empleado) REFERENCES empleado (id_empleado),
	FOREIGN KEY (id_sucursal) REFERENCES sucursal (id_sucursal)
);

CREATE TABLE sucursal_producto (
	id_sucursal_prd NUMERIC (4) PRIMARY KEY,
	id_sucursal NUMERIC (4),
	id_producto NUMERIC (4),
	precio_venta NUMERIC (10,2),
	FOREIGN KEY (id_sucursal) REFERENCES surcursal (id_sucursal),
	FOREIGN KEY (id_producto) REFERENCES producto (id_producto)
);

CREATE TABLE venta (
	id_venta NUMERIC (4) PRIMARY KEY,
	id_cliente NUMERIC (4),
	id_sucursal_prd NUMERIC (4),
	id_empleado NUMERIC (4),
	cantidad NUMERIC (4),
	codigo_venta CHAR (8),
	fecha CHAR(10),
	hora CHAR (5),
	FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
	FOREIGN KEY (id_sucursal_prd) REFERENCES surcursal_producto (id_sucursal_prd),
	FOREIGN KEY (id_empleado) REFERENCES empleado (id_empleado)
);
-- cliente
INSERT INTO cliente VALUES (1,'CLI00001','Paolo Guerrero','Lince','44444440','14-06-1984');
INSERT INTO cliente VALUES (2,'CLI00002','Jefferson Farfan','La Victoria','44444441','14-06-1983');
INSERT INTO cliente VALUES (3,'CLI00003','Christian Cueva','Huamachuco','44444442','14-06-1985');
-- productos
INSERT INTO producto VALUES (1,'PRD00001','Jabon de tocador','blanco',1);
INSERT INTO producto VALUES (2,'PRD00002','Cepillo','azul',1);
INSERT INTO producto VALUES (3,'PRD00003','Tijera','rojo',1);
INSERT INTO producto VALUES (4,'PRD00004','Lapicero','azul',1);
INSERT INTO producto VALUES (5,'PRD00005','Cuaderno','blanco',1);
-- empleados
INSERT INTO empleado VALUES (1,'33333331','Juan Cuadrado','Medellin','5555550','EMP00001',1);
INSERT INTO empleado VALUES (2,'33333332','James Rodriguez','Bogota','5555551','EMP00002',1);
INSERT INTO empleado VALUES (3,'33333333','Rene Higuita','Cali','5555552','EMP00003',1);
-- sucursal
INSERT INTO sucursal VALUES (1,1,'Sucursal Lince','Lince');
INSERT INTO sucursal VALUES (2,2,'Sucursal Miraflores','Miraflores');
INSERT INTO sucursal VALUES (3,3,'Sucursal Surco','Surco');
-- surcursal empleado
INSERT INTO sucursal_empleado VALUES (1,1,1,'lunes','jueves','09:00','18:00',1);
INSERT INTO sucursal_empleado VALUES (2,2,1,'viernes','viernes','14:00','20:00',1);
INSERT INTO sucursal_empleado VALUES (3,2,2,'lunes','viernes','09:00','18:00',1);
INSERT INTO sucursal_empleado VALUES (4,3,3,'martes','jueves','09:00','18:00',1);
INSERT INTO sucursal_empleado VALUES (5,2,3,'lunes','lunes','10:00','19:00',0);
INSERT INTO sucursal_empleado VALUES (6,2,3,'viernes','viernes','08:00','16:00',1);
-- sucursal producto
INSERT INTO sucursal_producto VALUES (1,1,1,3.50);
INSERT INTO sucursal_producto VALUES (2,2,1,4.00);
INSERT INTO sucursal_producto VALUES (3,1,2,2.50);
INSERT INTO sucursal_producto VALUES (4,3,2,3.50);
INSERT INTO sucursal_producto VALUES (5,3,3,3.00);
-- ventas
INSERT INTO venta VALUES (1,1,1,1,2,'VEN001','06-07-2022','15:47');
INSERT INTO venta VALUES (2,2,2,2,1,'VEN002','06-07-2022','15:55');
INSERT INTO venta VALUES (3,1,1,1,3,'VEN001','06-07-2022','15:47');
INSERT INTO venta VALUES (4,3,3,3,1,'VEN003','06-07-2022','16:20');
INSERT INTO venta VALUES (5,2,2,1,4,'VEN004','06-07-2022','10:20');
-- REST
-- (1) empleado, sucursal_empleado
SELECT e.id_empleado, e.dni, e.nombre, e.cod_empleado 'codigo_empleadoprestamo', se.dia_inicio, se.dia_fin, se.hora_inicio, se.hora_fin FROM empleado e INNER JOIN sucursal_empleado se ON (e.id_empleado = se.id_empleado);
-- (2) 
INSERT INTO empleado () VALUES ()
-- (3) producto, sucursal, surcursal producto
SELECT p.descripcion, AVG(sp.precio_venta) AS precio_promedio FROM producto p INNER JOIN sucursal_producto sp ON p.id_producto = sp.id_producto WHERE p.flg_activo = 1 GROUP BY p.descripcion;
-- (4)
UPDATE..
-- (5) producto, venta, cliente, empleado, sucursal (producto - empleado)
SELECT p.codigo 'codigo_producto', p.descripcion 'desc_producto', sp.precio_venta, v.fecha, v.hora, c.codigo 'codigo_cliente', c.nombre 'nombre_cliente', c.dni 'dni_cliente', e.nombre 'nombre_empleado', e.cod_empleado 'codigo_empleado', s.domicilio 'domicilio_sucursal' FROM producto p INNER JOIN sucursal_producto sp ON (p.id_producto = sp.id_producto)
							  INNER JOIN venta v ON (sp.id_sucursal_prd = v.id_sucursal_prd)
							  INNER JOIN cliente c ON (v.id_cliente = c.id_cliente)
							  INNER JOIN empleado e ON (v.id_empleado = e.id_empleado)
							  INNER JOIN sucursal s ON (sp.id_sucursal = s.id_sucursal)
							  WHERE p.flg_activo = '1' AND e.flg_activo = '1';
							  	




