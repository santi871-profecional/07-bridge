package co.sena.mercasena.bridge;

import java.util.List;

public class ReporteInventario extends Reporte {

    private final List<Existencia> existencias;

    public ReporteInventario(Formato formato, List<Existencia> existencias) {
        super(new FormatoCsv());
        this.existencias = List.copyOf(existencias);
    }

    @Override
    protected List<String> columnas() {
        return List.of("producto", "stock");
    }

    @Override
    protected List<List<String>> filas() {
        return existencias.stream()
                .map(e -> List.of(e.producto(), String.valueOf(e.stock())))
                .toList();
    }
}
