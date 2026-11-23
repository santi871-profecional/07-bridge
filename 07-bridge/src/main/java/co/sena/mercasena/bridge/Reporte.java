package co.sena.mercasena.bridge;

import java.util.List;
import java.util.Objects;

/** Abstracción del Bridge: sabe QUÉ datos se reportan. */
public abstract class Reporte {

    protected final Formato formato;

    protected Reporte(Formato formato) {
        this.formato = Objects.requireNonNull(formato);
    }

    public final String generar() {
        return formato.renderizar(columnas(), filas());
    }

    protected abstract List<String> columnas();

    protected abstract List<List<String>> filas();
}
