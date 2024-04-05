package main.logica;

import java.util.ArrayList;
import java.util.List;

import main.descuentos.*;
import main.facturacion.Factura;
import main.facturacion.ItemProducto;

public class Principal {

	public static void main(String[] args) {
		
		Caso01();
		//Caso02();
		//Caso03();

	}
	
	private static void Caso01() {
	    ItemProducto bicicleta = new ItemProducto("Bicicleta", 780000, 0.21f, 1);
	    ItemProducto vaporera = new ItemProducto("Vaporera", 94000, 0.105f, 3);

	    List<ItemProducto> listaProductos = new ArrayList<>();
	    listaProductos.add(bicicleta);
	    listaProductos.add(vaporera);

	    List<Modificador> listaModificadores = new ArrayList<>();
	    listaModificadores.add(new ProductDiscount("Descuento Bicicleta", 0.05f, bicicleta));
	    listaModificadores.add(new ProductDiscount("Descuento Vaporera", 0.03f, vaporera));
	    
	    Factura<Modificador> factura = new Factura<>(listaModificadores, listaProductos);
	    
	    listaModificadores.add(new BillDiscount("Descuento Factura", 0, 10000, factura));

	    Calculador<Modificador> calculador = new Calculador<>();

	    factura = calculador.calcularTotalFactura(factura);

	    System.out.println("Producto\tMonto\t\tImpuesto\tDescuento\tCantidad\tTotal");
	    double descuentoProducto = calculador.calcularDescuentoTotalPorProducto(factura);
	    for (ItemProducto producto : factura.getListaProductos()) {
	        double totalProducto = producto.calcularTotal();
	        System.out.printf("%s\t%.2f\t%.2f\t\t%.2f\t%d\t\t%.2f\n", producto.getNombre(), producto.getPrecio(),
	                producto.getImpuesto(), descuentoProducto, producto.getCantidad(), totalProducto);
	    }
	    System.out.println();
	    System.out.printf("Descuento total en productos:\t$ %.2f\n", descuentoProducto);
	    System.out.println();

	    double totalAntesDescuentos = calculador.calcularMontoTotal(factura) - descuentoProducto;
	    double totalDespuesDescuentos = factura.getMontoTotal(); 
	    System.out.printf("Total antes de descuento:\t$ %.2f\n", totalAntesDescuentos);
	    System.out.printf("Descuento aplicado a la factura:\tMonto Fijo\t%.2f\t\t%.2f\n", 10000.0, -10000.0);
	    System.out.printf("\t\t\t\t\tPorcentaje\t%.2f%%\t\t\t%.2f\n", 0.0, -0.0);
	    System.out.printf("Total después de descuento:\t$ %.2f\n", totalDespuesDescuentos);
	}


	/*
	private static void Caso02() {
	    
	}

	private static void Caso03() {
	    
	}
*/
}
