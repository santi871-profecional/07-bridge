package co.sena.mercasena.bridge;

import java.util.ArrayList;
import java.util.List;

public class FormatoJson implements Formato {

    @Override
    public String renderizar(List<String> columnas, List<List<String>> filas) {
        List<String> objetos = new ArrayList<>();
        for (List<String> fila : filas) {
            List<String> pares = new ArrayList<>();
            for (int i = 0; i < columnas.size(); i++) {
                pares.add(texto(columnas.get(i)) + ":" + texto(fila.get(i)));
            }
            objetos.add("{" + String.join(",", pares) + "}");
        }
        return "[" + String.join(",", objetos) + "]";
    }

    static String texto(String valor) {
        return "\"" + valor + "\"";
    }
}
