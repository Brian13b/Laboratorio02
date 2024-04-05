package main.descuentos;

import main.facturacion.Factura;

public class BillDiscount extends Modificador {

	protected float montoFijo;
	private Factura<Modificador> factura;
	
	public BillDiscount(String nombreDescuento, float porcentaje, float montoFijo, Factura<Modificador> factura) {
		super(nombreDescuento, porcentaje);
		this.montoFijo = montoFijo;
		this.factura = factura;
	}

	public Factura<Modificador> getFactura() {
		return factura;
	}

	@Override
	public double applayProductDiscount() {
	    return 0;
	}

	@Override
	public double applayBillDiscount() {
        double descuento = 0;
        descuento = montoFijo;
        descuento += (factura.getMontoTotal() * porcentaje);
        return descuento;
    }
}
