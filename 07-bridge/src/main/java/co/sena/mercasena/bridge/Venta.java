package co.sena.mercasena.bridge;

import java.math.BigDecimal;

public record Venta(String producto, int cantidad, BigDecimal total) {
}
