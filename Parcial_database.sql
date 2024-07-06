create database Parcial_Final;

use Parcial_Final;

create table Clientes(
	Ic_Cliente int primary key auto_increment not null,
    Nombre_Completo varchar(200) not null,
	direccion varchar(100) not null,
    telefono nvarchar(25) not null	
);

create table Tarjeta(
	id_tarjeta int primary key not null, 
    num_tarjeta varchar(20) not null,
    Fecha_Expiriacion date not null,
    Tipo_tarjeta varchar(8) not null,
    Facilitador varchar(70) not null,
    Id_Cliente int not null,
    index(Id_Cliente),
    foreign key (Id_Cliente) references Cliente(Id_Cliente) on delete cascade
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