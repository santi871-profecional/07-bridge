package co.sena.mercasena.bridge;

import java.util.List;

/** Implementador del Bridge: sabe CÓMO escribir una tabla. */
public interface Formato {

    String renderizar(List<String> columnas, List<List<String>> filas);
}
