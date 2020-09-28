Instrucciones para obtener los resultados.

Primero compilar el programa de Java. 
  javac -g NombreClaseYArchivo.java

Nos devuelve un .class  

Para correr el analisis SOOT especificado en -p jap.rdtagger (Aca 
corrimos el analisis Reach Definition)

Observacion: Si nos tira error al ejecutar el comando de SOOT puede que se deba a que para cada terminal 
tengo que exportar la definicion de JRE: export JRE=/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/rt.jar

Para el Ejercicio 1
  Compilo: javac -g Ejercicio1.java
  Corro el Reaching Definition Analysis
java -cp .:soot-3.3.0-jar-with-dependencies.jar:. soot.Main -cp
 .:$JRE -f J Ejercicio1 -print-tags -p jap.rdtagger enabled:true 
 -p jb use-original-names:true -p jb.cp off -keep-line-number

Para el Ejercicio 2
  Compilo: javac -g Ejercicio2.java
  Corro el Live Variable Analysis:
java -cp .:soot-3.3.0-jar-with-dependencies.jar:. soot.Main -cp
 .:$JRE -f J Ejercicio2 -print-tags -p jap.lvtagger enabled:true 
 -p jb use-original-names:true -p jb.cp off -keep-line-number

Para el Ejercicio 3
  Compilo: javac -g Ejercicio3.java
  Corro el Null Pointer Check:
java -cp .:soot-3.3.0-jar-with-dependencies.jar:. soot.Main -cp 
.:$JRE -f J Ejercicio3 -print-tags -p jap.npc enabled:true -p
jb use-original-names:true -p jb.cp off -keep-line-number

