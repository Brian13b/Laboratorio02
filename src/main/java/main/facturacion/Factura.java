package main.facturacion;

import java.util.List;

import main.descuentos.Modificador;

public class Factura<T extends Modificador> {

    private double montoTotal = 0.0;
    private List<T> listaModificadores;
    private List<ItemProducto> listaProductos;
    
    public Factura(List<T> listaModificadores, List<ItemProducto> listaProductos) {
        this.listaModificadores = listaModificadores;
        this.listaProductos = listaProductos;
        calcularMontoTotal();
    }

    private void calcularMontoTotal() {
        for (ItemProducto producto : listaProductos) {
            montoTotal += producto.calcularTotal(); 
        }
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public List<T> getListaModificadores() {
        return listaModificadores;
    }

    public List<ItemProducto> getListaProductos() {
        return listaProductos;
    }
}
