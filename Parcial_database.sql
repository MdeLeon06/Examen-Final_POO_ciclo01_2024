create database Parcial_Final;

use Parcial_Final;

create table Clientes(
	Id_Cliente int primary key auto_increment not null,
    Nombre_Completo varchar(200) not null,
	direccion varchar(100) not null,
    telefono nvarchar(25) not null	
);

create table Tarjeta(
	id_tarjeta int primary key not null, 
    num_tarjeta varchar(20) not null,
    Fecha_Expiracion date not null,
    Tipo_tarjeta varchar(8) not null,
    Facilitador varchar(70) not null,
    Id_Cliente int not null,
    index(Id_Cliente),
    foreign key (Id_Cliente) references Clientes(Id_Cliente) on delete cascade
);

create table Transaccion (
	Id_Transaccion int primary key not null,
	Fecha_Compra date not null, 
    Monto_Total decimal(6,2) not null,
    Descripcion text not null,
    Id_Tarjeta int not null,
    index(Id_Tarjeta),
    foreign key (Id_Tarjeta) references Tarjeta(Id_Tarjeta) on delete cascade
);

-- Inserciones para la tabla Clientes
insert into Clientes (Nombre_Completo, direccion, telefono) values ('Juan Perez', 'Calle Falsa 123', '555-1234');
insert into Clientes (Nombre_Completo, direccion, telefono) values ('Maria Lopez', 'Avenida Siempreviva 456', '555-5678');
insert into Clientes (Nombre_Completo, direccion, telefono) values ('Carlos Garcia', 'Boulevard de los Sueños 789', '555-8765');
insert into Clientes (Nombre_Completo, direccion, telefono) values ('Ana Martinez', 'Calle de la Paz 321', '555-4321');
insert into Clientes (Nombre_Completo, direccion, telefono) values ('Luis Rodriguez', 'Avenida del Sol 654', '555-6789');

-- Inserciones para la tabla Tarjeta
insert into Tarjeta (Id_Tarjeta, num_tarjeta, Fecha_Expiracion, Tipo_tarjeta, Facilitador, Id_Cliente) values (1, '1234-5678-9012-3456', '2024-12-31', 'VISA', 'Banco A', 1);
insert into Tarjeta (Id_Tarjeta, num_tarjeta, Fecha_Expiracion, Tipo_tarjeta, Facilitador, Id_Cliente) values (2, '2345-6789-0123-4567', '2025-11-30', 'MC', 'Banco B', 2);
insert into Tarjeta (Id_Tarjeta, num_tarjeta, Fecha_Expiracion, Tipo_tarjeta, Facilitador, Id_Cliente) values (3, '3456-7890-1234-5678', '2026-10-31', 'VISA', 'Banco C', 3);
insert into Tarjeta (Id_Tarjeta, num_tarjeta, Fecha_Expiracion, Tipo_tarjeta, Facilitador, Id_Cliente) values (4, '4567-8901-2345-6789', '2027-09-30', 'MC', 'Banco D', 4);
insert into Tarjeta (Id_Tarjeta, num_tarjeta, Fecha_Expiracion, Tipo_tarjeta, Facilitador, Id_Cliente) values (5, '5678-9012-3456-7890', '2028-08-31', 'VISA', 'Banco E', 5);

-- Inserciones para la tabla Transaccion
insert into Transaccion (Id_Transaccion, Fecha_Compra, Monto_Total, Descripcion, Id_Tarjeta) values (1, '2024-01-01', 100.00, 'Compra en tienda A', 1);
insert into Transaccion (Id_Transaccion, Fecha_Compra, Monto_Total, Descripcion, Id_Tarjeta) values (2, '2024-02-01', 150.50, 'Compra en tienda B', 2);
insert into Transaccion (Id_Transaccion, Fecha_Compra, Monto_Total, Descripcion, Id_Tarjeta) values (3, '2024-03-01', 200.75, 'Compra en tienda C', 3);
insert into Transaccion (Id_Transaccion, Fecha_Compra, Monto_Total, Descripcion, Id_Tarjeta) values (4, '2024-04-01', 250.00, 'Compra en tienda D', 4);
insert into Transaccion (Id_Transaccion, Fecha_Compra, Monto_Total, Descripcion, Id_Tarjeta) values (5, '2024-05-01', 300.25, 'Compra en tienda E', 5);