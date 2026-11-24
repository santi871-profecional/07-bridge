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
    StringBuilder sb = new StringBuilder("\"");

    for (char c : valor.toCharArray()) {
        switch (c) {
            case '"' -> sb.append("\\\"");
            case '\\' -> sb.append("\\\\");
            case '\n' -> sb.append("\\n");
            case '\r' -> sb.append("\\r");
            case '\t' -> sb.append("\\t");
            case '\b' -> sb.append("\\b");
            case '\f' -> sb.append("\\f");
            default -> {
                if (c < 32) {
                    sb.append(String.format("\\u%04x", (int) c));
                } else {
                    sb.append(c);
                }
            }
        }
    }

    return sb.append("\"").toString();
}
}
