/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    Proveedor proveedor = new Proveedor();
    ProveedorDAO proveedorDAO = new ProveedorDAO();
    
    Producto producto = new Producto();
    ProductoDAO productoDAO = new ProductoDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }
        
        if (menu!=null) {
            switch (menu) {
                case "Proveedor":
                    switch (accion) {
                        case "Listar":
                            List listaProveedores = proveedorDAO.listar();
                            request.setAttribute("proveedores", listaProveedores);
                            break;
                        case "Agregar":
                            String nombreProveedor = request.getParameter("txtNombreProveedor");
                            String direccionProveedor = request.getParameter("txtDireccionProveedor");
                            String telefonoProveedor = request.getParameter("txtTelefonoProveedor");
                            String correoProveedor = request.getParameter("txtCorreoProveedor");

                            proveedor.setNombreProveedor(nombreProveedor);
                            proveedor.setDireccionProveedor(direccionProveedor);
                            proveedor.setTelefonoProveedor(telefonoProveedor);
                            proveedor.setCorreoProveedor(correoProveedor);

                            proveedorDAO.agregar(proveedor);
                            request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                            
                            break;
                        case "Editar":
                            int codProveedor = Integer.parseInt(request.getParameter("codigoProveedor"));
                            Proveedor p = proveedorDAO.listarCodigoProveedor(codProveedor);
                            request.setAttribute("proveedor", p);

                            List listaProveedoresEditar = proveedorDAO.listar();
                            request.setAttribute("proveedores", listaProveedoresEditar);

                            request.getRequestDispatcher("proveedor.jsp").forward(request, response);
                            
                            break;
                        case "Actualizar":
                            int codProveedorActualizar = Integer.parseInt(request.getParameter("txtCodigoProveedor"));
                            nombreProveedor = request.getParameter("txtNombreProveedor");
                            direccionProveedor = request.getParameter("txtDireccionProveedor");
                            telefonoProveedor = request.getParameter("txtTelefonoProveedor");
                            correoProveedor = request.getParameter("txtCorreoProveedor");

                            proveedor.setCodigoProveedor(codProveedorActualizar);
                            proveedor.setNombreProveedor(nombreProveedor);
                            proveedor.setDireccionProveedor(direccionProveedor);
                            proveedor.setTelefonoProveedor(telefonoProveedor);
                            proveedor.setCorreoProveedor(correoProveedor);

                            proveedorDAO.actualizar(proveedor);
                            request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                            
                            break;
                        case "Eliminar":
                            codProveedor = Integer.parseInt(request.getParameter("codigoProveedor"));

                            proveedorDAO.eliminar(codProveedor);

                            request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                            
                            break;
                        default:
                            throw new AssertionError();
                    }
                    request.getRequestDispatcher("proveedor.jsp").forward(request, response);
                    break;
                    
                case "Producto":
                    switch (accion) {
                        case "Listar":
                            List listaProductos = productoDAO.listar();
                            request.setAttribute("productos", listaProductos);

                            // Necesitamos lista de proveedores para llenar el <select>
                            List listaProveedores = proveedorDAO.listar();
                            request.setAttribute("proveedores", listaProveedores);
                            break;
                            
                        case "Agregar":
                            String nombreProducto = request.getParameter("txtNombreProducto");
                            double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                            int stock = Integer.parseInt(request.getParameter("txtStock"));
                            int codigoProv = Integer.parseInt(request.getParameter("txtCodigoProveedor"));

                            producto.setNombreProducto(nombreProducto);
                            producto.setPrecio(precio);
                            producto.setStock(stock);
                            producto.setCodigoProveedor(codigoProv);

                            productoDAO.agregar(producto);
                            request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                            break;
                            
                        case "Editar":
                            int codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                            Producto prod = productoDAO.listarCodigoProducto(codProducto);
                            request.setAttribute("producto", prod);

                            // Re-listar productos y proveedores
                            listaProductos = productoDAO.listar();
                            request.setAttribute("productos", listaProductos);
                            listaProveedores = proveedorDAO.listar();
                            request.setAttribute("proveedores", listaProveedores);

                            request.getRequestDispatcher("producto.jsp").forward(request, response);
                            break;
                            
                        case "Actualizar":
                            int codProductoUpd = Integer.parseInt(request.getParameter("txtCodigoProducto"));
                            nombreProducto = request.getParameter("txtNombreProducto");
                            precio = Double.parseDouble(request.getParameter("txtPrecio"));
                            stock = Integer.parseInt(request.getParameter("txtStock"));
                            codigoProv = Integer.parseInt(request.getParameter("txtCodigoProveedor"));

                            producto.setCodigoProducto(codProductoUpd);
                            producto.setNombreProducto(nombreProducto);
                            producto.setPrecio(precio);
                            producto.setStock(stock);
                            producto.setCodigoProveedor(codigoProv);

                            productoDAO.actualizar(producto);
                            request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                            break;
                            
                        case "Eliminar":
                            codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                            productoDAO.eliminar(codProducto);
                            request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    request.getRequestDispatcher("producto.jsp").forward(request, response); 
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
