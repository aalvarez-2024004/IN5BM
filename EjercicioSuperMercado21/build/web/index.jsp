<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Super21 Administrador</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="Styles/index.css">
    </head>
    <body>

        <nav>
            <a href="#">SUPER21</a>
            <ul>
                <li><a href="Controlador?menu=Proveedor&accion=Listar" target="contenido">Proveedores</a></li>
                <li><a href="Controlador?menu=Producto&accion=Listar" target="contenido">Productos</a></li>
            </ul>
        </nav>
        
        <div class="panel">
            <h2>Bienvenido, estas administrando SUPER21!</h2>
        </div>

        <!-- Carrusel -->
        <div class="carousel-container">
            <div id="carouselSuper21" class="carousel slide rounded" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselSuper21" data-bs-slide-to="0" class="active"></button>
                    <button type="button" data-bs-target="#carouselSuper21" data-bs-slide-to="1"></button>
                    <button type="button" data-bs-target="#carouselSuper21" data-bs-slide-to="2"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="img/Super211.jpg" class="d-block w-100 carousel-img" alt="Supermercado 1">
                    </div>
                    <div class="carousel-item">
                        <img src="img/Super212.jpg" class="d-block w-100 carousel-img" alt="Supermercado 2">
                    </div>
                    <div class="carousel-item">
                        <img src="img/Super213.jpg" class="d-block w-100 carousel-img" alt="Supermercado 3">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselSuper21" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselSuper21" data-bs-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </button>
            </div>
        </div>

        <!-- iframe -->
        <div class="contenido">
            <iframe name="contenido"></iframe>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
