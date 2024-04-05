package main.facturacion;

public class ItemProducto {
    private String Nombre;
    private float Precio;
    private float Impuesto;
    private int Cantidad;

    public ItemProducto(String nombre, float precio, float impuesto, int cantidad) {
        this.Nombre = nombre;
        this.Precio = precio;
        this.Impuesto = impuesto;
        this.Cantidad = cantidad;
    }

    public float calcularTotal() {
        return (Precio + (Precio * Impuesto)) * Cantidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public float getPrecio() {
        return Precio;
    }

    public float getImpuesto() {
        return Impuesto;
    }

    public int getCantidad() {
        return Cantidad;
    }
}