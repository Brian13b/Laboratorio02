package main.logica;

import main.descuentos.*;
import main.facturacion.*;

public class Calculador <M extends Modificador>{

    public double calcularMontoTotal(Factura<M> factura) {
        double montoTotal = 0;
        for (ItemProducto producto : factura.getListaProductos()) {
            montoTotal += producto.calcularTotal();
        }
        return montoTotal;
    }

    public Factura<M> calcularTotalFactura(Factura<M> factura) {
        double montoTotal = calcularMontoTotal(factura);
        double descuentoPorFactura = calcularDescuentoTotalPorFactura(factura);
        double descuentoPorProducto = calcularDescuentoTotalPorProducto(factura);

        double montoConDescuento = montoTotal - descuentoPorFactura - descuentoPorProducto;
        factura.setMontoTotal(montoConDescuento);

        return factura;
    }

    public double calcularDescuentoTotalPorProducto(Factura<M> factura) {
        double descuentoTotalProductos = 0;
        for (M modificador : factura.getListaModificadores()) {
            if (modificador instanceof ProductDiscount) {
                descuentoTotalProductos += modificador.applayProductDiscount();
            }
        }
        return descuentoTotalProductos;
    }

    public double calcularDescuentoTotalPorFactura(Factura<M> factura) {
        double descuentoTotalFactura = 0;
        for (M modificador : factura.getListaModificadores()) {
            if (modificador instanceof BillDiscount) {
                descuentoTotalFactura += modificador.applayBillDiscount();
            }
        }
        return descuentoTotalFactura;
    }
}
