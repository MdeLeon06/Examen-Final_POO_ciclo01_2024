create database Parcial_Final;

use Parcial_Final;

create table Clientes(
	Id_Cliente int primary key auto_increment not null,
    Nombre_Completo varchar(200) not null,
	direccion varchar(100) not null,
    telefono nvarchar(25) not null
);

create table Facilitador(
	Id_facilitador int primary key auto_increment not null,
    Facilitador varchar(70) not null
);

create table Usuarios(
	Id_Usuario int primary key auto_increment not null,
    Usuario varchar(20),
    Clave varchar(20),
    Id_Cliente int,
	index(Id_Cliente),
    foreign key (Id_Cliente) references Clientes(Id_Cliente) on delete cascade
);

create table Tarjeta(
	id_tarjeta int primary key auto_increment not null, 
    num_tarjeta varchar(20) not null,
    Fecha_Expiriacion date not null,
    Tipo_tarjeta varchar(8) not null,
    Id_Cliente int not null,
    Id_Facilitador int not null,
    index(Id_Cliente),
    index(Id_Facilitador),
    foreign key (Id_Cliente) references Clientes(Id_Cliente) on delete cascade,
    foreign key (Id_Facilitador) references Facilitador(Id_Facilitador) on delete cascade    
);

create table Transaccion (
	Id_Transaccion int primary key auto_increment not null,
	Fecha_Compra date not null, 
    Monto_Total decimal(6,2) not null,
    Descripcion text not null,
    Id_Tarjeta int not null,
    index(Id_Tarjeta),
    foreign key (Id_Tarjeta) references Tarjeta(Id_Tarjeta) on delete cascade
);

drop database parcial_final;

insert into Clientes(Nombre_Completo, direccion, telefono) value ('Eduardo Andres Siguenza', 'Prueba', '7442-1172');
insert into Tarjeta(num_tarjeta, Fecha_Expiriacion, Tipo_tarjeta, Id_Facilitador, Id_Cliente) values ('xxxx xxxx xxxx 1235', '2025-05-10', 'Credito', 1, 2), ('xxxx xxxx xxxx 1274', '2026-10-18', 'Debito', 2, 1);
insert into Facilitador(Facilitador) values ('Visa'), ('MasterCard'), ('AmericanExpress');
insert into Usuarios(Usuario, clave, Id_Cliente) values ('Eduardo', '22Oct2003', 1);
select * from Facilitador;
select * from Clientes;
select * from Clientes as c inner join Usuarios as u on c.Id_Cliente= u.Id_Cliente where usuario = 'Eduardo';