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
| 1 | | | | | |
| 2 | | | | | |
| 3 | | | | | |

## 3. Jurado de IAs

Envía el **mismo prompt** a tres herramientas distintas y compara.

| Pregunta enviada | ChatGPT | Gemini | DeepSeek | ¿Quién acertó? ¿En qué discreparon? |
|---|---|---|---|---|
| | | | | |

## 4. Errores encontrados y corregidos

| # | Error | Prueba que lo demuestra (nombre del método de prueba) | Commit de la corrección | ¿Lo encontré yo, la IA o ambos? |
|---|---|---|---|---|
| 1 | | | | |
| 2 | | | | |
| 3 | | | | |

## 5. Lo que la IA hizo mal o no vio

Describe por lo menos un caso en que la IA se equivocó, inventó algo o propuso un cambio peligroso. ¿Cómo te diste cuenta?

## 6. Reflexión final (5 a 10 líneas)

¿Qué parte del trabajo aceleró la IA? ¿En qué momento decidiste **no** usarla y por qué? ¿Qué aprendiste del patrón que no sabías antes?
