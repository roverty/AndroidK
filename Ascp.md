# Android

[TOC]

## Android problems
Esta es un lista de los problemas más comunes de android estudio, la mayoría de estos problemas se debe a la gran cantidad de versiones de módulos con los que el IDE trabaja.
### No se ve nada en PREVIEW
Este error se debe al appcompat, solo debemos localizar una versión compatible con nuestro IDE, por ejemplo, a la fecha, 5 de agosto de 2018, la versión beta1, no funciona apropiadamente por lo que retrocedí a la versión alpha1.

Esto se logra accediendo al achivo app del graddle, es decir.

`Gradle Scripts->build.gradle(Module:app)`

```Android
implementation 'com.android.support:appcompat-v7:28.0.0-alpha1'
```

Chambiar `alpha` dependiendo de nuestra necesidad.

Por último hay que sincronizar, click en `sync now`