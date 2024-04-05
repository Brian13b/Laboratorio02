package main.descuentos;

import main.facturacion.ItemProducto;

public class ProductDiscount extends Modificador{

	private ItemProducto refProducto;

	public ProductDiscount(String nombreDescuento, float porcentaje, ItemProducto refProducto) {
		super(nombreDescuento, porcentaje);
		this.refProducto = refProducto;
	}

	public ItemProducto getRefProducto() {
		return refProducto;
	}

	@Override
	public double applayProductDiscount() {
		double descuento = (refProducto.getPrecio() * porcentaje) * refProducto.getCantidad();
        return descuento;
	}

	@Override
	public double applayBillDiscount() {
		return 0;
	}
}
