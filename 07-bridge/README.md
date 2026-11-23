# MercaSENA · Patrón Bridge (Estructural)

**Dominio:** Reportes de ventas e inventario en CSV y JSON

## Contexto

La gerencia de MercaSENA pide reportes de **ventas** y de **inventario**, y los quiere en **CSV** (para Excel) y en **JSON** (para el *frontend* en Angular). Sin un patrón, eso exigiría cuatro clases (ventas-CSV, ventas-JSON, inventario-CSV, inventario-JSON), y cada nuevo reporte o formato multiplicaría el número de clases. Con **Bridge** se separa **qué** se reporta (la abstracción `Reporte`) de **cómo** se escribe (la implementación `Formato`).

Clases principales:

- `Reporte` (abstracción), con sus subclases `ReporteVentas` y `ReporteInventario`.
- `Formato` (implementador), con sus implementaciones `FormatoCsv` y `FormatoJson`.

## Reglas de negocio

1. **Todos** los reportes deben usar el formato que reciben en el constructor.
2. **CSV:** la primera línea tiene los encabezados y cada fila va en una línea separada por `\n`. Si un valor contiene una coma, comillas dobles o un salto de línea, va entre comillas dobles, y las comillas internas se duplican. Por ejemplo, `Café, 500 g` se escribe `"Café, 500 g"` y `Arroz "Premium"` se escribe `"Arroz ""Premium"""`.
3. **JSON:** el reporte es un arreglo de objetos con todos los valores como texto, por ejemplo `[{"producto":"Café","stock":"12"}]`. Las comillas y las barras invertidas dentro de los valores se escapan con `\`. El resultado siempre debe ser JSON válido.
4. Un reporte sin datos produce solo los encabezados en CSV y `[]` en JSON.

## Tu misión

Este proyecto implementa el patrón **Bridge** dentro de la tienda en línea **MercaSENA**. El código *compila*, pero tiene **errores sembrados**: algunos los detectan las pruebas que ya existen y otros **no**. Tu trabajo es encontrarlos todos, demostrarlos con pruebas y corregirlos con ayuda de la IA, sin perder el control técnico.

> La fuente de verdad son las **reglas de negocio** de este README. La IA no las conoce si no se las das.

## Protocolo de trabajo (obligatorio)

1. **Prepara el repositorio.** Crea un repositorio en GitHub con este proyecto y haz el primer commit sin cambios: `git commit -m "chore: estado inicial"`.
2. **Predice sin IA (20 min).** Lee este README y el código. Escribe tus hipótesis en `BITACORA_IA.md`, sección 1.
3. **Ejecuta las pruebas.** Corre `mvn test` o las pruebas desde IntelliJ / Eclipse. Anota cuáles fallan.
4. **Demuestra cada error con una prueba.** Por cada error que encuentres, incluidos los que las pruebas actuales no detectan, escribe primero una prueba que **falle**. Haz commit: `test: demuestra <error>`.
5. **Consulta al jurado de IAs.** Envía el mismo prompt a ChatGPT, Gemini y DeepSeek. Usa el prompt de 5 piezas: contexto, tarea, restricciones, formato y criterio de verificación. Registra en la bitácora en qué coincidieron y en qué no.
6. **Corrige.** Aplica la corrección que **tú** entiendes y puedes explicar. La prueba debe pasar. Haz commit: `fix: corrige <error>`.
7. **Refactoriza con IA.** Pide a la IA una mejora de legibilidad que no cambie el comportamiento. Todas las pruebas deben seguir en verde. Haz commit: `refactor: ...`.
8. **Revisa la seguridad.** Pregúntate qué podría hacer un usuario malicioso con este código y anota tu respuesta en la bitácora.
9. **Prepara la defensa.** El instructor te pedirá explicar, **sin IA**, cualquier línea que hayas cambiado.

## Cómo ejecutar

```bash
mvn test
```

Requisitos: JDK 17 o superior y Maven 3.9 o superior, o el Maven que trae IntelliJ IDEA o Eclipse.

## Qué NO hacer

- No borres ni debilites pruebas para que pasen.
- No pegues el proyecto completo en una IA sin explicarle las reglas de negocio.
- No aceptes una corrección que no sabes explicar.

## Referencia del patrón

- https://refactoring.guru/es/design-patterns/bridge
