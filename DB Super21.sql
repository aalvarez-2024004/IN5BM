drop database if exists DB_Super21;
create database DB_Super21;
use DB_Super21;

create table Proveedores (
	codigoProveedor int not null auto_increment,
    nombreProveedor varchar(100) not null,
    direccionProveedor varchar(255) not null,
    telefonoProveedor varchar(20) not null,
    correoProveedor varchar(100) not null,
    primary key pk_codigoproveedor(codigoproveedor)
);

create table Productos (
    codigoProducto int not null auto_increment,
    nombreProducto varchar(100) not null,
    precio decimal(10, 2) not null,
    stock int not null,
    codigoProveedor int not null,
    primary key pk_codigoproducto(codigoproducto),
    foreign key (codigoproveedor) 
		references proveedores(codigoproveedor)  on delete cascade
);

-- Agregar 10 proveedores
delimiter $$
create procedure sp_AgregarProveedor(
    in nombreproveedor varchar(100),
    in direccionproveedor varchar(255),
    in telefonoproveedor varchar(20),
    in correoproveedor varchar(100)
)
begin
    insert into proveedores (nombreproveedor, direccionproveedor, telefonoproveedor, correoproveedor)
    values (nombreproveedor, direccionproveedor, telefonoproveedor, correoproveedor);
end $$
delimiter ;

call sp_AgregarProveedor('esencias maya', 'zona 1, ciudad de guatemala', '44982211', 'esenciasmaya@gmail.com');
call sp_AgregarProveedor('aromas del lago', 'panajachel, sololá', '50213344', 'aromas.lago@gmail.com');
call sp_AgregarProveedor('glamour gt', 'zona 10, guatemala', '56679988', 'glamour.gt@gmail.com');
call sp_AgregarProveedor('belleza natural', 'antigua guatemala', '44552233', 'bellezanaturalgt@gmail.com');
call sp_AgregarProveedor('perfumes del sur', 'chiquimula centro', '55881100', 'perfumes.sur@gmail.com');
call sp_AgregarProveedor('aromas y estilo', 'zona 3, quetzaltenango', '47001234', 'aromas.estilo@gmail.com');
call sp_AgregarProveedor('accesorios chic', 'cobán, alta verapaz', '50112233', 'accesorioschicgt@gmail.com');
call sp_AgregarProveedor('fragancias del bosque', 'san lucas sacatepéquez', '43214455', 'frag.bosque@gmail.com');
call sp_AgregarProveedor('gt glam store', 'zona 14, guatemala', '52008877', 'gtglamstore@gmail.com');
call sp_AgregarProveedor('perlas y aromas', 'escuintla', '47473366', 'perlasaromasgt@gmail.com');

-- Listar proveedores
delimiter $$
create procedure sp_ListarProveedores()
begin
    select codigoproveedor, nombreproveedor, direccionproveedor, telefonoproveedor, correoproveedor
    from proveedores;
end $$
delimiter ;

call sp_ListarProveedores();

-- Buscar proveedor
delimiter $$
create procedure sp_BuscarProveedor(
    in codigoprov int
)
begin
    select codigoproveedor, nombreproveedor, direccionproveedor, telefonoproveedor, correoproveedor
    from proveedores
    where codigoproveedor = codigoprov;
end $$
delimiter ;

call sp_BuscarProveedor(1);

-- Eliminar proveedor
delimiter $$
create procedure sp_EliminarProveedor(
    in codigoprov int
)
begin
    delete from proveedores
    where codigoproveedor = codigoprov;
end $$
delimiter ;

-- call sp_EliminarProveedor(1);

-- Editar proveedor
delimiter $$
create procedure sp_EditarProveedor(
    in codigoprov int,
    in nombreprov varchar(100),
    in direcprov varchar(255),
    in telprov varchar(20),
    in correoprov varchar(100)
)
begin
    update proveedores
    set
        nombreproveedor = nombreprov,
        direccionproveedor = direcprov,
        telefonoproveedor = telprov,
        correoproveedor = correoprov
    where codigoproveedor = codigoprov;
end $$
delimiter ;

call sp_EditarProveedor(10, 'Perlas y aromas', 'escuintla', '47473366', 'perlasaromasgt@gmail.com');
call sp_ListarProveedores();

-- Agregar productos
delimiter $$
create procedure sp_AgregarProducto(
    in nombrepro varchar(100),
    in preciopro decimal(10, 2),
    in stockpro int,
    in codigoprovee int
)
begin
    insert into productos (nombreproducto, precio, stock, codigoproveedor)
    values (nombrepro, preciopro, stockpro, codigoprovee);
end $$
delimiter ;

-- Insertar 10 productos de ejemplo
call sp_AgregarProducto('aceite de oliva extra virgen', 15.50, 50, 1);
call sp_AgregarProducto('arroz grano de oro', 8.25, 120, 2);
call sp_AgregarProducto('leche entera la vaca feliz', 3.75, 200, 3);
call sp_AgregarProducto('pan de molde', 2.50, 80, 4);
call sp_AgregarProducto('jugo de naranja natural', 6.00, 90, 5);
call sp_AgregarProducto('queso fresco', 12.00, 60, 6);
call sp_AgregarProducto('huevos de granja', 4.00, 150, 7);
call sp_AgregarProducto('café molido premium', 18.75, 75, 8);
call sp_AgregarProducto('azúcar blanca', 5.50, 110, 9);
call sp_AgregarProducto('sal refinada', 1.25, 250, 10);

-- Listar productos
delimiter $$
create procedure sp_ListarProductos()
begin
    select
        p.codigoproducto, p.nombreproducto, p.precio, p.stock, p.codigoproveedor
    from
        productos p;
end $$
delimiter ;

call sp_ListarProductos();

-- Buscar un producto
delimiter $$
create procedure sp_BuscarProducto(
    in codigoprod int
)
begin
    select
        codigoproducto, nombreproducto, precio, stock, codigoproveedor
    from
        Productos 
    where
        codigoproducto = codigoprod;
end $$
delimiter ;

call sp_BuscarProducto(1);

-- Eliminar un producto
delimiter $$
create procedure sp_EliminarProducto(
    in codigoprod int
)
begin
    delete from Productos
    where codigoproducto = codigoprod;
end $$
delimiter ;

-- call sp_EliminarProducto(1);

-- Editar un producto
delimiter $$
create procedure sp_EditarProducto(
    in codigoprod int,
    in nombrepro varchar(100),
    in preciopro decimal(10, 2),
    in stockpro int,
    in codigoprovee int
)
begin
    update productos
    set
        nombreproducto = nombrepro,
        precio = preciopro,
        stock = stockpro,
        codigoproveedor = codigoprovee
    where codigoproducto = codigoprod;
end $$
delimiter ;
-- 