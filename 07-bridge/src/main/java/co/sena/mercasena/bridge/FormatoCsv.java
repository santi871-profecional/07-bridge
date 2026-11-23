package co.sena.mercasena.bridge;

import java.util.List;
import java.util.stream.Collectors;

public class FormatoCsv implements Formato {

    @Override
    public String renderizar(List<String> columnas, List<List<String>> filas) {
        StringBuilder sb = new StringBuilder(linea(columnas));
        for (List<String> fila : filas) {
            sb.append('\n').append(linea(fila));
        }
        return sb.toString();
    }

    private static String linea(List<String> valores) {
        return valores.stream().map(FormatoCsv::escapar).collect(Collectors.joining(","));
    }

    static String escapar(String valor) {
        return valor;
    }
}
