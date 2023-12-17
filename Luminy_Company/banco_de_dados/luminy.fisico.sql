CREATE DATABASE luminy_company;

USE luminy_company;

CREATE TABLE Clientes (
    id_cliente INTEGER PRIMARY KEY auto_increment,
    nome_cliente VARCHAR(40),
    email_cliente VARCHAR(80),
    senha_cliente VARCHAR(10)
);

CREATE TABLE Passagem (
    id_passagem INTEGER PRIMARY KEY auto_increment,
    destino_passagem VARCHAR(40),
    preco_passagem DECIMAL(10,2)
);

CREATE TABLE Compras (
	id_compra INTEGER  PRIMARY KEY auto_increment,
    data_compras VARCHAR(40),
    id_clientes INTEGER,
    id_passagem INTEGER,
    total_compra DECIMAL(10,2),
    FOREIGN KEY (id_passagem) REFERENCES Passagem (id_passagem),
    FOREIGN KEY (id_clientes) REFERENCES Clientes (id_cliente)
);

CREATE VIEW cliente_passagem AS
select c.id_compra, c.data_compras, c.total_compra, p.*, u.* 
from compras c, passagem p, clientes u 
where c.id_passagem = p.id_passagem and c.id_clientes = u.id_cliente;

insert into Clientes values 
(null, 'Laiane', 'laiane@hotmail.com', 123 );
insert into Clientes values 
(null, 'Aline', 'aline@hotmail.com', 456 );

insert into Passagem values 
(null, 'Fortaleza', 1400.0 );
insert into Passagem values 
(null, 'Rio Grande do Sul', 1700.0 );

insert into Compras values 
(null, '30/09/2023', 1, 1, 1400.00 );
 
 select * from Clientes;
 select * from Passagem;
 select * from Compras;
 select * from Compras;
 select * from Compras C, Passagem P, Clientes Cl where C.id_passagem = P.id_passagem and Cl.id_cliente;

-- select C.id_compra, C.data_compra, P.*, Cl.*, sum(P.preco_passagem + 2.0) from Compras C, Passagem P, Clientes Cl where C.id_passagem = P.id_passagem and Cl.id_cliente;

UPDATE Clientes SET nome_cliente = 'Laiane Oliveira', email_cliente ='laiane@hotmail.com', senha_cliente ='123' WHERE id_cliente = 1;
UPDATE Passagem SET destino_passagem ='Fortaleza'  WHERE id_passagem = 1;
UPDATE Compras SET data_compra ='30/09/2023', total_compra = 1400.0, id_passagem = 1, id_cliente = 1 WHERE id_compra= 1;

DELETE FROM Clientes WHERE id_cliente = 1;
DELETE FROM Passagem WHERE id_passagem = 1;
DELETE FROM Compras WHERE id_compra = 1;

alter table Passagem modify preco_passagem decimal(10,2);

select c.id_compra, c.data_compras, c.total_compra, p.*, u.* 
from compras c, passagem p, clientes u 
where c.id_passagem = p.id_passagem and c.id_clientes = u.id_cliente;