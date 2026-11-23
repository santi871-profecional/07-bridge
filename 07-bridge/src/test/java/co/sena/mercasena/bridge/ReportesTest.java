package co.sena.mercasena.bridge;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReportesTest {

    private final List<Venta> ventas = List.of(new Venta("Café", 2, new BigDecimal("36000")));
    private final List<Existencia> inventario = List.of(new Existencia("Panela", 12));

    @Test
    void ventasEnCsv() {
        assertEquals("producto,cantidad,total\nCafé,2,36000", new ReporteVentas(new FormatoCsv(), ventas).generar());
    }

    @Test
    void ventasEnJson() {
        assertEquals("[{\"producto\":\"Café\",\"cantidad\":\"2\",\"total\":\"36000\"}]",
                new ReporteVentas(new FormatoJson(), ventas).generar());
    }

    @Test
    void inventarioEnJson() {
        assertEquals("[{\"producto\":\"Panela\",\"stock\":\"12\"}]",
                new ReporteInventario(new FormatoJson(), inventario).generar());
    }

    @Test
    void reporteVacio() {
        assertEquals("[]", new ReporteVentas(new FormatoJson(), List.of()).generar());
        assertEquals("producto,stock", new ReporteInventario(new FormatoCsv(), List.of()).generar());
    }
}
