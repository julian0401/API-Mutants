

Introducción
Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men. 

Se ha desarrollado una API REST para detectar secuencias de ADN dentro de un ADN dado. Dicha API recibe como parámetro un array de Strings que representan cada fila de una tabla de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las cuales representa cada base nitrogenada del ADN.

Un humano es mutante si encuentra más de una secuencia de cuatro letras iguales​, de forma oblicua, horizontal o vertical.

El repositorio se encuentra dividido de la siguiente manera

Carpeta Base de Datos se encuentra el script correspondiente a la base de datos creada en el motor Maria DB
En la carpeta Desafio1_Algoritmo donde se aloja el proyecto del algortimo el cual se puede ejecutar en la consola de java
La carpeta Desafio2_3 contiene la API rest desarrollada en Java Jax RS
y por ultimo la carpeta implementacion donde se encuentran algunas imagenes  sobre las implementaciones y pruebas

**Instrucciones para su prueba

El servicio se encuentra despplegado en 

http://apimutants-env-1.eba-jtxxemed.us-east-2.elasticbeanstalk.com/API-Mutants

El servicio actualmente cuenta con los siguientes métodos:

Método POST para detectar si un ADN dado es mutante:

La URL del método es http://apimutants-env-1.eba-jtxxemed.us-east-2.elasticbeanstalk.com/API-Mutants/mutant

Se puede detectar si un humano es mutante enviando la secuencia de ADN mediante un HTTP POST con un Json el cual tenga el siguiente formato:

POST → /mutant/
{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}

En caso de verificar que el ADN enviado es mutante, el método devuelve como respuesta un HTTP 200-OK, en caso contrario un 403-Forbidden

Método GET para obtener las estadísticas de las verificaciones de ADN para Magneto

La URL del método es http://apimutants-env-1.eba-jtxxemed.us-east-2.elasticbeanstalk.com/API-Mutants/stats

Para realiza la prueba al API en la carpeta Desafio2_3 se encuentra un JSON el cual puede implementar en postam donde tambien se enceuntran los tcases automatizados

Descarga del código fuente de la carpeta Desafio2_3
Este proyecto utiliza Apache Maven. Antes de empezar, asegurese de descargarlo e instalarlo. Luego, Maven descargará automáticamente las librerias requeridas por el proyecto

Repositorio
El código se encuentra alojado en github. Para descargarlo necesita un cliente git, que puede encontrarlo en https://git-scm.com/downloads

Cree una carpeta en donde se incluirá el código fuente
Abra su consola y posicionese en la carpeta previamente creada
Ejecute el comando
git clone https://github.com/julian0401/API-Mutants.git

Environment
Java8
Eclipse
Maven
Jersey
Postman
AWS Elastic Beanstalk
AWS RDS MariaDB
