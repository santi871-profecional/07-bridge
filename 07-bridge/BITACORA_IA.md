# Bitácora de uso de IA — Patrón Bridge

Aprendices: santiago castro castaño 
Ficha: 3409871  Fecha de inicio: 23/11/2026

> La bitácora es evidencia del ítem 18 de la lista de chequeo. Regístralo **todo**, también las respuestas de la IA que estaban mal.
> Nunca pegues en una IA contraseñas, tokens, datos personales reales ni código que no tengas permiso de compartir.

## 1. Predicción sin IA (máx. 20 minutos)

Antes de abrir cualquier IA, lee el README y el código. Escribe aquí qué errores crees que hay y por qué.

| # | Archivo y línea | ¿Qué creo que está mal? | ¿Qué regla de negocio rompe? |
|---|---|---|---|
| 1 |FormatoCsv.java – método escapar() |Creo que el método no está escapando los valores que contienen comas, comillas dobles o saltos de línea. Actualmente devuelve el texto sin realizar ninguna modificación. |Regla 2: Los valores especiales deben ir entre comillas y las comillas internas deben duplicarse |
| 2 |FormatoJson.java – método texto() |Creo que no se están escapando correctamente las comillas dobles ni las barras invertidas de los textos. Esto puede provocar que el JSON generado sea inválido. | Regla 3: El resultado siempre debe ser un JSON válido y los caracteres especiales deben escaparse|
| 3 |ReporteInventario.java – constructor |Observé que recibe un formato por parámetro, pero al llamar al constructor padre utiliza new FormatoCsv() en lugar del formato recibido. Esto significa que siempre genera CSV, aunque se solicite JSON. |Regla 1: Todos los reportes deben utilizar el formato que reciben en el constructor. |

## 2. Registro de interacciones con IA

Copia una fila por cada consulta importante.

| # | Herramienta (ChatGPT / Gemini / DeepSeek / Copilot / otra) | Prompt (resumen o enlace) | ¿Qué respondió? | ¿Era correcto? ¿Cómo lo verifiqué? | ¿Lo usé? (sí / no / modificado) |
|---|---|---|---|---|---|
| 1 |ChatGPT |¿Por qué Maven no encuentra el archivo pom.xml? |Identificó que estaba en la carpeta incorrecta. |.Ingresé a la carpeta interna. | |
| 2 |ChatGPT| Analizar el resultado de mvn test.|Identificó que el reporte devuelve CSV en lugar de JSON. |Registré la prueba fallida. | |
| 3 || 3 | ChatGPT | ¿Cómo crear una prueba para detectar el error de las comas en CSV? | Sugirió una prueba con JUnit 5 para verificar el manejo de las comas. | Acepté la propuesta, ejecuté la prueba y comprobé que el error existe. |
| 4 | ChatGPT | ¿Cómo comprobar el error de las comillas en JSON? | Sugirió crear una prueba con un producto que contiene comillas. | Acepté la propuesta y comprobé el tercer error mediante Maven. |
| 5 | ChatGPT | Análisis del patrón Bridge mediante el prompt estructurado. | Identificó los tres errores y propuso correcciones y pruebas unitarias. | Las propuestas son adecuadas, pero falta comprobarlas mediante Maven. |
| 6 | Gemini | Análisis del patrón Bridge mediante el mismo prompt estructurado. | Identificó los tres errores y propuso soluciones. | Detecté un problema en las pruebas y una corrección incompleta de JSON. |
| 7 | DeepSeek | Análisis del patrón Bridge mediante el mismo prompt estructurado. | Reconoció los tres tipos de errores y propuso un cuarto error sin evidencia. | Rechacé varias propuestas porque modificaban la estructura original y no cumplían las restricciones. |

## 3. Jurado de IAs

Envía el **mismo prompt** a tres herramientas distintas y compara.

| Pregunta enviada | ChatGPT | Gemini | DeepSeek | ¿Quién acertó? ¿En qué discreparon? |
|| Análisis del patrón Bridge y sus reglas de negocio | Identificó los 3 errores y propuso soluciones adecuadas. | Identificó los 3 errores, pero presentó problemas en las pruebas y en la corrección de JSON. | Pendiente | ChatGPT presentó soluciones más completas. Falta comparar DeepSeek. |
| Análisis del patrón Bridge y sus reglas de negocio | Identificó correctamente los tres errores y propuso soluciones completas. | Identificó los tres errores, pero presentó problemas en las pruebas y en JSON. | Reconoció los tipos de errores, pero inventó código y propuso cambios innecesarios. | ChatGPT acertó mejor. Las diferencias estuvieron en las pruebas, el manejo de JSON y el respeto de la estructura original. |

## 4. Errores encontrados y corregidos

| # | Error | Prueba que lo demuestra (nombre del método de prueba) | Commit de la corrección | ¿Lo encontré yo, la IA o ambos? |
|---|---|---|---|---|
| 1 | El inventario siempre generaba CSV sin respetar el formato recibido. | inventarioEnJson() | Se cambió super(new FormatoCsv()) por super(formato). | 9deef22 |
| 2 | El CSV no manejaba correctamente los caracteres especiales. | csvConComas() | 381c785 | Ambos |
| 3 | El JSON no escapaba correctamente los caracteres especiales. | jsonConComillas() | 4e3a37c | Ambos |

## 5. Lo que la IA hizo mal o no vio

Describe por lo menos un caso en que la IA se equivocó, inventó algo o propuso un cambio peligroso. ¿Cómo te diste cuenta?
Gemini propuso crear otro record llamado Existencia, aunque el proyecto ya tenía esa clase, lo que podía generar problemas de compilación. También dejó incompleta la corrección de JSON.

Por otro lado, DeepSeek inventó un cuarto error y propuso cambiar métodos que ya existían en el proyecto. Me di cuenta al comparar sus respuestas con el código original y las reglas de negocio. Esto me permitió entender que no todas las soluciones de la IA son correctas y que debo revisarlas antes de aplicarlas.
### Revisión de seguridad

Se revisó el manejo de caracteres especiales en los formatos CSV y JSON. Las correcciones permiten evitar que las comillas, las comas y otros caracteres dañen la estructura de los reportes.

También se identificó que los archivos CSV podrían presentar riesgos al abrirse en Excel si contienen fórmulas maliciosas. Este riesgo queda como una posible mejora de seguridad.

No se agregaron dependencias externas y las seis pruebas unitarias finalizaron correctamente.

## 6. Reflexión final (5 a 10 líneas)

¿Qué parte del trabajo aceleró la IA? ¿En qué momento decidiste **no** usarla y por qué? ¿Qué aprendiste del patrón que no sabías antes?
Con esta actividad aprendí cómo funciona el patrón Bridge y cómo identificar errores mediante pruebas unitarias.
También aprendí a comparar las respuestas de diferentes inteligencias artificiales.
Me di cuenta de que no todas las soluciones que ofrecen son correctas.
Por eso es importante revisar el código antes de aplicar cualquier cambio.
Logré corregir los tres errores sin cambiar la estructura del patrón.
También mejoré la organización del código y comprobé su funcionamiento con Maven.
Finalmente, aprendí a registrar y subir cada cambio utilizando Git y GitHub.