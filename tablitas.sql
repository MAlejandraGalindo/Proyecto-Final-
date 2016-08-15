--create table producto(id integer primary key auto_increment,
--nombre varchar(30),precio float);



--select * from producto;
--select * from departamento;
--select * from empleado_x;

--CREAMOS LA TABLA DEPARTAMENTO QUE EXISTE SIN QUE EXISTAN EMPLEADOS
--create table departamento(id integer primary key auto_increment, nombre varchar(40));
--create table empleado_x(id integer primary key auto_increment, id_departamento integer, nombre varchar(80), foreign key(id_departamento) references departamento(id));


create table especialidades(id integer primary key auto_increment, nombre varchar(40), 
area varchar(40), hospital varchar(40));

create table doctores(id integer primary key auto_increment, id_especialidad integer, 
nombre varchar(80),cedula varchar(40),telefono varchar(40), direccion varchar(40), 
foreign key(id_especialidad) references especialidades(id));

select * from especialidades;
select * from doctores;