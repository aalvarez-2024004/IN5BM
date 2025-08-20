package Modelo;

public class Producto {
    private int codigoProducto;
    private String nombreProducto;
    private double precio;
    private int stock;
    private int codigoProveedor; // FK hacia proveedor

    public Producto() {}

    public Producto(String nombreProducto, double precio, int stock, int codigoProveedor) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.stock = stock;
        this.codigoProveedor = codigoProveedor;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }
    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }
    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }
}
