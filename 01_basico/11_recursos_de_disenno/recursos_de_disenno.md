# Recursos de diseño

[TOC]

Siempre debes externalizar los recursos como imágenes y cadenas del código de tu aplicació para que puedas mantenerlos de forma independiente. Externalizar los recursos también te permite proporcionar recursos alternativos que admiten configuraciones específicas de los dispositivos como la orientación de la pantalla, los distintos tamaños de pantalla, soporte de idiomas, etc, lo que cada vez es más importante, ya que más dispositivos con tecnología Android están disponibles con configuraciones diferentes. 
En este curso hablaremos de algunos de estos recursos.



## Orientación del dispositivo.

Cuando desarrollamos una aplicación en Android, la interfaz que nos muestra la actividad que estamos utilizando puede ser visualizada de dos maneras, en modo portrait (retrato) o modo landscape (paisaje). 



![](img\portrait.png)



Para cambiar la orientación de una app en Android debemos acceder a nuestro archivo AndroidManifest.xml de la siguiente manera:

```xml
<activity
    android:name="miApp"
    android:label="@string/miApp"
    android:screenOrientation="portrait"> <!--portrait -> vertical, landscape -> Horizontal-->
</activity>
```



## Tamaños de pantalla.

El sistema operativo Android se ejecuta en una gran variedad de dispositivos, casi todos ellos con diferentes tamaños, por esta razón, cuando desarrollamos una aplicación debemos tener bien en cuenta que, de no tener el cuidado adecuado, nuestro diseño podría variar entre la gran gama de equipos que utilizan Android.

Para que nuestra aplicación funcione en diferentes pantallas, el sistema Android realiza diversos ajustes y cambios de tamaño. Sin embargo, también existen otras técnicas de programación para optimizar, de manera tal que tus aplicaciones funcionen en diferentes tamaños y densidades de pantalla. Para ello necesitamos aclarar los siguientes conceptos.

Tamaño de pantalla: Es el tamaño físico real que representa la longitud de la diagonal de la pantalla.
En android, se agrupan todos los tamaños de pantallas reales en cuatro categorías generalizadas: pequeño, normal, grande y extragrande.

Densidad de pantalla: Se trata de la cantidad de pixeles que hay dentro del área de la pantalla. En general, se hace referencia a la densidad de pantalla como “dpi” (dots per inch o puntos por pulgada).
En Android, se agrupan todas las densidades de pantallas en seis categorías generalizadas: baja, media, alta, extraalta, extra extraalta y extra extra extraalta.



![](img\screens-ranges.png)



Resolución: Es el número total de píxeles físicos en una pantalla.
Las aplicaciones no tienen una interacción directa con la resolución, se centra únicamente en la densidad y el tamaño de pantalla.

Píxeles independientes de la densidad (dp): Es la unidad de píxeles virtuales que se deben usar al definir el diseño de nuestra interfaz de usuario (UI). Se utilizan para expresar las dimensiones o la posición del diseño con independencia de la densidad.
El píxel independiente de la densidad es equivalente a un píxel físico en una pantalla de 160 dpi, valor que representa la densidad de referencia que considera el sistema para una pantalla de densidad “media”. La conversión de unidades dp a píxeles de pantalla es la siguiente:

 \mathbf{px} = \mathbf{dp} \times \frac{dpi}{160} 



## Soporte de idiomas.

Es siempre una buena práctica extraer los strings que aparecen en la UI de tu app y mantenerlos en un archivo externo,  string.xml. Android facilita esta tarea con un directorio de recursos para cada proyecto Android. De este modo puedes dar soporte de diferentes idiomas.
 Dentro de este directorio  res/ se encuentran diferentes tipos de recursos en varios subdirectorios. El que nos interesa es el directorio  res/values/strings.xml, el cual contendrá los valores strings de tu app (las cadenas de texto).

Para dar soporte a más idiomas, crea directorios adicionales de  values dentro de  res/ los cuales incluyen un guión y el código del idioma ISO al final del nombre del directorio. Por ejemplo,  values-es/ es el directorio que contiene recursos para el idioma asociado al código “es” (español de España). Android carga los recursos apropiados en tiempo de ejecución en función de los ajustes del dispositivo.

Una vez que decidas a que lenguajes vas a dar soporte, crea los diferentes subdirectorios y los archivos de recursos strings. Por ejemplo:

![img\lenguajes.png](img\lenguajes.png)

Después, debemos añadir los valores apropiados para cada recurso string dentro de cada uno de dichos archivos `strings.xml`.

Por ejemplo, en ingles: 

![](img\strings.png)

### Uso de recursos String.

Puedes hacer referencia a tus recursos string en tu código fuente y otros archivos XML utilizando el nombre del recurso definido por el atributo name del  <string>.

En tu código fuente se traduce del siguiente modo:  R.string.tu_string. Hay una amplia variedad de métodos que aceptan un recurso de string de este modo.

Por ejemplo:



![](img\usoApp.png)



En otros archivos XML, puedes hacer referencia a un recurso String de la siguiente forma,  @string/tu_string siempre que el atributo XML acepte un valor string.

Por ejemplo:

![](img\usoXml.png)





















