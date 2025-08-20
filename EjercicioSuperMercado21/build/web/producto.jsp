<%-- 
    Document   : producto
    Created on : 19/08/2025, 16:15:02
    Author     : Adrian
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Essenza | Gestión de Productos</title>
        <link rel="stylesheet" href="Styles/producto.css" />
    </head>
    <body>
        <div class="contenedor-principal">
            <div class="form-container">
                <h2>Gestión de Productos</h2>
                <form action="Controlador?menu=Producto" method="POST" class="formulario">
                    <input type="text" value="${producto.getCodigoProducto()}" name="txtCodigoProducto" placeholder="ID" readonly />
                    <input type="text" value="${producto.getNombreProducto()}" name="txtNombreProducto" placeholder="Nombre" required />
                    <input type="number" step="0.01" value="${producto.getPrecio()}" name="txtPrecio" placeholder="Precio" required />
                    <input type="number" value="${producto.getStock()}" name="txtStock" placeholder="Stock" required />

                    <!-- Select de proveedores -->
                    <select name="txtCodigoProveedor" required>
                        <c:forEach var="prov" items="${proveedores}">
                            <option value="${prov.codigoProveedor}" 
                        <c:if test="${producto.codigoProveedor == prov.codigoProveedor}">selected</c:if>>
                            ${prov.nombreProveedor}
                        </option>
                    </c:forEach>
                </select>

                <div class="botones">
                    <button type="submit" name="accion" value="Agregar">Agregar</button>
                    <button type="submit" name="accion" value="Actualizar">Actualizar</button>
                </div>
            </form>
                <div class="marca-interna">
                    SUPER21 - 2024004
                </div>
        </div>

        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Stock</th>
                        <th>Proveedor</th>
                        <th>Editar</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="prod" items="${productos}">
                    <tr>
                        <td>${prod.codigoProducto}</td>
                        <td>${prod.nombreProducto}</td>
                        <td>${prod.precio}</td>
                        <td>${prod.stock}</td>
                        <td>${prod.codigoProveedor}</td>
                        <td>
                            <a href="Controlador?menu=Producto&accion=Editar&codigoProducto=${prod.codigoProducto}" 
                               class="btn btn-editar">Editar</a>
                        </td>
                        <td>
                            <a href="Controlador?menu=Producto&accion=Eliminar&codigoProducto=${prod.codigoProducto}" 
                               class="btn btn-eliminar">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>

