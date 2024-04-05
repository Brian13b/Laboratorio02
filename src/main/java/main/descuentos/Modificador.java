package main.descuentos;

public abstract class Modificador {
	
	protected String nombreDescuento;
	protected float porcentaje;
	
	public Modificador(String nombreDescuento, float porcentaje) {
		this.nombreDescuento = nombreDescuento;
		this.porcentaje = porcentaje;
	}

	public String getNombreDescuento() {
		return nombreDescuento;
	}

	public float getPorcentaje() {
		return porcentaje;
	}
	
	public abstract double applayProductDiscount();
	
	public abstract double applayBillDiscount();

}
