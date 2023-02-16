create database IF NOT EXISTS dgt;

create table infractores (
      dni VARCHAR(9) PRIMARY KEY,
      nombre VARCHAR(15),
      apellidos VARCHAR(30),
      antiguedad smallint,
      sancion float,
      puntos smallint);
      
insert into infractores (dni, nombre, apellidos, antiguedad, sancion, puntos) 
values ('30000000A', 'Ana', 'López', 5, 200, 8),
       ('31111111G', 'Pedro', 'Sánchez', 14, 500, 10),
       ('32323232P', 'Juan', 'Martos', 8, 300, 14),
       ('44457454S', 'Marta', 'Peña', 20, 100, 9),
       ('36534567T', 'María', 'Marín', 1, 100, 13),
       ('367675655N', 'Luis', 'González', 3, 300, 1),
       ('484565661K', 'Sonia', 'Tena', 11, 200, 12);
       
      
create table sanciones (
      idSancion smallint primary key auto_increment,
      descripcion varchar(30),
      importe float);
      
insert into sanciones (descripcion, importe)
values ('No llevar casco', 200),
       ('Conduccion temararia',500),
       ('No llevar cinturón', 200),
       ('Tirar una colilla', 150),
       ('Tasa de alcohol superior a 0.60', 500),
       ('No hacer le stop', 250);
      
      