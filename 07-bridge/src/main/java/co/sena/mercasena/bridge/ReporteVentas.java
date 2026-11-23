package co.sena.mercasena.bridge;

import java.util.List;

public class ReporteVentas extends Reporte {

    private final List<Venta> ventas;

    public ReporteVentas(Formato formato, List<Venta> ventas) {
        super(formato);
        this.ventas = List.copyOf(ventas);
    }

    @Override
    protected List<String> columnas() {
        return List.of("producto", "cantidad", "total");
    }

    @Override
    protected List<List<String>> filas() {
        return ventas.stream()
                .map(v -> List.of(v.producto(), String.valueOf(v.cantidad()), v.total().toPlainString()))
                .toList();
    }
}
