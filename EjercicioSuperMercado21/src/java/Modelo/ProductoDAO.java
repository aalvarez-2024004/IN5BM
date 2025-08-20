package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    // Listar todos los productos
    public List<Producto> listar() {
        String sql = "call sp_ListarProductos()";
        List<Producto> listaProducto = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setCodigoProducto(rs.getInt(1));
                p.setNombreProducto(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setCodigoProveedor(rs.getInt(5));
                listaProducto.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProducto;
    }

    // Agregar producto
    public int agregar(Producto p) {
        String sql = "call sp_AgregarProducto(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombreProducto());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setInt(4, p.getCodigoProveedor());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    // Actualizar producto
    public int actualizar(Producto p) {
        String sql = "call sp_EditarProducto(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getCodigoProducto());
            ps.setString(2, p.getNombreProducto());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getStock());
            ps.setInt(5, p.getCodigoProveedor());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    // Eliminar producto
    public void eliminar(int id) {
        String sql = "call sp_EliminarProducto(?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Buscar producto por id
    public Producto listarCodigoProducto(int id) {
        Producto p = new Producto();
        String sql = "call sp_BuscarProducto(?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                p.setCodigoProducto(rs.getInt(1));
                p.setNombreProducto(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setCodigoProveedor(rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}
